# applyVectorField.py
# ===================
#
# This script demonstrates how to apply a
# warping to an image on the GPU
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         October 2019
#########################################

from ij import IJ;
from net.haesleinhuepf.clij import CLIJ;
from net.imglib2.realtransform import AffineTransform2D;

from ij.gui import NewImage;
from ij.gui import OvalRoi;

from java.lang import Math;


IJ.run("Close All");

# load/create example images
imp = IJ.openImage("http://wsr.imagej.net/images/blobs.gif");
IJ.run(imp, "32-bit", "");
imp.show();

shiftX = NewImage.createFloatImage("", imp.getWidth(), imp.getHeight(), 1, NewImage.FILL_BLACK);
shiftY = NewImage.createFloatImage("", imp.getWidth(), imp.getHeight(), 1, NewImage.FILL_BLACK);

# define shift some of the pixels in X
shiftX.setRoi(OvalRoi(20, 98, 72, 68));
IJ.run(shiftX, "Add...", "value=25");
IJ.run(shiftX, "Select None", "");
IJ.run(shiftX, "Gaussian Blur...", "sigma=15");

# init GPU
clij = CLIJ.getInstance();

# push image to GPU
input = clij.push(imp);

shiftXgpu = clij.push(shiftX);
rotatedShiftXgpu = clij.create(shiftXgpu);
shiftYgpu = clij.push(shiftY);

temp = clij.create(input);

# reserve memory for output
output = clij.create([input.getWidth(), input.getHeight(), 36], input.getNativeType());

for i in range(0, 36):

	# change the shift from slice to slice
	at = AffineTransform2D();
	at.translate(-input.getWidth() / 2, -input.getHeight() / 2);
	at.rotate(i * 10.0 / 180.0 * Math.PI);
	at.translate(input.getWidth() / 2, input.getHeight() / 2);

	clij.op().affineTransform2D(shiftXgpu, rotatedShiftXgpu, at);
	
	# apply transform
	clij.op().applyVectorfield(input, rotatedShiftXgpu, shiftYgpu, temp);

	# put resulting 2D image in the right plane
	clij.op().copySlice(temp, output, i);

# show result
clij.pull(output).show();
IJ.setMinAndMax(0, 255);

input.close();
shiftXgpu.close();
rotatedShiftXgpu.close();
shiftYgpu.close();
temp.close();
output.close();



