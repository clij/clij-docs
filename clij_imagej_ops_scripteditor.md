
# CLIJ and Imagej Ops in the Script Editor

Many of CLIJ's Kernels are integrated into ImageJ Ops. [Examples in Jython](https://github.com/clij/clij-ops/tree/master/src/test/resources/jython) are provided.

## Installation

The Ops are available in ImageJ's script editor after installing the [CLIJ update site](installationInFiji.md). 
   
## Initializing CLIJ
 
When calling an Op, a `CLIJService` will automatically initialize CLIJ if this did not already happen. In case you want to initialize CLIJ with a custom GPU, this is the way to go:

```python
#@CLIJService clij

clij.get("Intel(R) HD Graphics Kabylake Desktop GT1.5");
```

## Using Ops

Afterwards, you can convert images to `ClearCLBuffer` objects which makes them accessible on the OpenCL device:

```python
#@IOService io
#@OpService ops

input = io.open("PATH_TO_IMAGE")
inputGPU = ops.run("CLIJ_push", input)
```

Furthermore, you can create images, for example with the same size as a given one:
```python
targetGPU = ops.run("CLIJ_create", inputGPU)
```

Alternatively, create an image with a given size and a given type:

```python
targetGPU = ops.run("CLIJ_create", [input.dimension(0), input.dimension(1), 5], inputGPU.getNativeType())
```

Most CLIJ Ops are hybrid, meaning they can act both as a computer and a function (see the [SpecialOps JavaDoc](https://javadoc.scijava.org/ImageJ/net/imagej/ops/special/SpecialOp.html) for further details). There are no inplace operations in CLIJ. 

In this example the output object will be automatically generated and returned by the Op (function):
```python
imageOutput = ops.run("CLIJ_maximumZProjection", imageInput)
```

In the next example both the input and the output are created beforehand and handed to the Op (computer):
```python
ops.run("CLIJ_maximumZProjection", imageOutput, imageInput)
```
**CAUTION** 
Be aware that in this case the output is the first and the input is the second parameter, in contrast to other CLIJ APIs where the order is the other way around. 
The next ImageJ Op generation will revert this order, meaning that the order might change in a future version of CLIJ as well.


To get the image back into `imglib2` format, call the `CLIJ_pull` op:

```python
#@UIService ui

target = ops.run("CLIJ_pull", targetGPU)
ui.show(target)

```

More examples can be found [here](https://github.com/clij/clij-ops/tree/master/src/test/resources/jython).


[Back to CLIJ documentation](readme)
