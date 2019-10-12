package net.haesleinhuepf.clij.macro.documentation;

import net.haesleinhuepf.clij.macro.CLIJMacroPlugin;
import net.haesleinhuepf.clij.macro.CLIJMacroPluginService;
import org.scijava.Context;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * OpGenerator
 * <p>
 * <p>
 * <p>
 * Author: @haesleinhuepf
 * 01 2019
 */
public class MarkdownGroovyOpDocumentationGenerator extends AbstractDocumentationGenerator  {
    final static String rootFolder = "C:/structure/code/clij-core/";

    public static void main(String ... args) throws IOException {
        File inputFile = new File(rootFolder + "src/main/java/net/haesleinhuepf/clij/kernels/Kernels.java");

        CLIJMacroPluginService service = new Context(CLIJMacroPluginService.class).getService(CLIJMacroPluginService.class);

        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        StringBuilder builder = new StringBuilder();
        builder.append("# CLIJ reference for ImageJ Groovy\n\n");


        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("public class")) {
                break;
            }
        }

        ArrayList<String> blocks = new ArrayList<String>();

        int methods = 0;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("public")) {


                String[] temp = line.split("\\(");

                String methodDefinition = temp[0].trim();
                String parameters = temp[1].trim();
                parameters = parameters.replace(")", "");
                parameters = parameters.replace("{", "");

                temp = methodDefinition.split(" ");
                String methodName = temp[temp.length - 1];
                String returnType = temp[temp.length - 2];

                temp = parameters.split(",");
                StringBuilder parametersWithType = new StringBuilder();
                StringBuilder parametersForCall = new StringBuilder();

                int count = 0;
                for (String parameter : temp) {
                    String[] temp2 = parameter.trim().split(" ");
                    if (count > 0) {

                        if (count > 1) {
                            parametersForCall.append(", ");
                            parametersWithType.append(", ");
                        }
                        parametersForCall.append(temp2[temp2.length - 1]);
                        parametersWithType.append(parameter);
                    }
                    count++;
                }

                // only document CLBuffer methods for now...
                if (!parametersWithType.toString().contains("ClearCLImage")) {
                    String description = findDocumentation(service, methodName, parametersWithType);

                    String output = "<a name=\"" + methodName + "\"></a>\n" +
                            "## " + methodName + "(" + parametersWithType.toString() + ")\n\n" +
                            description + "\n\n**Parameters**: " + parametersWithType.toString() + "\n\n**Groovy example**: \n```\n" + generateExampleCode(methodName, parametersWithType.toString(), parametersForCall.toString(), returnType) + "```\n\n";

                    String linkToExamples = searchForExampleScripts("op()." + methodName, "src/main/groovy/", "https://github.com/clij/clij-docs/blob/master/src/main/groovy/");
                    if(linkToExamples.length() > 0) {
                        output = output + "\n\n### Example scripts\n" + linkToExamples + "\n\n";
                    }

                    blocks.add(output);
                    methods++;
                }
            }
        }

        Collections.sort(blocks);
        for(String block : blocks) {
            builder.append(block);
        }

        builder.append("\n");
        builder.append("Documented " + methods + " methods.\n");

        File outputTarget = new File("referenceGroovy.md");

        FileWriter writer = new FileWriter(outputTarget);
        writer.write(builder.toString());
        writer.close();

    }

    private static String generateExampleCode(String methodName, String parametersWithType, String parameters, String returnType) {

        // just some example numbers for example code
        float[] floatParameterValues = {1,2,3,4,5,6,7};
        int[] integerParameterValues = {10,20,30,40,50,60,70};
        boolean[] booleanParameterValues = {true, false, false, true};
        int floatParameterIndex = 0;
        int integerParameterIndex = 0;
        int booleanParameterIndex = 0;

        StringBuilder code = new StringBuilder();

        code.append("// init CLIJ and GPU\n");
        code.append("import net.haesleinhuepf.clij.CLIJ;\n");
        code.append("clij = CLIJ.getInstance();\n\n");

        code.append("// get input parameters\n");
        String[] parametersArray = parametersWithType.split(",");
        String inputImage = "";
        for (String parameter : parametersArray) {
            parameter = parameter.trim();
            String parameterName = parameter.split(" ")[1];
            if (isInputParameter(parameter)) {
                if (inputImage.length() == 0) {
                    inputImage = parameterName;
                }
                code.append(parameterName + " = clij.push(" + parameterName + "ImagePlus);\n");
            } else if (isOutputParameter(parameter)) {
                code.append(createOutputImageCode(methodName, parameterName, inputImage));
            } else if (parameter.startsWith("Float")) {
                code.append(parameterName + " = " + floatParameterValues[floatParameterIndex]+ ";\n");
                floatParameterIndex++;
            } else if (parameter.startsWith("Integer")) {
                code.append(parameterName + " = " + integerParameterValues[integerParameterIndex] + ";\n");
                integerParameterIndex++;
            } else if (parameter.startsWith("Boolean")) {
                code.append(parameterName + " = " + booleanParameterValues[booleanParameterIndex] + ";\n");
                booleanParameterIndex++;
            } else if (parameter.startsWith("AffineTransform3D")) {
                code.append("import net.imglib2.realtransform.AffineTransform3D;\n");
                code.append("at = new AffineTransform3D();\n" +
                        "at.translate(4, 0, 0);\n");
            } else if (parameter.startsWith("AffineTransform2D")) {
                code.append("import net.imglib2.realtransform.AffineTransform2D;\n");
                code.append("at = new AffineTransform2D();\n" +
                        "at.translate(4, 0);\n");
            }
        }


        code.append("```\n\n```");
        code.append("\n// Execute operation on GPU\n");
        if (returnType.toLowerCase().compareTo("boolean") != 0) {
            code.append("result" + methodName.substring(0,1).toUpperCase() + methodName.substring(1, methodName.length()) + " = ");
        }
        code.append("clij.op()." + methodName + "(" + parameters + ");\n");
        code.append("```\n\n```");

        code.append("\n//show result\n");
        if (returnType.toLowerCase().compareTo("boolean") != 0) {
            code.append("print(result" + methodName.substring(0,1).toUpperCase() + methodName.substring(1, methodName.length()) + ");\n");
        }

        for (String parameter : parametersArray) {
            parameter = parameter.trim();
            String parameterName = parameter.split(" ")[1];
            if (isOutputParameter(parameter)) {
                code.append(parameterName + "ImagePlus = clij.pull(" + parameterName + ");\n");
                code.append(parameterName + "ImagePlus.show();\n");
            }
        }


        code.append("\n// cleanup memory on GPU\n");
        for (String parameter : parametersArray) {
            parameter = parameter.trim();
            String parameterName = parameter.split(" ")[1];
            if (isInputParameter(parameter) || isOutputParameter(parameter)) {
                code.append(parameterName + ".close();\n");
            }
        }

        return code.toString();
    }



}
