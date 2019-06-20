// This macro aims running two macro extensions in parallel.
// 
// 
// Before running this macro, please activate these update sites in Fiji
// * 3D ImageJ suite
// * clij
//
// Author: Robert Haase, rhaase@mpi-cbg.de
// June 2019
//
/////////////////////////////

// load example data
run("Confocal Series (2.2MB)");

// pre-process image
selectWindow("confocal-series.tif");
run("Duplicate...", "duplicate channels=2");	
setOption("BlackBackground", true);
run("Convert to Mask", "method=Default background=Dark calculate");

// initialize two macro extensions
run("3D Manager");
run("CLIJ Macro Extensions", "cl_device=");

for (i = 0;i < 10; i++) {

	IJ.log("i " + i);

	// use macro extension 2: 3D Manager
	// this unfortunately opens another instance of the 3D viewer
	// run("3D Manager");
	Ext.Manager3D_AddImage();
	
	// use macro extension 1: clij
	run("CLIJ Macro Extensions", "cl_device=");
	Ext.CLIJ_push("confocal-series.tif");		
	Ext.CLIJ_copy("confocal-series.tif", "image" + i);
}
Ext.CLIJ_reportMemory();
Ext.CLIJ_clear();