package net.haesleinhuepf.clij.macro.documentation;


import net.haesleinhuepf.clij.macro.CLIJMacroPlugin;
import net.haesleinhuepf.clij.macro.CLIJMacroPluginService;

import java.util.HashMap;

/**
 * The AbstractDocumentationGenerator contains common methods for documentation generation.
 *
 * Author: @haesleinhuepf
 * 12 2018
 */
public class AbstractDocumentationGenerator {
    protected static boolean isOutputParameter(String parameter) {
        return (parameter.contains("ClearCLImage") || parameter.contains("ClearCLBuffer")) && (parameter.contains("destination") || parameter.contains("dst") || parameter.contains("output"));
    }

    protected static boolean isInputParameter(String parameter) {
        return (parameter.contains("ClearCLImage") || parameter.contains("ClearCLBuffer")) && (!parameter.contains("destination") && !parameter.contains("dst") && !parameter.contains("output"));
    }

    protected static String findDocumentation(CLIJMacroPluginService service, String methodName, StringBuilder parametersWithType) {
        String specialCaseDocumentation = getSpecialCaseDocumentation(methodName);
        if (specialCaseDocumentation.length() > 0) {
            return specialCaseDocumentation;
        }

        if (methodName.endsWith("IJ")) {
            return "This method is deprecated. Consider using " + methodName.replace("IJ", "Box") + " or " + methodName.replace("IJ", "Sphere") + " instead.";
        }

        String[] potentialMethodNames = {
                "CLIJ_" + methodName,
                "CLIJ_" + methodName + "2D",
                "CLIJ_" + methodName + "3D",
                "CLIJ_" + methodName + "Images",
                "CLIJ_" + methodName.replace( "Sphere", "2DBox"),
                "CLIJ_" + methodName.replace( "Sphere", "3DBox"),
                "CLIJ_" + methodName.replace( "Box", "2DBox"),
                "CLIJ_" + methodName.replace( "Box", "3DBox"),
                "CLIJ_" + methodName.replace( "Pixels", "OfAllPixels"),
                "CLIJ_" + methodName.replace( "SliceBySlice", "3DSliceBySlice")
        };

        for (String name : potentialMethodNames) {
            name = findName(service, name);
            CLIJMacroPlugin plugin = service.getCLIJMacroPlugin(name);
            if (plugin != null) {
                if (plugin instanceof OffersDocumentation) {
                    return ((OffersDocumentation) plugin).getDescription();
                } else {
                    return plugin.getParameterHelpText();
                }
            }
        }

        System.out.println("No documentation found for " + methodName);
        return "";
    }

    protected static String findName(CLIJMacroPluginService service, String name) {
        for (String potentialName : service.getCLIJMethodNames()) {
            if (potentialName.toLowerCase().compareTo(name.toLowerCase()) == 0) {
                return potentialName;
            }
        }
        return name;
    }

    // todo: put special case documentation into CLIJ_ repository
    private static HashMap<String, String> specialCaseDocumentation = null;
    protected static String getSpecialCaseDocumentation(String methodName) {
        initSpecialCaseDocumentation();
        if (specialCaseDocumentation.containsKey(methodName)) {
            return specialCaseDocumentation.get(methodName);
        }
        return "";
    }

