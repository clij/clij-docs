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

threshold = 128;

IJ.run("Close All");


# load example image
imp = IJ.openImage("http://wsr.imagej.net/images/blobs.gif");
# imp = IJ.openImage("c:/structure/data/blobs.tif");
imp.show();

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input = clij.push(imp);

# reserve memory for output, same size and type as input
output = clij.create(input);

# reserve some more memory for intermediate results
temp = clij.create(input);

# apply a given fixed threshold on GPU
clij.op().threshold(input, output, threshold);

# binary opening: erosion + dilation, twice each
clij.op().erodeBox(output, temp);
clij.op().erodeBox(temp, output);

clij.op().dilateBox(output, temp);
clij.op().dilateBox(temp, output);

# show result
clij.pull(output).show();
IJ.setMinAndMax(0, 1);

# clean up
input.close();
temp.close();
output.close();



