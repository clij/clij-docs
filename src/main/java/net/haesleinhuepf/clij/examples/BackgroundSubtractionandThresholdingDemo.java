package net.haesleinhuepf.clij.examples;

import ij.IJ;
import ij.ImagePlus;
import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.clearcl.ClearCLBuffer;
import net.haesleinhuepf.clij.kernels.Kernels;

/**
 * LocalThresholdDemo
 * <p>
 * <p>
 * <p>
 * Author: @haesleinhuepf
 * 06 2018
 */
public class BackgroundSubtractionandThresholdingDemo {
    public static void main(String... args) {
        ImagePlus imp = IJ.openImage("src/main/resources/droso_crop.tif");

        CLIJ clij = CLIJ.getInstance();

        // conversion
        ClearCLBuffer input = clij.push(imp);
        ClearCLBuffer output = clij.create(input);
        ClearCLBuffer background = clij.create(input);
        ClearCLBuffer backgroundSubtracted = clij.create(input);

        // blur
        clij.op().meanBox(input, background, 2, 2, 2);

        // background subtraction
        clij.op().subtract(input, background, backgroundSubtracted);

        // threshold
        clij.op().automaticThreshold(backgroundSubtracted, output, "Otsu");

        // show results
        clij.show(input, "original");
        clij.show(output, "mask");

        input.close();
        output.close();
        background.close();
        backgroundSubtracted.close();
    }
}
