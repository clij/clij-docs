# addImages.py
# ============
#
# This script demonstrates basic image math
# on the GPU
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
#########################################

from ij import IJ;
from net.haesleinhuepf.clij import CLIJ;

from ij.gui import NewImage;

IJ.run("Close All");

# load/create example images
imp1 = IJ.openImage("http://wsr.imagej.net/images/blobs.gif");
IJ.run(imp1, "32-bit", "");
imp1.show();

imp2 = NewImage.createFloatImage("", imp1.getWidth(), imp1.getHeight(), 1, NewImage.FILL_RAMP);

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input1 = clij.push(imp1);
input2 = clij.push(imp2);

# reserve memory for output, same size and type as input
temp = clij.create(input1);
output = clij.create(input1);

# multiply ramp image so that it's in the same range as blobs
clij.op().multiplyImageAndScalar(input2, temp, 255);

# sum blobs and ramp
clij.op().addImages(input1, temp, output);

# show result
clij.pull(output).show();
IJ.setMinAndMax(0, 255);

input1.close();
input2.close();
temp.close();
output.close();