    protected static void initSpecialCaseDocumentation() {
        if (specialCaseDocumentation != null) {
            return;
        }

        specialCaseDocumentation = new HashMap<String, String>();
        specialCaseDocumentation.put("crop",
                "Crops out a region of a 2D image or a substack out of a given image stack. Size of the region is determined from the given destination image stack.");
        specialCaseDocumentation.put("copySlice",
                "Copies a slice with a given index out of an input image stack into a 2D image, if 3D and 2D image are given as parameters. Or" +
                        "Copies a given slice into a given image stack, if 2D and 3D images are given as parameters.");
        specialCaseDocumentation.put("countNonZeroPixelsLocally", "Counts non-zero pixels in the neighborhood of every pixel in a 2D image and writes the resulting count in the corresponding pixel of the target image.");
        specialCaseDocumentation.put("countNonZeroPixelsLocallySliceBySlice", "Counts non-zero pixels in the 2D-neighborhood of every pixel in a 3D image stack and writes the resulting count in the corresponding pixel of the target image.");
        specialCaseDocumentation.put("countNonZeroVoxelsLocally", "Counts non-zero pixels in the 2D-neighborhood of every pixel in a 3D image stack and writes the resulting count in the corresponding pixel of the target image.");
        specialCaseDocumentation.put("detectOptima", "It is recommended to detectMaxima and detectMinima.");
        specialCaseDocumentation.put("detectOptimaSliceBySlice", "It is recommended to detectMaximaSliceBySlice and detectMinimaSliceBySlice.");
        specialCaseDocumentation.put("splitStack", "Splits an input stack into #n# image stacks. \n" +
                " * Slices 0, n, 2*n, ... will become part of the first output stack.\n" +
                " * Slices 1, n+1, 2*n+1, ... will become part of the second output stack.\n" +
                "Only up to 12 output stacks are supported.");
        specialCaseDocumentation.put("sumPixelsSliceBySlice", "Sums all pixels in X and Y slice by slice and returns the resulting numbers for all slices as an array.");
        specialCaseDocumentation.put("radialProjection", "Computes a radial projection of an image stack. Starting point for the line is the center in any \n" +
                "X/Y-plane of a given input image stack. " +
                "This operation is similar to ImageJs 'Radial Reslice' method but offers less flexibility.");

        specialCaseDocumentation.put("fillHistogram", "Generates a histogram of a 2D image or 3D stack and writes into a 2D image where X corresponds to the bin index and Y corresponds to the count of found pixels.");
        specialCaseDocumentation.put("multiplyImageAndCoordinate", "Multiply every pixel intensity with its X/Y/Z coordinate depending on given dimension.\n" +
                "This method can be used to calculate the center of mass of an image.");
        specialCaseDocumentation.put("multiplySliceBySliceWithScalars", "Multiplies all pixels value x in input image X with a scalar s given as an array with values for every z-slice.");
        specialCaseDocumentation.put("affineTransform2D", "Applies an affine transform to a 2D image.\n");
        specialCaseDocumentation.put("affineTransform3D", "Applies an affine transform to a 3D image.\n");
        specialCaseDocumentation.put("convertToImageJBinary", "Convert a binary image to an image with values 0 and 255 as it can be interpreted by ImageJ as binary image.");
    }

    protected static String createOutputImageCode(String methodName, String parameterName, String inputImage) {
        if (methodName.compareTo("resliceTop") == 0 ||
                methodName.compareTo("resliceBottom") == 0 ) {
            return parameterName + " = clij.create(new long[]{" + inputImage + ".getWidth(), " + inputImage + ".getDepth(), " + inputImage + ".getHeight()}, " + inputImage + ".getNativeType());\n";
        } else if (methodName.compareTo("resliceLeft") == 0 ||
                methodName.compareTo("resliceRight") == 0 ) {
            return parameterName + " = clij.create(new long[]{" + inputImage + ".getHeight(), " + inputImage + ".getDepth(), " + inputImage + ".getWidth()}, " + inputImage + ".getNativeType());\n";
        } else if (methodName.compareTo("maximumZProjection") == 0 ||
                methodName.compareTo("maximumXYZProjection") == 0  ||
                methodName.compareTo("meanZProjection") == 0  ||
                methodName.compareTo("copySlice") == 0  ||
                methodName.compareTo("minimumZProjection") == 0 ) {
            return parameterName + " = clij.create(new long[]{" + inputImage + ".getWidth(), " + inputImage + ".getHeight()}, " + inputImage + ".getNativeType());\n";
        } else if (methodName.compareTo("convertToImageJBinary") == 0) {
            return "from net.haesleinhuepf.clij.coremem.enums import NativeTypeEnum;\n" +
                    "ClearCLBuffer " + parameterName + " = clij.create(" + inputImage + ".getDimensions(), " + inputImage + ".getHeight()], NativeTypeEnum.UnsignedByte);\n";
        } else {
            return parameterName + " = clij.create(" + inputImage + ");\n";
        }
    }


}
