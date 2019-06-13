
# CLIJ and Imagej Ops in Java

Many of CLIJ's Kernels are also available as ImageJ Ops. There is also an extensive list of [examples](https://github.com/clij/clij-ops/tree/master/src/test/java/net/haesleinhuepf/clij/ops/examples).

## Installation

To use the CLIJ ImageJ Ops in your own project, link it as a maven dependency:

```xml
<dependency>
  <groupId>net.haesleinhuepf</groupId>
  <artifactId>clij-ops</artifactId>
  <version>1.0.4</version>
</dependency>
```

To allow maven finding this artifact, add a repository to your pom.xml file:

```xml
<repository>
  <id>clij</id>
  <url>http://dl.bintray.com/haesleinhuepf/clij</url>
</repository>
```
 
## Initializing CLIJ
 
When calling an Op, a `CLIJService` will automatically initialize CLIJ if this did not already happen. In case you want to initialize CLIJ with a custom GPU, this is the way to go:

```java
import net.imagej.ImageJ;
import net.haesleinhuepf.clij.CLIJService;

ImageJ ij = new ImageJ();
ij.get(CLIJService.class).get("Intel(R) HD Graphics Kabylake Desktop GT1.5");
```

## Using Ops

Afterwards, you can convert `RandomAccessibleInterval` or `Img` objects to `ClearCLBuffer` objects which makes them accessible on the OpenCL device:

```Java
Object input = ij.io().open("PATH_TO_IMAGE");
Object inputGPU = ij.op().run(CLIJ_push.class, input);
```

In this example, `inputGPU` is of type `ClearCLBuffer`, but while staying in the Ops domain `Object` works fine and reduces casting. Which you can still do if you want to access it's methods.
```Java
ClearCLBuffer buffer = (ClearCLBuffer) inputGPU;
```

Furthermore, you can create images, for example with the same size as a given one:
```Java
Object targetGPU = ij.op().run(CLIJ_create.class, inputGPU);
```

Alternatively, create an image with a given size and a given type:

```Java
Object targetGPU = ij.op().run(CLIJ_create.class, new long[] { buffer.getWidth(), buffer.getHeight() }, buffer.getNativeType());
```

Most CLIJ Ops are hybrid, meaning they can act both as a computer and a function (see the [SpecialOps JavaDoc](https://javadoc.scijava.org/ImageJ/net/imagej/ops/special/SpecialOp.html) for further details). There are no inplace operations in CLIJ. 

In this example the output object will be automatically generated and returned by the Op (function):
```Java

targetGPU = ij.op().run(CLIJ_maximumZProjection.class, inputGPU);
```

In the next example both the input and the output are created beforehand and handed to the Op (computer):
```Java

ij.op().run(CLIJ_maximumZProjection.class, targetGPU, inputGPU);
```
**CAUTION** 
Be aware that in this case the output is the first and the input is the second parameter, in contrast to other CLIJ APIs where the order is the other way around. 
The next ImageJ Op generation will revert this order, meaning that the order might change in a future version of CLIJ as well.


To get the image back into `imglib2` format, call the `CLIJ_pull` op:

```Java
Object target = ij.op().run(CLIJ_pull.class, targetGPU);
ij.ui().show(target);
```
More examples can be found [here](https://github.com/clij/clij-ops/tree/master/src/test/java/net/haesleinhuepf/clij/ops/examples).

[Back to CLIJ documentation](https://clij.github.io/)
