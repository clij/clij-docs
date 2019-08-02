package net.haesleinhuepf.clij.examples;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.clearcl.ClearCLBuffer;

/**
 * BinaryProcessingDemo
 *
 * This java example shows how to apply an automatic
 * threshold method to an image in the GPU.
 *
 * Author: @haesleinhuepf
 * June 2019
 */
public class BinaryProcessingDemo {
    public static void main(String[] args) {
        new ImageJ();

        // get test image
        ImagePlus imp = IJ.openImage("https://samples.fiji.sc/blobs.png");
        IJ.run(imp,"32-bit", "");
        imp.setTitle("blobs");


        // init GPU
        CLIJ clij = CLIJ.getInstance();

        // push image to GPU and allocate memory for result
        ClearCLBuffer blobsGPU = clij.push(imp);
        ClearCLBuffer thresholded = clij.create(blobsGPU);
        ClearCLBuffer temp = clij.create(blobsGPU);

        // apply threshold
        clij.op().automaticThreshold(blobsGPU, thresholded, "Otsu");

        // binary opening
        clij.op().erodeBox(thresholded, temp);
        clij.op().erodeBox(temp, thresholded);
        clij.op().dilateBox(thresholded, temp);
        clij.op().dilateBox(temp, thresholded);

        // show result
        ImagePlus result = clij.pullBinary(thresholded);
        result.show();

        // cleanup
        blobsGPU.close();
        thresholded.close();

    }
}
