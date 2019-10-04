# CLIJ example script: reslicing.py
# ---------------------------------
#
# This example Jython script shows how to
# reslice an image in the GPU.
#
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
##########################################

from net.haesleinhuepf.clij import CLIJ;
from ij import IJ;

IJ.run("Close All");

# init CLIJ and GPU
clij = CLIJ.getInstance();

imp = IJ.openImage("http://imagej.nih.gov/ij/images/t1-head.zip");
imp.show();
imp.setRoi(86,3,100,250);
imp = imp.crop("25-74");
imp.show();
#imp = IJ.getImage();

# get input parameters
src = clij.push(imp);
dst = clij.create([src.getWidth(), src.getDepth(), src.getHeight()], src.getNativeType());

# Execute operation on GPU
clij.op().resliceTop(src, dst);

# show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show();
dstImagePlus.setZ(dstImagePlus.getNSlices() / 2);
IJ.run(dstImagePlus, "Enhance Contrast", "saturated=0.35");

# cleanup memory on GPU
src.close();
dst.close();