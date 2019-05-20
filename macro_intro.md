# CLIJ - GPU-accelerated image processing in ImageJ macro
Image processing in modern GPUs allows for accelerating processing speeds massively. 
This page introduces how to do image processing in the graphics processing unit (GPU) using [OpenCL](https://www.khronos.org/opencl/) from ImageJ macro inside [Fiji](http://fiji.sc) using the [CLIJ](https://clij.github.io/) library. 
It is not necessary to learn OpenCL itself. 
Preprogrammed routines are supposed to do GPU image processing for you with given ImageJ macro programming experience.
The list of preprogrammed routines might be extended depending on the communities needs.

This is how your code might look like if you do GPU based image processing in ImageJ macro:

![Image](images/example.png)

## Installation
Follow the [installation instructions](installationInFiji);

## A first macro
A first example macro is [help.ijm](https://github.com/clij/clij-docs/blob/master/src/main/macro/help.ijm).
It will assist us to get an overview which methods are supported by CLIJ to process images. 
It looks like this:

```java
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_help("add");
```

By executing it, you will find a list of commands containing the term `add` in their names:

```java
Found 3 method(s) containing the pattern "add":
Ext.CLIJ_addImageAndScalar(Image source, Image destination, Number scalar);
Ext.CLIJ_addImages(Image summand1, Image summand2, Image destination);
Ext.CLIJ_addImagesWeighted(Image summand1, Image summand2, Image destination, Number factor1, Number factor2);
```

Keep this example program, you might need it later again if you want to search for help on CLIJ methods. 
It also tells you which parameters the methods need in order to run. The whole [reference of all command with description and example code is available online](https://clij.github.io/clij-docs/reference).


Note: The first line of this macro may contain the specific name for a GPU.
You can - but you don't have to - specify one. 
If none is specified, the system will take the first one found.
If you don't have the named GPU in your computer, another one will be chosen.
You don't have to enter the full name, you can also just specify a part of the name.
In order to run on any `HD` named GPU, change the macro like this:

```java
run("CLIJ Macro Extensions", "cl_device=HD");
Ext.CLIJ_help("add");
```

## Transferring images between ImageJ and the GPU
In order to allow images to be processed by the GPU, you need to transfer them into the memory of the GPU. 
In order to view images which were processed by the GPU, you need to transfer them back to ImageJ. 
The two methods for doing this are called `push(image)` and `pull(image)`. 
You can remove a single image from the GPUs memory by using the `release(image)` method. 
Finally, you can remove all images from the GPU with the `clear()` method.
In case the destination image doesn't exist, it will be created automatically in the GPU. 
Just push an image _A_ to the GPU, process it with destination _B_ and afterwards, you can pull _B_ back from the GPU to ImageJ in order to show it.

Let's have a look at an example which loads an image and blurs it using the push-pull mechanism.

```java
// Get test data
run("T1 Head (2.4M, 16-bits)");
input = getTitle();
getDimensions(width, height, channels, slices, frames);

// define under which name the result should be saved
blurred = "Blurred";

// Init GPU
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_clear();

// push images to GPU
Ext.CLIJ_push(input);

// cleanup ImageJ
run("Close All");

// Blur in GPU
Ext.CLIJ_blur3DFast(input, blurred, 10, 10, 1);

// Get results back from GPU
Ext.CLIJ_pull(blurred);

// Cleanup by the end
Ext.CLIJ_clear();
```

To find out, which images are currently stored in the GPU, run the `Ext.CLIJ_reportMemory();` method.

## Sparing time with GPU based image processing
The overall goal for processing images in the GPU is sparing time. 
GPUs can process images faster because they can calculate pixel values of many pixels in parallel. 
Furthermore, images in memory of modern GPUs can be accessed faster than in ImageJ. 
However, there is a drawback: pushing/pulling the images to/from the GPU takes time. 
Thus, overall efficiency can only be achieved if whole pipelines are processed in the GPU. 
Furthermore, repeatedly using the same operations on a GPU pays off because operations are cached. Reusing them is faster than using other methods. 

Let's compare the `Mean 3D` filter of ImageJ with it's counterpart in CLIJ.
The example macro is [benchmarking.ijm](https://github.com/clij/clij-docs/tree/master/src/main/macro/benchmarking.ijm). 
It executes both operations ten times and measures the time each operation takes. 
This is just an excerpt of the macro:

```java
// Local mean filter in CPU
for (i = 1; i <= 10; i++) {
	time = getTime();
	run("Mean 3D...", "x=3 y=3 z=3");
	print("CPU mean filter no " + i + " took " + (getTime() - time));
}
```

```java
// push images to GPU
time = getTime();
Ext.CLIJ_push(input);
Ext.CLIJ_push(blurred);
print("Pushing two images to the GPU took " + (getTime() - time) + " msec");

// Local mean filter in GPU
for (i = 1; i <= 10; i++) {
	time = getTime();
	Ext.CLIJ_mean3DBox(input, blurred, 3, 3, 3);
	print("GPU mean filter no " + i + " took " + (getTime() - time));
}

// Get results back from GPU
time = getTime();
Ext.CLIJ_pull(blurred);
print("Pullning one image from the GPU took " + (getTime() - time) + " msec");
```

When executing the macro on an Intel Core i7-8650U CPU with a built-in Intel UHD Graphics 620 GPU (Windows 10, 64 bit), the output is:

```java
CPU mean filter no 1 took 3043 msec
CPU mean filter no 2 took 4350 msec
CPU mean filter no 3 took 4467 msec
CPU mean filter no 4 took 4611 msec
CPU mean filter no 5 took 4509 msec
CPU mean filter no 6 took 4384 msec
CPU mean filter no 7 took 4422 msec
CPU mean filter no 8 took 4379 msec
CPU mean filter no 9 took 4365 msec
CPU mean filter no 10 took 4372 msec
Pushing two images to the GPU took 819 msec
GPU mean filter no 1 took 872 msec
GPU mean filter no 2 took 183 msec
GPU mean filter no 3 took 192 msec
GPU mean filter no 4 took 195 msec
GPU mean filter no 5 took 212 msec
GPU mean filter no 6 took 251 msec
GPU mean filter no 7 took 305 msec
GPU mean filter no 8 took 300 msec
GPU mean filter no 9 took 260 msec
GPU mean filter no 10 took 263 msec
Pulling one image from the GPU took 1123 msec
```

Thus, on the **CPU it takes 43 seconds**, while using the **GPU it just takes 5 seconds**. Let's execute it again.

```java
CPU mean filter no 1 took 2596 msec
CPU mean filter no 2 took 2739 msec
CPU mean filter no 3 took 2913 msec
CPU mean filter no 4 took 3336 msec
CPU mean filter no 5 took 4643 msec
CPU mean filter no 6 took 4505 msec
CPU mean filter no 7 took 4473 msec
CPU mean filter no 8 took 4524 msec
CPU mean filter no 9 took 4414 msec
CPU mean filter no 10 took 4435 msec
Pushing two images to the GPU took 249 msec
GPU mean filter no 1 took 216 msec
GPU mean filter no 2 took 222 msec
GPU mean filter no 3 took 237 msec
GPU mean filter no 4 took 245 msec
GPU mean filter no 5 took 243 msec
GPU mean filter no 6 took 244 msec
GPU mean filter no 7 took 275 msec
GPU mean filter no 8 took 251 msec
GPU mean filter no 9 took 267 msec
GPU mean filter no 10 took 253 msec
Pulling one image from the GPU took 433 msec
```

On the **CPU it still takes 39 seconds**, while using the **GPU it goes down to three seconds**. 
The additional speedup comes from the caching mechanism mentioned above.

**Heureka, we can spare 90% of the time by executing the operation on the GPU!** 
And this works on a small laptop without dedicated GPU. I tested some more systems, just to see if and how fast CLIJ performs. The following numbers are time measurements from the second run:
* Running the same macro under Fedora linux on an Intel Core i7-8550U CPU with Intel HD Graphics, it takes 10 seconds.
* On an **NVidia TITAN XP, it takes 0.7 seconds**.
* An AMD Ryzen 3 / Vega GPU needed 4 seconds to perform the test.

These are just rough benchmarks. 
When CLIJ matures, I might do a more detailed benchmarking of several methods. 
This example here should just motivate you to test your workflow on a GPU and guide you how to evaluate its performance.

Side note: ImageJs mean filter runs _inplace_. That means the result is stored in the same memory as the input image. 
With every iteration in the for loop, the image becomes more and more blurry. 
The OpenCL operation in the GPU always starts from the _input_ image and puts its result in the _blurred_ image. 
Thus, the resulting images will look different. 
Be a sceptical scietist when processing images in the GPU. 
Check that the workflow is indeed doing the right thing. 
This is especially important when working with experimental software. 

This is the view on results from the mean filter on CPU and GPU together with the difference image of both:

![Image](images/visual_CPU_GPU_comparison.png)

In presented case, have a look at [mean.ijm](https://github.com/clij/clij-docs/blob/master/src/main/macro/mean.ijm) to see how different the results from CPU and GPU actually are. 
In some of the filters, I observed small differences between ImageJ and OpenCL especially at the borders of the images. 
I am aware of these issues. 
There is a large number of [unit tests in the library](https://github.com/clij/clij/blob/master/src/main/java/net/haesleinhuepf/clij/), 
ensuring these differences are small and in case they appear, they only influence the borders.

[Back to CLIJ documentation](https://clij.github.io/)
