//sourceFolder = "/home/rhaase/data/tif/"
//resultFolder = "/home/rhaase/data/benchmark_results/"
//computerName = "LenovoX380";
//sourceFolder = "f:/benchmarkdata/tif/"
//resultFolder = "f:/benchmarkdata/results/"
//computerName = "myers-pc-3";
sourceFolder = "D:/benchmarkdata/tif/"
resultFolder = "D:/benchmarkdata/results/"
computerName = "myers-pc-22";
//sourceFolder = "C:/structure/data/tif/"
//resultFolder = "C:/structure/data/benchmark_results/"
//computerName = "OneMix";
//sourceFolder = "C:/structure/data/2018-05-23-16-18-13-89-Florence_multisample/processed/tif/"
//resultFolder = "C:/Users/rhaase/Desktop/temp/"
//computerName = "myers-pc-21";
//sourceFolder = "C:/structure/data/benchm_20190104/tif/"
//resultFolder = "C:/structure/data/benchm_20190104/results/"
//computerName = "HPEnvy360Ryzen";
//sourceFolder = "C:/structure/data/benchm_20190104/tif/"
//resultFolder = "C:/structure/data/benchm_20190104/results/"
//computerName = "msiGS65";
workflow = "a";


timeLogFile = "C:/structure/code/clij-benchmarking/data/benchmarking/all/" + computerName + "_workflow_imagej.csv";

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

for (t = 0; t < 117; t+=1) {
	run("Close All");

    strNumber = "000000" + t;
	filename = substring(strNumber, lengthOf(strNumber) - 6, lengthOf(strNumber) ) + ".raw.tif";

	IJ.log(filename);
	open(sourceFolder + filename);
	run("32-bit");

	startTimeWholeLoop = getTime();
	
	getDimensions(width, height, channels, slices, frames);
	run("Properties...", "channels=" + channels + " slices=" + slices + " frames=" + frames + " unit=pixel pixel_width=1.0000 pixel_height=1.0000 voxel_depth=1.0000");

	time = getTime();
	original = getTitle();

	startTimeBlurring = getTime();

	// first Gaussian blur
	run("Gaussian Blur...", "sigma=" + smallBlurSigmaInPixels + " stack");
	firstFiltered = getTitle();

	selectWindow(original);
	run("Duplicate...", "duplicate");

	// second Gaussian blur
	run("Gaussian Blur...", "sigma=" + blurSigmaInPixels + " stack");
	secondFiltered = getTitle();
	
	// calculate DoG image
	imageCalculator("Subtract create 32-bit stack", firstFiltered, secondFiltered);
	imageDoG = getTitle();

	
	getDimensions(width, height, channels, slices, frames);
	newImage("Untitled", "16-bit black", width, height, slices);
	emptyStack = getTitle();
	run("Add...", "value=1 stack");
	
	imageCalculator("Max create 32-bit stack", imageDoG, emptyStack);

	positiveStack = getTitle();

	endTimeBlurring = getTime();
	startTimeReslicing = getTime();

	getDimensions(width, height, channels, slices, frames);
	run("Scale...", "x=" + sampleX + " y=" + sampleY + " z=" + sampleZ + " width=" + (width * sampleX) + " height=" + (height * sampleY) + " depth=" + (slices * sampleZ) + " interpolation=None average process create");
	scaled = getTitle();
	
	run("Reslice [/]...", "output=1.982 start=Top avoid");
	
	getDimensions(width, height, channels, slices, frames);
	makeLine(width/2, height/2, width/2, height);
	
	run("Radial Reslice", "angle=360 degrees_per_slice=1 direction=Clockwise");
	
	run("Reslice [/]...", "output=1.982 start=Left avoid");
	
	run("Z Project...", "projection=[Max Intensity]");
	maxProjected = getTitle();

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
