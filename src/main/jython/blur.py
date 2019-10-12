# binaryProcessing.py
# ===================
#
# Apply an automatic threshold method to an image on the GPU
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
#########################################

from ij import IJ;
from net.haesleinhuepf.clij import CLIJ;

IJ.run("Close All");


# load example image
# imp = IJ.openImage("http://wsr.imagej.net/images/blobs.gif");
imp = IJ.openImage("c:/structure/data/blobs.tif");
imp.show();

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input = clij.push(imp);

# reserve memory for output, same size and type as input
output = clij.create(input);

# apply a Gaussian blur on GPU
clij.op().blur(input, output, 5, 5);

# show result
clij.pull(output).show();

# clean up
input.close();
output.close();



