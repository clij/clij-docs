package net.haesleinhuepf.clij.examples;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.clearcl.ClearCLBuffer;
import net.imglib2.realtransform.AffineTransform3D;

/**
 * MaximumProjectionDemo
 * <p>
 * <p>
 * <p>
 * Author: @haesleinhuepf
 * 06 2019
 */
public class MaximumProjectionDemo {
    public static void main(String[] args) {
        new ImageJ();

        // load example image
        ImagePlus input = IJ.openImage("https://imagej.nih.gov/ij/images/t1-head.zip");

        // initialize GPU
        CLIJ clij = CLIJ.getInstance();

        // push image to GPU
        ClearCLBuffer inputOnGPU = clij.push(input);
        // create memory for target
        ClearCLBuffer resultOnGPU = clij.create(new long[]{inputOnGPU.getWidth(), inputOnGPU.getHeight()}, inputOnGPU.getNativeType());

        // apply transform
        clij.op().maximumZProjection(inputOnGPU, resultOnGPU);

        // retrieve result or show it
        ImagePlus result = clij.pull(resultOnGPU);
        clij.show(resultOnGPU, "result");

        // free memory
        inputOnGPU.close();
        resultOnGPU.close();
    }
}
