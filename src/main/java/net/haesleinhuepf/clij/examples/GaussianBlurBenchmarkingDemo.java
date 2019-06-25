package net.haesleinhuepf.clij.examples;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.Duplicator;
import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.clearcl.ClearCLBuffer;
import net.imagej.ImageJ;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;
import net.imglib2.img.display.imagej.ImageJFunctions;
import net.imglib2.type.BooleanType;
import net.imglib2.type.numeric.RealType;

import java.io.IOException;

/**
 * GaussianBlurBenchmarkingDemo
 * <p>
 * <p>
 * <p>
 * Author: @haesleinhuepf
 * 06 2019
 */
public class GaussianBlurBenchmarkingDemo {

    private static ImageJ ij;
    private static CLIJ clij;
    private static double sigma = 3;

    public static void main(String... args) throws IOException {

        // ---------------------------------------
        // Initialize ImageJ, CLIJ and test image
        ij = new ImageJ();
        ij.ui().showUI();
        clij = CLIJ.getInstance();

        input = IJ.openImage("https://imagej.net/images/flybrain.zip");
        input.show();
        IJ.run(input, "8-bit", "");
        img = ImageJFunctions.wrapReal(input);

        for (int i = 0; i < 100; i++) {
            // ---------------------------------------
            // three test scenarios
            long timestamp = System.currentTimeMillis();
            demoImageJ1();
            System.out.println("The ImageJ1 way took " + (System.currentTimeMillis() - timestamp) + " msec");

            timestamp = System.currentTimeMillis();
            demoImageJ2();
            System.out.println("The ImageJ2 way took " + (System.currentTimeMillis() - timestamp) + " msec");

            timestamp = System.currentTimeMillis();
            demoCLIJ();
            System.out.println("The CLIJ way took " + (System.currentTimeMillis() - timestamp) + " msec");
            // ---------------------------------------
            System.out.println("-----");
        }
    }

    private static ImagePlus input;
    private static Img img;

    private static void demoImageJ1() {
        ImagePlus copy = new Duplicator().run(input, 1, input.getNSlices());
        IJ.run(copy, "Gaussian Blur 3D...", "x=" + sigma + " y=" + sigma + " z=" + sigma + "");
        copy.show();
    }

    private static <T extends RealType<T>, B extends BooleanType<B>> void demoImageJ2() {
        RandomAccessibleInterval gauss = ij.op().filter().gauss(img, sigma);
        ImageJFunctions.show(gauss);
    }

    private static void demoCLIJ() throws IOException {
        ClearCLBuffer input = clij.push(img);
        ClearCLBuffer blurred = clij.create(input);

        clij.op().blur(input, blurred, (float) sigma, (float) sigma, (float) sigma);

        clij.pull(blurred).show();

        blurred.close();
        input.close();
    }
}
