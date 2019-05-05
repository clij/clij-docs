//sourceFolder = "D:/Robert/benchmarkdata/tif/"
//resultFolder = "D:/Robert/benchmarkdata/results/"
//computerName = "myers-pc-22";
sourceFolder = "C:/structure/data/2018-05-23-16-18-13-89-Florence_multisample/processed/tif/"
resultFolder = "C:/Users/rhaase/Desktop/temp/"
computerName = "myers-pc-21";
//sourceFolder = "C:/structure/data/benchm_20190104/tif/"
//resultFolder = "C:/structure/data/benchm_20190104/results/"
//computerName = "msiGS65";
workflow = "c";
//cl_device = "[Intel(R) HD Graphics 400]";
//cl_device = "[GeForce GTX 1070 with Max-Q Design]";
//cl_device = "[Intel(R) UHD Graphics 620]";
//cl_device = "HD";
cl_device = "HD";
//cl_device = "[Intel(R) UHD Graphics 630]";
//cl_device = "gfx902";

timeLogFile = "C:/structure/code/clij-benchmarking/data/benchmarking/all/" + computerName + "_workflow2_clij.csv";


getDateAndTime(year, month, dayOfWeek, dayOfMonth, hour, minute, second, msec);
IJ.log("" + year + "-" + month + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second );
IJ.log("Test on computer " + computerName);
IJ.log("Test: " + workflow);
currentDate = "" + year + "-" + (month+1) + "-" + dayOfMonth;

run("CLIJ Macro Extensions", "cl_device=" + cl_device);
Ext.CLIJ_clear();

for (t = 0; t < 30; t+=3) {
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

	// median filter for noise removal
	medianFiltered = "medianFiltered";
	Ext.CLIJ_median3DSphere(original, medianFiltered, 5, 5, 1);

	// top hat filter
	topHatTemp = "topHatTemp";
	Ext.CLIJ_minimum3DBox(medianFiltered, topHatTemp, 15, 15, 3);
	topHat = "topHat";
	Ext.CLIJ_minimum3DBox(topHatTemp, topHat, 15, 15, 3);

	// background subtracte
	backgroundSubtracted = "backgroundSubtracted"; 
	Ext.CLIJ_subtractImages(medianFiltered, topHat, backgroundSubtracted);
	
	// maximum projection
	maxProjected = "maxProjected";
	Ext.CLIJ_maximumZProjection(backgroundSubtracted, maxProjected);

	Ext.CLIJ_pull(maxProjected);

	endTimeWholeLoop = getTime();
	
	// save resulting maximum projection
	selectWindow(maxProjected);
	run("8-bit");
	saveAs("Tiff", resultFolder + filename);

	if (t == 0) {
		File.append("Time_in_msec", timeLogFile);
	}	
	File.append((endTimeWholeLoop - startTimeWholeLoop), timeLogFile);
	
	//break;
}