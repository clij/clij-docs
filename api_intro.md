
# CLIJ - GPU-accelerated image processing with ImageJ and Java 

CLIJ is a Java library and a ImageJ/Fiji plugin allowing you to run OpenCL GPU accelerated code from Java.

## High level API
The high level API of CLIJ becomes accessible from your Java project by [linking its maven dependency](dependingViaMaven). Furthermore, it can be used from ImageJs scripting languages such as Groovy and Jython from Fijis script editor. Therefore, the [CLIJ update site needs to be activated](installationInFiji).

To get started, you need a `clij` variable containing the CLIJ instance to access the GPU. The following example shows how to do this from ImageJ Jython:
```python
from net.haesleinhuepf.clij import CLIJ;

clij = CLIJ.getInstance();
```

Afterwards, you can convert `ImagePlus` objects to ClearCL objects which makes them accessible on the OpenCL device:

```python
imageInput = clij.push(imp);
```

Furthermore, you can create images, for example with the same size as a given one:
```python
imageOutput = clij.create(imageOutput);
```

Alternatively, create an image with a given size and a given type:

```python
imageOutput = clij.create([imageInput.getWidth(), imageInput.getHeight()], imageInput.getNativeType());
```

Inplace operations are not well supported by OpenCL 1.2. Thus, after creating two images, you can call a kernel taking the first image and filling the pixels of second image with data:

```python

clij.op().maximumZProjection(clij, imageInput, imageOutput);
```

Then, use the `show()` method of `CLIJ` to get the image out of the GPU back to view in ImageJ:

```python
clij.show(imageOutput, "output");
```

You can also get the result image as ImagePlus:

```python
result = clij.pull(imageOutput);
```

A list of all `clij.op()....` methods with example code is available for [ImageJ Jython](https://clij.github.io/clij-docs/referenceJython), [ImageJ/Java](https://clij.github.io/clij-docs/referenceJava) and [ImageJ Groovy](https://clij.github.io/clij-docs/referenceGroovy).

## Low level API

In order to call your own `kernel.cl` files, use the `clij.execute()` method. Example code (Jython):

```python
# initialize the GPU 
clij = CLIJ.getInstance();

# convert ImageJ image to CL images (ready for the GPU)
inputCLBuffer = clij.push(imp);
outputCLBuffer = clij.create(inputCLBuffer); # allocate memory for result image

# downsample the image stack using ClearCL / OpenCL
clij.execute(DownsampleXYbyHalfTask, "kernels/downsampling.cl", "downsample_xy_by_half_nearest", {"src":inputCLBuffer, "dst":outputCLBuffer});

# convert the result back to imglib2 and show it
result = clij.pull(outputCLBuffer);
result.show();

# free memory on the GPU - needs to be done explicitly
inputCLBuffer.close();
outputCLBuffer.close();
```
More examples can be found in the [src/main/jython](https://github.com/clij/clij-docs/blob/master/src/main/jython/) and [src/main/java](https://github.com/clij/clij-docs/blob/master/src/main/java/) directories.

## OpenCL Kernel calls with CLIJ.execute()
The execute function asks for three or four parameters
```
clij.execute(<Class>, "filename_open.cl", "kernelfunction", {"src":image, "dst":image, "more":5, "evenmore":image})

clij.execute("absolute/or/relative/path/filename_open.cl", "kernelfunction", {"src":image, "dst":image, "more":5, "evenmore":image})
```
* An optional class file as an anchor to have a point for where to start
  searching for the program file (second parameter).
* The open.cl program file will be searched for in the same folder where the
  class (first parameter) is defined. In the first example above, this class
  comes with the dependency FastFuse. Alternatively, an absolute path can be
  proveded if there is no class given as first parameter. In case a relative
  path is given, it must be relative from the current dir of Fiji.
* The name of the kernel function defined in the program file
* A dictionary with all the parameters of the kernel function, such as
  "src" and "dst". It is recommended to have at least a "src" and a "dst"
  parameter, because CLIJ derives image data types and global space from
  these parameters.

## Type agnostic OpenCL
As jython is a type-agnostic programming language, CLIJ targets bringing the same convenience to OpenCL as well. However, in order to make the executed OpenCL programs image pixel type agnostic, some conventions must be introduced. The conventions are all optional. OpenCL programmers who know how to pass images of a defined type to OpenCL programs using the correct access functions can skip this section.

* Instead of using functions like `read_imagef()`, `write_imagef()`, `write_imageui()` etc.,
it is recommended to use `WRITE_IMAGE_2D()`, `WRITE_IMAGE_3D()`, `READ_IMAGE_2D()` and `READ_IMAGE_3D()` function calls. These function
calls will be replaced during runtime with the function accessing the correct image data
type. However, in order to allow CLIJ to detect the right image data type, there must
be at least two image type parameters containing "src", "dst", "input", or "output" in their
parameter names. CLIJ will then for example detect the type of an image parameter called
"src_image" and replace all calls to `READ_IMAGE_2D()` with the respective call to
`image_readui()` or `image_readf()` calls.
* Variables inside OpenCL programs can be typed with `DTYPE_IN` and `DTYPE_OUT`
instead of `float` or `int4` in order to make the OpenCL code type agnostic.


[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)
