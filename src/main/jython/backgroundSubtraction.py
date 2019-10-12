# backgroundSubtraction.py
# ========================
#
# Apply background subtraction to an image on the GPU
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
#########################################

from ij import IJ;
from net.haesleinhuepf.clij import CLIJ;


IJ.run("Close All");

# load example image
imp = IJ.openImage("http://imagej.nih.gov/ij/images/t1-head.zip");
# IJ.run(imp, "32-bit", "");
imp.show();

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input = clij.push(imp);

# allocated background image of same size and type as input
background = clij.create(input);

# reserve memory for output, same size and type
output = clij.create(input);

# get a background image by Gaussian blurring
clij.op().blur(input, background, 10, 10, 1);

# subtract background from original image
clij.op().subtractImages(input, background, output);

# show result
clij.pull(output).show();
IJ.setMinAndMax(0, 255);

# clean up
input.close();
background.close();
output.close();



