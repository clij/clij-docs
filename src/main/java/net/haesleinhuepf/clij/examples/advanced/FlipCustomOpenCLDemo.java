package net.haesleinhuepf.clij.examples.advanced;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.plugin.Duplicator;
import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.clearcl.ClearCLBuffer;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.display.imagej.ImageJFunctions;
import net.imglib2.type.numeric.integer.UnsignedShortType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This
 * <p>
 * Author: Robert Haase (http://haesleinhuepf.net) at MPI CBG (http://mpi-cbg.de)
 * February 2018
 */
public class FlipCustomOpenCLDemo {
    public static void main(String... args) throws IOException {
        new ImageJ();
        ImagePlus lInputImagePlus = IJ.openImage("https://github.com/clij/clij-docs/raw/master/src/main/resources/flybrain.tif");

        RandomAccessibleInterval<UnsignedShortType> input = ImageJFunctions.wrap(lInputImagePlus);

        RandomAccessibleInterval<UnsignedShortType> output = ImageJFunctions.wrap(new Duplicator().run(lInputImagePlus));

        ImageJFunctions.show(input);

        CLIJ clij = CLIJ.getInstance();

        // ---------------------------------------------------------------
        // Example 1: Flip image in X
        {
            ClearCLBuffer srcImage = clij.push(input);
            ClearCLBuffer dstImage = clij.push(output);

            Map<String, Object> lParameterMap = new HashMap<>();
            lParameterMap.put("src", srcImage);
            lParameterMap.put("dst", dstImage);
            lParameterMap.put("flipx", 1);
            lParameterMap.put("flipy", 0);
            lParameterMap.put("flipz", 0);

            clij.execute("src/main/java/net/haesleinhuepf/clij/examples/advanced/flip.cl", "flip_3d", lParameterMap);

            ImagePlus result = clij.pull(dstImage);
            result.show();
            IJ.run(result,"Enhance Contrast", "saturated=0.35");
        }

    }
}
