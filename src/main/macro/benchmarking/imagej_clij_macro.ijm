//sourceFolder = "/home/rhaase/data/tif/"
//resultFolder = "/home/rhaase/data/benchmark_results/"
//computerName = "LenovoX380";
//sourceFolder = "f:/benchmarkdata/tif/"
//resultFolder = "f:/benchmarkdata/results/"
//computerName = "myers-pc-3";
//sourceFolder = "D:/Robert/benchmarkdata/tif/"
//resultFolder = "D:/Robert/benchmarkdata/results/"
//computerName = "myers-pc-22";
//sourceFolder = "C:/structure/data/tif/"
//resultFolder = "C:/structure/data/benchmark_results/"
//computerName = "OneMix";
sourceFolder = "C:/structure/data/2018-05-23-16-18-13-89-Florence_multisample/processed/tif/"
resultFolder = "C:/Users/rhaase/Desktop/temp/"
computerName = "myers-pc-21";
//sourceFolder = "C:/structure/data/benchm_20190104/tif/"
//resultFolder = "C:/structure/data/benchm_20190104/results/"
//computerName = "HPEnvy360Ryzen";
//sourceFolder = "C:/structure/data/benchm_20190104/tif/"
//resultFolder = "C:/structure/data/benchm_20190104/results/"
//computerName = "msiGS65";
workflow = "c";
//cl_device = "[Intel(R) HD Graphics 400]";
//cl_device = "[GeForce GTX 1070 with Max-Q Design]";
//cl_device = "[Intel(R) UHD Graphics 620]";
//cl_device = "HD";
cl_device = "TITAN";
//cl_device = "[Intel(R) UHD Graphics 630]";
//cl_device = "gfx902";

timeLogFile = "C:/structure/code/clij-benchmarking/data/benchmarking/all/" + computerName + "_workflow_clij.csv";


smallBlurSigmaInPixels = 2;
blurSigmaInPixels = 6;
sampleX = 0.52;
sampleY = 0.52;
sampleZ = 2.0;
noiseThreshold = 5;

getDateAndTime(year, month, dayOfWeek, dayOfMonth, hour, minute, second, msec);
IJ.log("" + year + "-" + month + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second );
IJ.log("Test on computer " + computerName);
IJ.log("Test: " + workflow);
currentDate = "" + year + "-" + (month+1) + "-" + dayOfMonth;

run("CLIJ Macro Extensions", "cl_device=" + cl_device);
Ext.CLIJ_clear();

for (t = 0; t < 117; t+=1) {
	run("Close All");

    strNumber = "000000" + t;
	filename = substring(strNumber, lengthOf(strNumber) - 6, lengthOf(strNumber) ) + ".raw.tif";

	IJ.log(filename);
	open(sourceFolder + filename);
	run("32-bit");
	
	startTimeWholeLoop = getTime();
	
	time = getTime();
	rename("original");
	original = getTitle();
	
	startTimeBlurring = getTime();

	Ext.CLIJ_push(original);

	// first Gaussian blur
	firstFiltered = "firstFiltered";
	Ext.CLIJ_blur3DFast(original, firstFiltered, smallBlurSigmaInPixels, 
												 smallBlurSigmaInPixels, 0);

	// second Gaussian blur
	secondFiltered = "secondFiltered";
	Ext.CLIJ_blur3DFast(original, secondFiltered, blurSigmaInPixels, 
											      blurSigmaInPixels, 0);
	// calculate DoG image
	imageDoG = "imageDoG";
	Ext.CLIJ_addImagesWeighted(firstFiltered, secondFiltered, imageDoG, 1.0, -1.0);
	
	
	positiveStack = "positiveStack";
	Ext.CLIJ_maximumImageAndScalar(imageDoG, positiveStack, 1.0);

	endTimeBlurring = getTime();
	startTimeReslicing = getTime();

	scaled = "scaled";
	Ext.CLIJ_downsample3D(positiveStack, scaled, sampleX, sampleY, sampleZ);
	
	reslicedFromTop = "reslicedFromTop";
	Ext.CLIJ_resliceTop(scaled, reslicedFromTop);

	radialResliced = "radialResliced";
	Ext.CLIJ_resliceRadial(reslicedFromTop, radialResliced, 360.0, 1.0);

	reslicedFromLeft = "reslicedFromLeft";
	Ext.CLIJ_resliceLeft(radialResliced, reslicedFromLeft);
	
	maxProjected = "maxProjected";
	Ext.CLIJ_maximumZProjection(reslicedFromLeft, maxProjected);

	Ext.CLIJ_pull(maxProjected);

	endTimeReslicing = getTime();
	startTimeSpotDetection = getTime();
		
	// detect maxima
	run("Find Maxima...", "noise=" + noiseThreshold + " output=[Single Points]");
	foundMaxima = getTitle();
	// count maxima
	run("Set Measurements...", "mean redirect=None decimal=3");
	run("Measure");
	meanGreyValue = getResult("Mean", nResults() - 1);
	getDimensions(width, height, channels, slices, frames);
	sumGreyValue = meanGreyValue * width * height;
	numberOfSpots = sumGreyValue / 255;
	
	endTimeSpotDetection = getTime();

	endTimeWholeLoop = getTime();
	
	IJ.log(workflow + ", t = " + t + ", n = " + numberOfSpots + ", time = " + ( getTime() - time ));

	// save resulting maximum projection with visualised detected spots
	selectWindow(maxProjected);
	run("8-bit");
	run("Merge Channels...", "c1=[" + maxProjected + "] c2=[" + foundMaxima + "] create");
	saveAs("Tiff", resultFolder + filename);


	logText = "";
	
	if (t == 0) {
	  logText = "t\tnumberOfSpots\ttimeWholeLoop\ttimeBlur\ttimeReslicing\ttimeSpotDetection\n";
	}
	logText = logText + t + 
	"\t" + numberOfSpots + 
	"\t" + (endTimeWholeLoop - startTimeWholeLoop) + 
	"\t" + (endTimeBlurring - startTimeBlurring) + 
	"\t" + (endTimeReslicing - startTimeReslicing) + 
	"\t" + (endTimeSpotDetection - startTimeSpotDetection);

	IJ.log(logText);
	File.append(logText, resultFolder + computerName + "_" + workflow + ".txt");



	if (t == 0) {
		File.append("Time_in_msec", timeLogFile);
	}	
	File.append((endTimeWholeLoop - startTimeWholeLoop), timeLogFile);
	
	//break;
}