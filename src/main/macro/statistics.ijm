// CLIJ example macro: statistics,ijm
//
// This macro shows derive statistics form an image in the GPU.
//
// Author: Robert Haase
//         September 2019
// ---------------------------------------------


// Get test data
run("Blobs (25K)");
//open("C:/structure/data/blobs.gif");
getDimensions(width, height, channels, slices, frames);
input = getTitle()

// Init GPU
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_clear();

// push data to GPU
Ext.CLIJ_push(input);

// get min/max of all pixels
Ext.CLIJ_minimumOfAllPixels(input);
minimumIntensity = getResult("Minimum", nResults() - 1);
Ext.CLIJ_maximumOfAllPixels(input);
maximumIntensity = getResult("Maximum", nResults() - 1);

// create a binary image
binary = "binary";
Ext.CLIJ_automaticThreshold(input, binary, "Otsu");

// area of binary image
Ext.CLIJ_sumOfAllPixels(binary);
mx = getResult("Sum", nResults() - 1);

// determine center of mass
Ext.CLIJ_centerOfMass(binary);
mx = getResult("MassX", nResults() - 1);
my = getResult("MassY", nResults() - 1);
