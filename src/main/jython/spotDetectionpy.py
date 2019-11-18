# interactiveSpotDetection.py
# ===========================
#
# This script demonstrates a spot detection workflow
# which can be tuned via a dialog giving results in
# instantly.
#
# The used data can be downloaded from:
# https://bds.mpi-cbg.de/CLIJ_benchmarking_data/
#
# Author: Robert Haase, rhaase@mpi-cbg.de
#         November 2019
#########################################

# Configuration / default values
data_folder = "C:/structure/data/2018-05-23-16-18-13-89-Florence_multisample/processed/tif/";
number_of_images = 300;
number_of_z_planes = 121;

# the zoom factor allows us to fit the result on the screen
# and to tune that it's running smoothly depending on 
# which GPU is used
zoom = 2.5; 


# Noise / background removal
formerDoNoiseAndBackgroundRemoval = True;
formerSigma1 = 10;
formerSigma2 = 30;

# Rigid transform
formerDoRigidTransform = True;
formerTranslationX = 30;
formerTranslationY = 0;
formerTranslationZ = 0;

formerRotationX = 0;
formerRotationY = 0;
formerRotationZ = 0;

# Spot detection
formerDoSpotDetection = False;
formerTolerance = 5;
formerThreshold = 0;


# --------------------------------------------------------
# Do not change anythign below

from ij import IJ;
from ij import ImageStack;
from ij import ImagePlus;
from ij.plugin import RGBStackMerge
from ij.gui import NewImage
from ij.plugin import CompositeConverter;
from ij.plugin import HyperStackConverter;
from ij.plugin import RGBStackConverter;
from ij import CompositeImage;
from ij.plugin import Duplicator

from net.haesleinhuepf.clij import CLIJ;

from java.lang import Thread;
from java.lang import Math;
from java.lang import System;

from fiji.util.gui import GenericDialogPlus;

from net.haesleinhuepf.clij.coremem.enums import NativeTypeEnum;
from net.imglib2.realtransform import AffineTransform3D;


from ij.plugin.filter import MaximumFinder;

IJ.run("Close All");
# load single image
#imp = IJ.openImage("C:/structure/data/florence/000300.raw.tif");
#IJ.run(imp, "32-bit", "");
#imp.show();

# load sequence
IJ.run("Image Sequence...", "open=[" + data_folder + "] sort use");
IJ.run("Stack to Hyperstack...", "order=xyczt(default) channels=1 slices=" + str(number_of_z_planes) + " frames=" + str(number_of_images) + " display=Color");
imp = IJ.getImage();

# init GPU
clij = CLIJ.getInstance("1070");

# configure initial scaling step
calib = imp.getCalibration();          
scaleX = calib.pixelWidth / calib.pixelDepth * zoom;
scaleY = calib.pixelHeight / calib.pixelDepth * zoom;
scaleZ = 1.0 * zoom;

# initialize state
input = None;
formerT = None;
resultCylinderMaxProjection = None;
resultMaxProjection = None;
spots = None;
circles = None;
blobs = None;

# build up user interface
gdp = GenericDialogPlus("Spot detection workflow");
gdp.addMessage("Noise and background subtraction (DoG)");
gdp.addCheckbox("Do noise and background subtraction ", formerDoNoiseAndBackgroundRemoval);
gdp.addSlider("Sigma 1 (in 0.1 pixel)", 0, 100, formerSigma1);
gdp.addSlider("Sigma 2 (in 0.1 pixel)", 0, 100, formerSigma2);
gdp.addMessage("Rigid transform");
gdp.addCheckbox("Do rigid transformation", formerDoRigidTransform);
gdp.addSlider("Translation X (in pixel)", -100, 100, formerTranslationX);
gdp.addSlider("Translation Y (in pixel)", -100, 100, formerTranslationY);
gdp.addSlider("Translation Z (in pixel)", -100, 100, formerTranslationZ);
gdp.addSlider("Rotation X (in degrees)", -180, 180, formerRotationX);
gdp.addSlider("Rotation Y (in degrees)", -180, 180, formerRotationY);
gdp.addSlider("Rotation Z (in degrees)", -180, 180, formerRotationZ);
gdp.addMessage("Spot detection")
gdp.addCheckbox("Do spot detection", formerDoSpotDetection);
gdp.addSlider("Tolerance", 0, 100, formerTolerance);
gdp.addSlider("Threshold", 0, 100, formerThreshold);
gdp.setModal(False);
gdp.showDialog();

doNoiseAndBackgroundRemovalCheckbox = gdp.getCheckboxes().get(0);
sigma1Slider = gdp.getSliders().get(0);
sigma2Slider = gdp.getSliders().get(1);

doRigidTransformCheckbox = gdp.getCheckboxes().get(1);
translationXSlider = gdp.getSliders().get(2);
translationYSlider = gdp.getSliders().get(3);
translationZSlider = gdp.getSliders().get(4);

rotationXSlider = gdp.getSliders().get(5);
rotationYSlider = gdp.getSliders().get(6);
rotationZSlider = gdp.getSliders().get(7);

