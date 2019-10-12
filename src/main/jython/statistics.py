# statistics.py
# =============
#
# Derive pixel statistics of an image on the GPU
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
#########################################

from ij import IJ;
from net.haesleinhuepf.clij import CLIJ;


IJ.run("Close All");

# load example image
imp = IJ.openImage("http://wsr.imagej.net/images/blobs.gif");
# imp = IJ.openImage("c:/structure/data/blobs.tif");
imp.show();

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input = clij.push(imp);

meanIntensity = clij.op().sumPixels(input) / input.getWidth() / input.getHeight();
IJ.log("Mean intensity of all pixels: " + str(meanIntensity));


# reserve memory for a mask and masked image, same size and type as input
mask = clij.create(input);
masked = clij.create(input);

# apply threshold method on GPU
clij.op().automaticThreshold(input, mask, "Otsu");

# mask the image
clij.op().mask(input, mask, masked);

# determine mean intensity of masked area:
meanIntensity = clij.op().sumPixels(masked) / input.getWidth() / input.getHeight();
IJ.log("Mean intensity of masked pixels: " + str(meanIntensity));

# clean up
input.close();
mask.close();
masked.close();


