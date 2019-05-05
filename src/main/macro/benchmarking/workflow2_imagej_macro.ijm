//sourceFolder = "D:/Robert/benchmarkdata/tif/"
//resultFolder = "D:/Robert/benchmarkdata/results/"
//computerName = "myers-pc-22";
sourceFolder = "C:/structure/data/2018-05-23-16-18-13-89-Florence_multisample/processed/tif/"
resultFolder = "C:/Users/rhaase/Desktop/temp/"
computerName = "myers-pc-21";
//sourceFolder = "C:/structure/data/benchm_20190104/tif/"
//resultFolder = "C:/structure/data/benchm_20190104/results/"
//computerName = "msiGS65";



timeLogFile = "C:/structure/code/clij-benchmarking/data/benchmarking/all/" + computerName + "_workflow2_imagej.csv";


getDateAndTime(year, month, dayOfWeek, dayOfMonth, hour, minute, second, msec);
IJ.log("" + year + "-" + month + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second );
IJ.log("Test on computer " + computerName);

for (t = 0; t < 30; t+=3) {
	run("Close All");

    strNumber = "000000" + t;
	filename = substring(strNumber, lengthOf(strNumber) - 6, lengthOf(strNumber) ) + ".raw.tif";

	IJ.log(filename);
	open(sourceFolder + filename);

	startTimeWholeLoop = getTime();

	getDimensions(width, height, channels, slices, frames);
	run("Properties...", "channels=" + channels + " slices=" + slices + " frames=" + frames + " unit=pixel pixel_width=1.0000 pixel_height=1.0000 voxel_depth=1.0000");
	original = getTitle();

	// median for noise reduction
	run("Median 3D...", "x=5 y=5 z=1");
	run("Duplicate...", "duplicate");
	// top-hat filter
	run("Minimum 3D...", "x=15 y=15 z=3");
	run("Maximum 3D...", "x=15 y=15 z=3");
	// subtract background
	imageCalculator("Subtract create 32-bit stack", original, getTitle());
	// max projection
	run("Z Project...", "projection=[Max Intensity]");

	endTimeWholeLoop = getTime();
	
	// save resulting maximum projection
	run("8-bit");
	saveAs("Tiff", resultFolder + filename);


	if (t == 0) {
		File.append("Time_in_msec", timeLogFile);
	}	
	File.append((endTimeWholeLoop - startTimeWholeLoop), timeLogFile);
	
	//break;
}
