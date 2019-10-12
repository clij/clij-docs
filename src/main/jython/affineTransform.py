# affineTransform.py
# ==================
#
# This script demonstrates how to apppl an
# affine transform on the GPU
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
#########################################

from ij import IJ;
from net.haesleinhuepf.clij import CLIJ;
from net.imglib2.realtransform import AffineTransform2D;
from java.lang import Math;

IJ.run("Close All");

# load/create example images
imp = IJ.openImage("http://wsr.imagej.net/images/blobs.gif");
IJ.run(imp, "32-bit", "");
imp.show();

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input = clij.push(imp);

# reserve memory for output, same size and type as input
output = clij.create(input);


at = AffineTransform2D();
at.translate(-input.getWidth() / 2, -input.getHeight() / 2);
at.rotate(45.0 / 180.0 * Math.PI);
at.scale(0.5, 0.5);
at.translate(input.getWidth() / 2, input.getHeight() / 2);

# Execute operation on GPU
clij.op().affineTransform2D(input, output, at);

# show result
clij.pull(output).show();
IJ.setMinAndMax(0, 255);

input.close();
output.close();



