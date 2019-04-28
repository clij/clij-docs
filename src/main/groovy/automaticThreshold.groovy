// automaticThreshold.groovy
// =========================
//
// Apply an automatic threshold method to an image on the GPU
//
// Author: Robert Haase, rhaase@mpi-cbg.de
//         April 2019
//////////////////////////////////////////

import ij.IJ;
import net.haesleinhuepf.clij.CLIJ;


IJ.run("Close All");

// load example image
imp = IJ.openImage("c:/structure/code/clij-docs/src/main/resources/blobs.tif");
imp.show();

// init GPU
clij = CLIJ.getInstance();

// push image to GPU
input = clij.push(imp);

// reserve memory for output, same size and type as input
output = clij.create(input);

// apply threshold method on GPU
clij.op().automaticThreshold(input, output, "Otsu");

// show result
clij.pull(output).show();
IJ.setMinAndMax(0, 1);