doSpotDetectionCheckbox = gdp.getCheckboxes().get(2);
toleranceSlider = gdp.getSliders().get(8);
thresholdSlider = gdp.getSliders().get(9);

# loop until user closed the dialog
stillValid = False;
while ((not gdp.wasCanceled()) and not (gdp.wasOKed())):

	# reserve memory for input and output images
	if (input is None):
		input = clij.create([
			(long)(imp.getWidth() * scaleX), 
			(long)(imp.getHeight() * scaleY), 
			(long)(imp.getNSlices() * scaleZ)], NativeTypeEnum.Float);
				
		temp1 = clij.create(input);
		temp2 = clij.create(input);
		dog = clij.create(input);
		transformed = clij.create(input);
		reslicedFromTop = clij.create([input.getWidth(), input.getDepth(), input.getHeight()], input.getNativeType());
		cylinderProjection = clij.create([(long)(input.getWidth() * 0.75), input.getHeight(), 540], input.getNativeType());
		cylinderProjectionTransformed_temp = clij.create([cylinderProjection.getHeight(), cylinderProjection.getDepth(), cylinderProjection.getWidth()], input.getNativeType());
		cylinderProjectionTransformed = clij.create([cylinderProjection.getDepth(), cylinderProjection.getHeight(), cylinderProjection.getWidth()], input.getNativeType());
		cylinderMaxProjection = clij.create([cylinderProjectionTransformed.getWidth(), cylinderProjectionTransformed.getHeight()], input.getNativeType());
		maxProjection = clij.create([transformed.getWidth(), transformed.getHeight()], input.getNativeType());

	# read current values from dialog
	doNoiseAndBackgroundRemoval = doNoiseAndBackgroundRemovalCheckbox.getState();
	sigma1 = 0.1 * sigma1Slider.getValue();
	sigma2 = 0.1 * sigma2Slider.getValue();

	doRigidTransform = doRigidTransformCheckbox.getState();
	translationX = translationXSlider.getValue();
	translationY = translationYSlider.getValue();
	translationZ = translationZSlider.getValue();

	rotationX = rotationXSlider.getValue() * Math.PI / 180.0;
	rotationY = rotationYSlider.getValue() * Math.PI / 180.0;
	rotationZ = rotationZSlider.getValue() * Math.PI / 180.0;

	doSpotDetection = doSpotDetectionCheckbox.getState();
	tolerance = toleranceSlider.getValue();
	threshold = thresholdSlider.getValue();

	# check if something changed
	if (
		formerDoNoiseAndBackgroundRemoval == doNoiseAndBackgroundRemoval and
		sigma1 == formerSigma1 and 
		sigma2 == formerSigma2 and
		formerDoRigidTransform == doRigidTransform and 
		translationX == formerTranslationX and
		translationY == formerTranslationY and
		translationZ == formerTranslationZ and
		rotationX == formerRotationX and
		rotationY == formerRotationY and
		rotationZ == formerRotationZ and 
		formerT == imp.getFrame() and 
		formerTolerance == tolerance and 
		formerThreshold == threshold and 
		formerDoSpotDetection == doSpotDetection
	):
		# sleep some msec
		Thread.sleep(100);
		continue;

	# measure start time for benchmarking
	timeStamp = System.currentTimeMillis();
		
	if (formerT != imp.getFrame()):
		formerT = imp.getFrame();
		# push image to GPU
		pushed = clij.pushCurrentZStack(imp);
		# scale it initially; depends on zoom factor and voxel size
		scaleTransform = AffineTransform3D();
		scaleTransform.scale(scaleX, scaleY, scaleZ);		
		clij.op().affineTransform3D(pushed, input, scaleTransform);
		pushed.close();
		stillValid = False;

	# Noise/background removal
	if (formerDoNoiseAndBackgroundRemoval != doNoiseAndBackgroundRemoval or formerSigma1 != sigma1 or formerSigma2 != sigma2):	
		formerDoNoiseAndBackgroundRemoval = doNoiseAndBackgroundRemoval;
		formerSigma1 = sigma1;
		formerSigma2 = sigma2;	
		stillValid = False;

	if (not stillValid):	
		if (doNoiseAndBackgroundRemoval):
			clij.op().blur(input, temp1, sigma1, sigma1);		
			clij.op().blur(input, temp2, sigma2, sigma2);
			clij.op().subtract(temp1, temp2, dog);
		else:
			clij.op().copy(input, dog);

	# Rigid transform
	if (not (formerDoRigidTransform == doRigidTransform and 
		translationX == formerTranslationX and
		translationY == formerTranslationY and
		translationZ == formerTranslationZ and
		rotationX == formerRotationX and
		rotationY == formerRotationY and
		rotationZ == formerRotationZ)):
		stillValid = False;

	if (not stillValid):
		formerDoRigidTransform = doRigidTransform;
		formerTranslationX = translationX;
		formerTranslationY = translationY;
		formerTranslationZ = translationZ;
		
		formerRotationX = rotationX;
		formerRotationY = rotationY;
		formerRotationZ = rotationZ;

		if(doRigidTransform):
			at = AffineTransform3D();
			at.translate(-transformed.getWidth() / 2, -transformed.getHeight() / 2, -transformed.getDepth() / 2);
			at.translate(translationX, translationY, translationZ);
			at.rotate(0, rotationX);
			at.rotate(1, rotationY);
			at.rotate(2, rotationZ);
			at.translate(transformed.getWidth() / 2, transformed.getHeight() / 2, transformed.getDepth() / 2);
			
			# Execute operation on GPU
			clij.op().affineTransform3D(dog, transformed, at);
		else:
			clij.op().copy(dog, transformed);

		# Maximum Intensity Projection
		clij.op().maximumZProjection(transformed, maxProjection);

		# Cylindrical MIP
		clij.op().resliceTop(transformed, reslicedFromTop);
		clij.op().radialProjection(reslicedFromTop, cylinderProjection, 0.666);
		clij.op().resliceLeft(cylinderProjection, cylinderProjectionTransformed_temp);
		clij.op().rotateRight(cylinderProjectionTransformed_temp, cylinderProjectionTransformed);
		clij.op().maximumZProjection(cylinderProjectionTransformed, cylinderMaxProjection);

	# Spot detection
	if (formerTolerance != tolerance or formerThreshold != threshold or formerDoSpotDetection != doSpotDetection):
		formerTolerance = tolerance;
		formerThreshold = threshold;
		formerDoSpotDetection = doSpotDetection;
		stillValid = False;

	if (not stillValid):
		if (doSpotDetection):
			projectionImp = clij.pull(cylinderMaxProjection);
			binary = MaximumFinder().findMaxima(projectionImp.getProcessor(), tolerance, True, threshold, MaximumFinder.SINGLE_POINTS, False, False);
			projectionImp.setProcessor(binary); 
			#projectionImp.show();
			
			if (spots is not None):
				spots.close();
			spots = clij.push(projectionImp);
			if (circles is None):
				circles = clij.create(spots);
			if (blobs is None):
				blobs = clij.create(spots);
	
			clij.op().dilateBox(spots, blobs);
			clij.op().dilateSphere(blobs, spots);
			clij.op().subtract(spots, blobs, circles);		
		else:
			if (circles is None):
				circles = clij.create(cylinderMaxProjection);
			clij.op().set(circles, 0);

	# Result visualisation
	if (not stillValid):
		impCylinderProjection = clij.pull(cylinderMaxProjection);
		IJ.run(impCylinderProjection, "Enhance Contrast", "saturated=0.3");
		impCircles = clij.pull(circles);
		impCircles.setDisplayRange(0, 1);
		
		IJ.run(impCylinderProjection, "8-bit", "");
		IJ.run(impCircles, "8-bit", "");

		stack = ImageStack(impCylinderProjection.getWidth(), impCylinderProjection.getHeight());
		stack.addSlice(impCylinderProjection.getProcessor());
		stack.addSlice(impCircles.getProcessor());
		
		tempImp = ImagePlus("Cylinder Maximum Projection + spots", stack);
		tempImp = HyperStackConverter.toHyperStack(tempImp, 2, 1, 1);
		if (tempImp.getNChannels() == 2):
			tempImp.setC(1);
			IJ.run(tempImp, "Magenta", "");
			tempImp.setC(2);
			tempImp.setDisplayRange(0, 1);
			RGBStackConverter.convertToRGB(tempImp);
		
			if (resultCylinderMaxProjection is None):
				resultCylinderMaxProjection = tempImp;
			else:
				resultCylinderMaxProjection.setProcessor(tempImp.getProcessor());
		resultCylinderMaxProjection.show();
		resultCylinderMaxProjection.updateAndDraw();

		# MIP
		impMaxProjection = clij.pull(maxProjection);
		IJ.run(impMaxProjection, "Enhance Contrast", "saturated=0.35");
		if (resultMaxProjection is None):
			resultMaxProjection = impMaxProjection;
			resultMaxProjection.setTitle("Maximum Z projection");
			resultMaxProjection.show();
		else:
			resultMaxProjection.setProcessor(impMaxProjection.getProcessor());
			resultMaxProjection.updateAndDraw();

	
	formerT = imp.getFrame();
	print("Time: " + str(System.currentTimeMillis() - timeStamp) + " ms");
	
	stillValid = True;

# close windows
if (resultMaxProjection is not None):
	resultMaxProjection.close();

if (resultCylinderMaxProjection is not None):
	resultCylinderMaxProjection.close();


# clean up
input.close();
temp1.close();
temp2.close();
dog.close();
transformed.close();
reslicedFromTop.close();
cylinderProjection.close();
cylinderProjectionTransformed_temp.close();
cylinderProjectionTransformed.close();
cylinderMaxProjection.close();
maxProjection.close();
if (spots is not None):
	spots.close();
if (circles is not None):
	circles.close();
if (blobs is not None):
	blobs.close();
