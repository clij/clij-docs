# CLIJ reference for ImageJ Groovy

## absolute( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the absolute value of every individual pixel x in a given image.

<pre>f(x) = |x| </pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().absolute(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## addImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar )

Adds a scalar value s to all pixels x of a given image X.

<pre>f(x, s) = x + s</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
scalar = 1.0;
```

```
// Execute operation on GPU
clij.op().addImageAndScalar(src, dst, scalar);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## addImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Calculates the sum of pairs of pixels x and y of two images X and Y.

<pre>f(x, y) = x + y</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().addImages(src, src1, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
```

## addImagesWeighted( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst,  Float factor,  Float factor1 )

Calculates the sum of pairs of pixels x and y from images X and Y weighted with factors a and b.

<pre>f(x, y, a, b) = x * a + y * b</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst,  Float factor,  Float factor1 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
factor = 1.0;
factor1 = 2.0;
```

```
// Execute operation on GPU
clij.op().addImagesWeighted(src, src1, dst, factor, factor1);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
```

## affineTransform( ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform3D at )

CLIJ affineTransform is deprecated. Use affineTransform2D or affineTransform3D instead.

Applies an affine transform to a 3D image. Individual transforms must be separated by spaces.

Supported transforms:
* center: translate the coordinate origin to the center of the image
* -center: translate the coordinate origin back to the initial origin
* rotate=[angle]: rotate in X/Y plane (around Z-axis) by the given angle in degrees
* rotateX=[angle]: rotate in Y/Z plane (around X-axis) by the given angle in degrees
* rotateY=[angle]: rotate in X/Z plane (around Y-axis) by the given angle in degrees
* rotateZ=[angle]: rotate in X/Y plane (around Z-axis) by the given angle in degrees
* scale=[factor]: isotropic scaling according to given zoom factor
* scaleX=[factor]: scaling along X-axis according to given zoom factor
* scaleY=[factor]: scaling along Y-axis according to given zoom factor
* scaleZ=[factor]: scaling along Z-axis according to given zoom factor
* shearXY=[factor]: shearing along X-axis in XY plane according to given factor
* shearXZ=[factor]: shearing along X-axis in XZ plane according to given factor
* shearYX=[factor]: shearing along Y-axis in XY plane according to given factor
* shearYZ=[factor]: shearing along Y-axis in YZ plane according to given factor
* shearZX=[factor]: shearing along Z-axis in XZ plane according to given factor
* shearZY=[factor]: shearing along Z-axis in YZ plane according to given factor
* translateX=[distance]: translate along X-axis by distance given in pixels
* translateY=[distance]: translate along X-axis by distance given in pixels
* translateZ=[distance]: translate along X-axis by distance given in pixels

Example transform:
transform = "center scale=2 rotate=45 -center";

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform3D at 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
at = new AffineTransform3D();
at.translate(4, 0, 0);
```

```
// Execute operation on GPU
clij.op().affineTransform(src, dst, at);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## affineTransform( ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix )

CLIJ affineTransform is deprecated. Use affineTransform2D or affineTransform3D instead.

Applies an affine transform to a 3D image. Individual transforms must be separated by spaces.

Supported transforms:
* center: translate the coordinate origin to the center of the image
* -center: translate the coordinate origin back to the initial origin
* rotate=[angle]: rotate in X/Y plane (around Z-axis) by the given angle in degrees
* rotateX=[angle]: rotate in Y/Z plane (around X-axis) by the given angle in degrees
* rotateY=[angle]: rotate in X/Z plane (around Y-axis) by the given angle in degrees
* rotateZ=[angle]: rotate in X/Y plane (around Z-axis) by the given angle in degrees
* scale=[factor]: isotropic scaling according to given zoom factor
* scaleX=[factor]: scaling along X-axis according to given zoom factor
* scaleY=[factor]: scaling along Y-axis according to given zoom factor
* scaleZ=[factor]: scaling along Z-axis according to given zoom factor
* shearXY=[factor]: shearing along X-axis in XY plane according to given factor
* shearXZ=[factor]: shearing along X-axis in XZ plane according to given factor
* shearYX=[factor]: shearing along Y-axis in XY plane according to given factor
* shearYZ=[factor]: shearing along Y-axis in YZ plane according to given factor
* shearZX=[factor]: shearing along Z-axis in XZ plane according to given factor
* shearZY=[factor]: shearing along Z-axis in YZ plane according to given factor
* translateX=[distance]: translate along X-axis by distance given in pixels
* translateY=[distance]: translate along X-axis by distance given in pixels
* translateZ=[distance]: translate along X-axis by distance given in pixels

Example transform:
transform = "center scale=2 rotate=45 -center";

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().affineTransform(src, dst, matrix);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## affineTransform2D( ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform2D at )

Applies an affine transform to a 2D image.


**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform2D at 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().affineTransform2D(src, dst, at);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## affineTransform2D( ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix )

Applies an affine transform to a 2D image.


**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().affineTransform2D(src, dst, matrix);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## affineTransform3D( ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform3D at )

Applies an affine transform to a 3D image.


**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform3D at 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
at = new AffineTransform3D();
at.translate(4, 0, 0);
```

```
// Execute operation on GPU
clij.op().affineTransform3D(src, dst, at);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## affineTransform3D( ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix )

Applies an affine transform to a 3D image.


**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().affineTransform3D(src, dst, matrix);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## applyVectorfield( ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer dst )

Deforms an image according to distances provided in the given vector images. It is recommended to use 32-bit images for input, output and vector images. 

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
vectorX = clij.push(vectorXImagePlus);
vectorY = clij.push(vectorYImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().applyVectorfield(src, vectorX, vectorY, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
vectorX.close();
vectorY.close();
dst.close();
```

## applyVectorfield( ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer vectorZ,  ClearCLBuffer dst )

Deforms an image according to distances provided in the given vector images. It is recommended to use 32-bit images for input, output and vector images. 

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer vectorZ,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
vectorX = clij.push(vectorXImagePlus);
vectorY = clij.push(vectorYImagePlus);
vectorZ = clij.push(vectorZImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().applyVectorfield(src, vectorX, vectorY, vectorZ, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
vectorX.close();
vectorY.close();
vectorZ.close();
dst.close();
```

## argMaximumZProjection( ClearCLBuffer src,  ClearCLBuffer dst_max,  ClearCLBuffer dst_arg )

Determines the maximum projection of an image stack along Z.
Furthermore, another 2D image is generated with pixels containing the z-index where the maximum was found (zero based).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_max,  ClearCLBuffer dst_arg 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_max = clij.create(src);
dst_arg = clij.create(src);
```

```
// Execute operation on GPU
clij.op().argMaximumZProjection(src, dst_max, dst_arg);
```

```
//show result
dst_maxImagePlus = clij.pull(dst_max);
dst_maxImagePlus.show());
dst_argImagePlus = clij.pull(dst_arg);
dst_argImagePlus.show());

// cleanup memory on GPU
src.close();
dst_max.close();
dst_arg.close();
```

## automaticThreshold( ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod )

The automatic thresholder utilizes the threshold methods from ImageJ on a histogram determined on 
the GPU to create binary images as similar as possible to ImageJ 'Apply Threshold' method. Enter one 
of these methods in the method text field:
[Default, Huang, Intermodes, IsoData, IJ_IsoData, Li, MaxEntropy, Mean, MinError, Minimum, Moments, Otsu, Percentile, RenyiEntropy, Shanbhag, Triangle, Yen]

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().automaticThreshold(src, dst, userSelectedMethod);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## automaticThreshold( ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod,  Float minimumGreyValue,  Float maximumGreyValue,  Integer numberOfBins )

The automatic thresholder utilizes the threshold methods from ImageJ on a histogram determined on 
the GPU to create binary images as similar as possible to ImageJ 'Apply Threshold' method. Enter one 
of these methods in the method text field:
[Default, Huang, Intermodes, IsoData, IJ_IsoData, Li, MaxEntropy, Mean, MinError, Minimum, Moments, Otsu, Percentile, RenyiEntropy, Shanbhag, Triangle, Yen]

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod,  Float minimumGreyValue,  Float maximumGreyValue,  Integer numberOfBins 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
minimumGreyValue = 1.0;
maximumGreyValue = 2.0;
numberOfBins = 10;
```

```
// Execute operation on GPU
clij.op().automaticThreshold(src, dst, userSelectedMethod, minimumGreyValue, maximumGreyValue, numberOfBins);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## binaryAnd( ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary AND operator &.
All pixel values except 0 in the input images are interpreted as 1.

<pre>f(x, y) = x & y</pre>

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
src2 = clij.push(src2ImagePlus);
dst = clij.create(src1);
```

```
// Execute operation on GPU
clij.op().binaryAnd(src1, src2, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
src2.close();
dst.close();
```

## binaryNot( ClearCLBuffer src1,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from an image X by negating its pixel values
x using the binary NOT operator !
All pixel values except 0 in the input image are interpreted as 1.

<pre>f(x) = !x</pre>

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
dst = clij.create(src1);
```

```
// Execute operation on GPU
clij.op().binaryNot(src1, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
dst.close();
```

## binaryOr( ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary OR operator |.
All pixel values except 0 in the input images are interpreted as 1.<pre>f(x, y) = x | y</pre>

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
src2 = clij.push(src2ImagePlus);
dst = clij.create(src1);
```

```
// Execute operation on GPU
clij.op().binaryOr(src1, src2, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
src2.close();
dst.close();
```

## binaryXOr( ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary operators AND &, OR | and NOT ! implementing the XOR operator.
All pixel values except 0 in the input images are interpreted as 1.

<pre>f(x, y) = (x & !y) | (!x & y)</pre>

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
src2 = clij.push(src2ImagePlus);
dst = clij.create(src1);
```

```
// Execute operation on GPU
clij.op().binaryXOr(src1, src2, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
src2.close();
dst.close();
```

## blur( ClearCLBuffer src,  ClearCLBuffer dst,  Float blurSigmaX,  Float blurSigmaY )

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

The implementation is done separable. In case a sigma equals zero, the direction is not blurred.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float blurSigmaX,  Float blurSigmaY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
blurSigmaX = 1.0;
blurSigmaY = 2.0;
```

```
// Execute operation on GPU
clij.op().blur(src, dst, blurSigmaX, blurSigmaY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## blur( ClearCLBuffer src,  ClearCLBuffer dst,  Float blurSigmaX,  Float blurSigmaY,  Float blurSigmaZ )

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

The implementation is done separable. In case a sigma equals zero, the direction is not blurred.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float blurSigmaX,  Float blurSigmaY,  Float blurSigmaZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
blurSigmaX = 1.0;
blurSigmaY = 2.0;
blurSigmaZ = 3.0;
```

```
// Execute operation on GPU
clij.op().blur(src, dst, blurSigmaX, blurSigmaY, blurSigmaZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## blurSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst,  int kernelSizeX,  int kernelSizeY,  float sigmaX,  float sigmaY )

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

The Gaussian blur is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int kernelSizeX,  int kernelSizeY,  float sigmaX,  float sigmaY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().blurSliceBySlice(src, dst, kernelSizeX, kernelSizeY, sigmaX, sigmaY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## centerOfMass( ClearCLBuffer input )

Determines the center of mass of an image or image stack and writes the result in the results table
in the columns MassX, MassY and MassZ.

**Parameters**:  ClearCLBuffer input 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input = clij.push(inputImagePlus);
```

```
// Execute operation on GPU
resultCenterOfMass = clij.op().centerOfMass(input);
```

```
//show result
print(resultCenterOfMass);

// cleanup memory on GPU
input.close();
```

## convertToImageJBinary( ClearCLBuffer src,  ClearCLBuffer dst )

Convert a binary image to an image with values 0 and 255 as it can be interpreted by ImageJ as binary image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().convertToImageJBinary(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## copy( ClearCLBuffer src,  ClearCLBuffer dst )

Copies an image.

<pre>f(x) = x</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().copy(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## copySlice( ClearCLBuffer src,  ClearCLBuffer dst,  Integer planeIndex )

Copies a slice with a given index out of an input image stack into a 2D image, if 3D and 2D image are given as parameters. OrCopies a given slice into a given image stack, if 2D and 3D images are given as parameters.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer planeIndex 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
planeIndex = 10;
```

```
// Execute operation on GPU
clij.op().copySlice(src, dst, planeIndex);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## countNonZeroPixelsLocally( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radiusX,  Integer radiusY )

Counts non-zero pixels in the neighborhood of every pixel in a 2D image and writes the resulting count in the corresponding pixel of the target image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radiusX,  Integer radiusY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radiusX = 10;
radiusY = 20;
```

```
// Execute operation on GPU
clij.op().countNonZeroPixelsLocally(src, dst, radiusX, radiusY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## countNonZeroPixelsLocallySliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radiusX,  Integer radiusY )

Counts non-zero pixels in the 2D-neighborhood of every pixel in a 3D image stack and writes the resulting count in the corresponding pixel of the target image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radiusX,  Integer radiusY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radiusX = 10;
radiusY = 20;
```

```
// Execute operation on GPU
clij.op().countNonZeroPixelsLocallySliceBySlice(src, dst, radiusX, radiusY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## countNonZeroVoxelsLocally( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radiusX,  Integer radiusY,  Integer radiusZ )

Counts non-zero pixels in the 2D-neighborhood of every pixel in a 3D image stack and writes the resulting count in the corresponding pixel of the target image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radiusX,  Integer radiusY,  Integer radiusZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radiusX = 10;
radiusY = 20;
radiusZ = 30;
```

```
// Execute operation on GPU
clij.op().countNonZeroVoxelsLocally(src, dst, radiusX, radiusY, radiusZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## crop( ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY )

Crops out a region of a 2D image or a substack out of a given image stack. Size of the region is determined from the given destination image stack.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
startX = 10;
startY = 20;
```

```
// Execute operation on GPU
clij.op().crop(src, dst, startX, startY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## crop( ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY,  Integer startZ )

Crops out a region of a 2D image or a substack out of a given image stack. Size of the region is determined from the given destination image stack.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY,  Integer startZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
startX = 10;
startY = 20;
startZ = 30;
```

```
// Execute operation on GPU
clij.op().crop(src, dst, startX, startY, startZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## detectMaximaBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local maxima in a given square/cubic neighborhood. Pixels in the resulting image are set to 1 if
there is no other pixel in a given radius which has a higher intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().detectMaximaBox(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## detectMaximaSliceBySliceBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local maxima in a given square neighborhood of an input image stack. The input image stack is 
processed slice by slice. Pixels in the resulting image are set to 1 if there is no other pixel in a 
given radius which has a higher intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().detectMaximaSliceBySliceBox(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## detectMinimaBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local minima in a given square/cubic neighborhood. Pixels in the resulting image are set to 1 if
there is no other pixel in a given radius which has a lower intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().detectMinimaBox(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## detectMinimaSliceBySliceBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local minima in a given square neighborhood of an input image stack. The input image stack is 
processed slice by slice. Pixels in the resulting image are set to 1 if there is no other pixel in a 
given radius which has a lower intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().detectMinimaSliceBySliceBox(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## detectOptima( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima )

It is recommended to detectMaxima and detectMinima.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
detectMaxima = true;
```

```
// Execute operation on GPU
clij.op().detectOptima(src, dst, radius, detectMaxima);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## detectOptimaSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima )

It is recommended to detectMaximaSliceBySlice and detectMinimaSliceBySlice.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
detectMaxima = true;
```

```
// Execute operation on GPU
clij.op().detectOptimaSliceBySlice(src, dst, radius, detectMaxima);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## dilateBox( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary dilation of a given input image.
The dilation takes the Moore-neighborhood (8 pixels in 2D and 26 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This method is comparable to the 'Dilate' menu in ImageJ in case it is applied to a 2D image. The only
difference is that the output image contains values 0 and 1 instead of 0 and 255.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().dilateBox(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## dilateBoxSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary dilation of a given input image.
The dilation takes the Moore-neighborhood (8 pixels in 2D and 26 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This method is comparable to the 'Dilate' menu in ImageJ in case it is applied to a 2D image. The only
difference is that the output image contains values 0 and 1 instead of 0 and 255.

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().dilateBoxSliceBySlice(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## dilateSphere( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary dilation of a given input image.
The dilation takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().dilateSphere(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## dilateSphereSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary dilation of a given input image.
The dilation takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().dilateSphereSliceBySlice(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## divideImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Divides two images X and Y by each other pixel wise.

<pre>f(x, y) = x / y</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().divideImages(src, src1, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
```

## downsample( ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY )

Scales an image using given scaling factors for X and Y dimensions. The nearest-neighbor method
is applied. In ImageJ the method which is similar is called 'Interpolation method: none'.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
factorX = 1.0;
factorY = 2.0;
```

```
// Execute operation on GPU
clij.op().downsample(src, dst, factorX, factorY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## downsample( ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY,  Float factorZ )

Scales an image using given scaling factors for X and Y dimensions. The nearest-neighbor method
is applied. In ImageJ the method which is similar is called 'Interpolation method: none'.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY,  Float factorZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
factorX = 1.0;
factorY = 2.0;
factorZ = 3.0;
```

```
// Execute operation on GPU
clij.op().downsample(src, dst, factorX, factorY, factorZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## downsampleSliceBySliceHalfMedian( ClearCLBuffer src,  ClearCLBuffer dst )

Scales an image using scaling factors 0.5 for X and Y dimensions. The Z dimension stays untouched. Thus, each slice is processed separately.
The median method is applied. Thus, each pixel value in the destination image equals to the median of
four corresponding pixels in the source image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().downsampleSliceBySliceHalfMedian(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## erodeBox( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the Moore-neighborhood (8 pixels in 2D and 26 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This method is comparable to the 'Erode' menu in ImageJ in case it is applied to a 2D image. The only
difference is that the output image contains values 0 and 1 instead of 0 and 255.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().erodeBox(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## erodeBoxSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the Moore-neighborhood (8 pixels in 2D and 26 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This method is comparable to the 'Erode' menu in ImageJ in case it is applied to a 2D image. The only
difference is that the output image contains values 0 and 1 instead of 0 and 255.

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().erodeBoxSliceBySlice(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## erodeSphere( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().erodeSphere(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## erodeSphereSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().erodeSphereSliceBySlice(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## fillHistogram( ClearCLBuffer src,  ClearCLBuffer dstHistogram,  Float minimumGreyValue,  Float maximumGreyValue )

Generates a histogram of a 2D image or 3D stack and writes into a 2D image where X corresponds to the bin index and Y corresponds to the count of found pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dstHistogram,  Float minimumGreyValue,  Float maximumGreyValue 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dstHistogram = clij.create(src);
minimumGreyValue = 1.0;
maximumGreyValue = 2.0;
```

```
// Execute operation on GPU
clij.op().fillHistogram(src, dstHistogram, minimumGreyValue, maximumGreyValue);
```

```
//show result
dstHistogramImagePlus = clij.pull(dstHistogram);
dstHistogramImagePlus.show());

// cleanup memory on GPU
src.close();
dstHistogram.close();
```

## flip( ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy )

Flips an image in X and/or Y direction depending on boolean flags.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
flipx = true;
flipy = false;
```

```
// Execute operation on GPU
clij.op().flip(src, dst, flipx, flipy);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## flip( ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy,  Boolean flipz )

Flips an image in X and/or Y direction depending on boolean flags.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy,  Boolean flipz 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
flipx = true;
flipy = false;
flipz = false;
```

```
// Execute operation on GPU
clij.op().flip(src, dst, flipx, flipy, flipz);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## gradientX( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the gradient of gray values along X. Assuming a, b and c are three adjacent
 pixels in X direction. In the target image will be saved as: <pre>b' = c - a;</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().gradientX(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## gradientY( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the gradient of gray values along Y. Assuming a, b and c are three adjacent
 pixels in Y direction. In the target image will be saved as: <pre>b' = c - a;</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().gradientY(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## gradientZ( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the gradient of gray values along Z. Assuming a, b and c are three adjacent
 pixels in Z direction. In the target image will be saved as: <pre>b' = c - a;</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().gradientZ(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## histogram( ClearCLBuffer image,  Float minGreyValue,  Float maxGreyValue,  Integer numberOfBins )

Determines the histogram of a given image.

**Parameters**:  ClearCLBuffer image,  Float minGreyValue,  Float maxGreyValue,  Integer numberOfBins 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
image = clij.push(imageImagePlus);
minGreyValue = 1.0;
maxGreyValue = 2.0;
numberOfBins = 10;
```

```
// Execute operation on GPU
resultHistogram = clij.op().histogram(image, minGreyValue, maxGreyValue, numberOfBins);
```

```
//show result
print(resultHistogram);

// cleanup memory on GPU
image.close();
```

## invert( ClearCLBuffer input3d,  ClearCLBuffer output3d )

Computes the negative value of all pixels in a given image. It is recommended to convert images to 
32-bit float before applying this operation.

<pre>f(x) = - x</pre>

For binary images, use binaryNot.

**Parameters**:  ClearCLBuffer input3d,  ClearCLBuffer output3d 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input3d = clij.push(input3dImagePlus);
output3d = clij.create(input3d);
```

```
// Execute operation on GPU
clij.op().invert(input3d, output3d);
```

```
//show result
output3dImagePlus = clij.pull(output3d);
output3dImagePlus.show());

// cleanup memory on GPU
input3d.close();
output3d.close();
```

## localThreshold( ClearCLBuffer src,  ClearCLBuffer dst,  ClearCLBuffer threshold )

Computes a binary image with pixel values 0 and 1 depending on if a pixel value x in image X 
was above of equal to the pixel value m in mask image M.

<pre>f(x) = (1 if (x >=  m)); (0 otherwise)</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  ClearCLBuffer threshold 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
threshold = clij.push(thresholdImagePlus);
```

```
// Execute operation on GPU
clij.op().localThreshold(src, dst, threshold);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
threshold.close();
```

## mask( ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst )

Computes a masked image by applying a mask to an image. All pixel values x of image X will be copied
to the destination image in case pixel value m at the same position in the mask image is not equal to 
zero.

<pre>f(x,m) = (x if (m != 0); (0 otherwise))</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
mask = clij.push(maskImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().mask(src, mask, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
mask.close();
dst.close();
```

## maskStackWithPlane( ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst )

Computes a masked image by applying a 2D mask to an image stack. All pixel values x of image X will be copied
to the destination image in case pixel value m at the same spatial position in the mask image is not equal to 
zero.

<pre>f(x,m) = (x if (m != 0); (0 otherwise))</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
mask = clij.push(maskImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().maskStackWithPlane(src, mask, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
mask.close();
dst.close();
```

## maximumBox( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )

Computes the local maximum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().maximumBox(src, dst, radiusX, radiusY, radiusZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## maximumIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

This method is deprecated. Consider using maximumBox or maximumSphere instead.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().maximumIJ(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## maximumImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB )

Computes the maximum of a constant scalar s and each pixel value x in a given image X.

<pre>f(x, s) = max(x, s)</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
valueB = 1.0;
```

```
// Execute operation on GPU
clij.op().maximumImageAndScalar(src, dst, valueB);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## maximumImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Computes the maximum of a pair of pixel values x, y from two given images X and Y.

<pre>f(x, y) = max(x, y)</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().maximumImages(src, src1, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
```

## maximumOfAllPixels( ClearCLBuffer clImage )

Determines the maximum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Max'.

**Parameters**:  ClearCLBuffer clImage 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
```

```
// Execute operation on GPU
resultMaximumOfAllPixels = clij.op().maximumOfAllPixels(clImage);
```

```
//show result
print(resultMaximumOfAllPixels);

// cleanup memory on GPU
clImage.close();
```

## maximumSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local maximum of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().maximumSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## maximumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local maximum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().maximumSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## maximumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )

Computes the local maximum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;
```

```
// Execute operation on GPU
clij.op().maximumSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## maximumXYZProjection( ClearCLBuffer src,  ClearCLBuffer dst_max,  Integer projectedDimensionX,  Integer projectedDimensionY,  Integer projectedDimension )

Determines the maximum projection of an image along a given dimension. Furthermore, the X and Y
 dimesions of the resulting image must be specified by the user according to its definition:
X = 0
Y = 1
Z = 2


**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_max,  Integer projectedDimensionX,  Integer projectedDimensionY,  Integer projectedDimension 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_max = clij.create(src);
projectedDimensionX = 10;
projectedDimensionY = 20;
projectedDimension = 30;
```

```
// Execute operation on GPU
clij.op().maximumXYZProjection(src, dst_max, projectedDimensionX, projectedDimensionY, projectedDimension);
```

```
//show result
dst_maxImagePlus = clij.pull(dst_max);
dst_maxImagePlus.show());

// cleanup memory on GPU
src.close();
dst_max.close();
```

## maximumZProjection( ClearCLBuffer src,  ClearCLBuffer dst_max )

Determines the maximum projection of an image along Z.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_max 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_max = clij.create(src);
```

```
// Execute operation on GPU
clij.op().maximumZProjection(src, dst_max);
```

```
//show result
dst_maxImagePlus = clij.pull(dst_max);
dst_maxImagePlus.show());

// cleanup memory on GPU
src.close();
dst_max.close();
```

## meanBox( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )

Computes the local mean average of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().meanBox(src, dst, radiusX, radiusY, radiusZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## meanIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

This method is deprecated. Consider using meanBox or meanSphere instead.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().meanIJ(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## meanSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local mean average of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().meanSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## meanSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local mean average of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().meanSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## meanSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )

Computes the local mean average of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;
```

```
// Execute operation on GPU
clij.op().meanSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## meanZProjection( ClearCLBuffer src,  ClearCLBuffer dst )

Determines the mean average projection of an image along Z.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().meanZProjection(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## medianBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local median of a pixels rectangular neighborhood. The rectangle is specified by 
its half-width and half-height (radius).

For technical reasons, the area of the rectangle must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().medianBox(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## medianBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )

Computes the local median of a pixels rectangular neighborhood. The rectangle is specified by 
its half-width and half-height (radius).

For technical reasons, the area of the rectangle must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;
```

```
// Execute operation on GPU
clij.op().medianBox(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## medianSliceBySliceBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local median of a pixels rectangular neighborhood. This is done slice-by-slice in a 3D 
image stack. The rectangle is specified by its half-width and half-height (radius).

For technical reasons, the area of the rectangle must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().medianSliceBySliceBox(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## medianSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local median of a pixels ellipsoidal neighborhood. This is done slice-by-slice in a 3D 
image stack. The ellipses size is specified by its half-width and half-height (radius).

For technical reasons, the area of the ellipse must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().medianSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## medianSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local median of a pixels rectangular neighborhood. The rectangle is specified by 
its half-width and half-height (radius).

For technical reasons, the area of the rectangle must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().medianSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## medianSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )

Computes the local median of a pixels rectangular neighborhood. The rectangle is specified by 
its half-width and half-height (radius).

For technical reasons, the area of the rectangle must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;
```

```
// Execute operation on GPU
clij.op().medianSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumBox( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )

Computes the local minimum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().minimumBox(src, dst, radiusX, radiusY, radiusZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

This method is deprecated. Consider using minimumBox or minimumSphere instead.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
```

```
// Execute operation on GPU
clij.op().minimumIJ(src, dst, radius);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB )

Computes the maximum of a constant scalar s and each pixel value x in a given image X.

<pre>f(x, s) = min(x, s)</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
valueB = 1.0;
```

```
// Execute operation on GPU
clij.op().minimumImageAndScalar(src, dst, valueB);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Computes the minimum of a pair of pixel values x, y from two given images X and Y.

<pre>f(x, y) = min(x, y)</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().minimumImages(src, src1, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
```

## minimumOfAllPixels( ClearCLBuffer clImage )

Determines the minimum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Min'.

**Parameters**:  ClearCLBuffer clImage 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
```

```
// Execute operation on GPU
resultMinimumOfAllPixels = clij.op().minimumOfAllPixels(clImage);
```

```
//show result
print(resultMinimumOfAllPixels);

// cleanup memory on GPU
clImage.close();
```

## minimumSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local minimum of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

This filter is applied slice by slice in 2D.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().minimumSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local minimum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
```

```
// Execute operation on GPU
clij.op().minimumSphere(src, dst, kernelSizeX, kernelSizeY);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )

Computes the local minimum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;
```

```
// Execute operation on GPU
clij.op().minimumSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## minimumZProjection( ClearCLBuffer src,  ClearCLBuffer dst_min )

Determines the minimum projection of an image along Z.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_min 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_min = clij.create(src);
```

```
// Execute operation on GPU
clij.op().minimumZProjection(src, dst_min);
```

```
//show result
dst_minImagePlus = clij.pull(dst_min);
dst_minImagePlus.show());

// cleanup memory on GPU
src.close();
dst_min.close();
```

## multiplyImageAndCoordinate( ClearCLBuffer src,  ClearCLBuffer dst,  Integer dimension )

Multiply every pixel intensity with its X/Y/Z coordinate depending on given dimension.
This method can be used to calculate the center of mass of an image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer dimension 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
dimension = 10;
```

```
// Execute operation on GPU
clij.op().multiplyImageAndCoordinate(src, dst, dimension);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## multiplyImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar )

Multiplies all pixels value x in a given image X with a constant scalar s.

<pre>f(x, s) = x * s</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
scalar = 1.0;
```

```
// Execute operation on GPU
clij.op().multiplyImageAndScalar(src, dst, scalar);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## multiplyImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Multiplies all pairs of pixel values x and y from two image X and Y.

<pre>f(x, y) = x * y</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().multiplyImages(src, src1, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
```

## multiplySliceBySliceWithScalars( ClearCLBuffer src,  ClearCLBuffer dst,  float[] scalars )

Multiplies all pixels value x in input image X with a scalar s given as an array with values for every z-slice.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float[] scalars 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().multiplySliceBySliceWithScalars(src, dst, scalars);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## multiplyStackWithPlane( ClearCLBuffer input3d,  ClearCLBuffer input2d,  ClearCLBuffer output3d )

Multiplies all pairs of pixel values x and y from an image stack X and a 2D image Y. x and y are at 
the same spatial position within a plane.

<pre>f(x, y) = x * y</pre>

**Parameters**:  ClearCLBuffer input3d,  ClearCLBuffer input2d,  ClearCLBuffer output3d 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input3d = clij.push(input3dImagePlus);
input2d = clij.push(input2dImagePlus);
output3d = clij.create(input3d);
```

```
// Execute operation on GPU
clij.op().multiplyStackWithPlane(input3d, input2d, output3d);
```

```
//show result
output3dImagePlus = clij.pull(output3d);
output3dImagePlus.show());

// cleanup memory on GPU
input3d.close();
input2d.close();
output3d.close();
```

## power( ClearCLBuffer src,  ClearCLBuffer dst,  Float exponent )

Computes all pixels value x to the power of a given exponent a.

<pre>f(x, a) = x ^ a</pre>

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float exponent 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
exponent = 1.0;
```

```
// Execute operation on GPU
clij.op().power(src, dst, exponent);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## radialProjection( ClearCLBuffer src,  ClearCLBuffer dst,  Float deltaAngle )

Computes a radial projection of an image stack. Starting point for the line is the center in any 
X/Y-plane of a given input image stack. This operation is similar to ImageJs 'Radial Reslice' method but offers less flexibility.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float deltaAngle 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
deltaAngle = 1.0;
```

```
// Execute operation on GPU
clij.op().radialProjection(src, dst, deltaAngle);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## resliceBottom( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method but
offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().resliceBottom(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## resliceLeft( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes X, Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method 
 but offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().resliceLeft(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## resliceRight( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes X, Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method 
 but offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().resliceRight(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## resliceTop( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method but
offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().resliceTop(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## rotateLeft( ClearCLBuffer src,  ClearCLBuffer dst )

Rotates a given input image by 90 degrees counter-clockwise. For that, X and Y axis of an image stack
are flipped. This operation is similar to ImageJs 'Reslice [/]' method but offers less flexibility 
such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().rotateLeft(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## rotateRight( ClearCLBuffer src,  ClearCLBuffer dst )

Rotates a given input image by 90 degrees clockwise. For that, X and Y axis of an image stack
are flipped. This operation is similar to ImageJs 'Reslice [/]' method but offers less flexibility 
such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
```

```
// Execute operation on GPU
clij.op().rotateRight(src, dst);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```

## set( ClearCLBuffer clImage,  Float value )

Sets all pixel values x of a given image X to a constant value v.

<pre>f(x) = v</pre>

**Parameters**:  ClearCLBuffer clImage,  Float value 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
value = 1.0;
```

```
// Execute operation on GPU
clij.op().set(clImage, value);
```

```
//show result

// cleanup memory on GPU
clImage.close();
```

## splitStack( ClearCLBuffer clImageIn,  ClearCLBuffer... clImagesOut )

Splits an input stack into #n# image stacks. 
 * Slices 0, n, 2*n, ... will become part of the first output stack.
 * Slices 1, n+1, 2*n+1, ... will become part of the second output stack.
Only up to 12 output stacks are supported.

**Parameters**:  ClearCLBuffer clImageIn,  ClearCLBuffer... clImagesOut 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImageIn = clij.push(clImageInImagePlus);
clImagesOut = clij.push(clImagesOutImagePlus);
```

```
// Execute operation on GPU
clij.op().splitStack(clImageIn, clImagesOut);
```

```
//show result

// cleanup memory on GPU
clImageIn.close();
clImagesOut.close();
```

## subtract( ClearCLBuffer source1,  ClearCLBuffer source2,  ClearCLBuffer destination )

Subtracts one image X from another image Y pixel wise.

<pre>f(x, y) = x - y</pre>

**Parameters**:  ClearCLBuffer source1,  ClearCLBuffer source2,  ClearCLBuffer destination 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
source1 = clij.push(source1ImagePlus);
source2 = clij.push(source2ImagePlus);
destination = clij.create(source1);
```

```
// Execute operation on GPU
clij.op().subtract(source1, source2, destination);
```

```
//show result
destinationImagePlus = clij.pull(destination);
destinationImagePlus.show());

// cleanup memory on GPU
source1.close();
source2.close();
destination.close();
```

## subtractImages( ClearCLBuffer subtrahend,  ClearCLBuffer minuend,  ClearCLBuffer destination )

Subtracts one image X from another image Y pixel wise.

<pre>f(x, y) = x - y</pre>

**Parameters**:  ClearCLBuffer subtrahend,  ClearCLBuffer minuend,  ClearCLBuffer destination 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
subtrahend = clij.push(subtrahendImagePlus);
minuend = clij.push(minuendImagePlus);
destination = clij.create(subtrahend);
```

```
// Execute operation on GPU
clij.op().subtractImages(subtrahend, minuend, destination);
```

```
//show result
destinationImagePlus = clij.pull(destination);
destinationImagePlus.show());

// cleanup memory on GPU
subtrahend.close();
minuend.close();
destination.close();
```

## sumPixels( ClearCLBuffer clImage )

Determines the sum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Sum'.

**Parameters**:  ClearCLBuffer clImage 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
```

```
// Execute operation on GPU
resultSumPixels = clij.op().sumPixels(clImage);
```

```
//show result
print(resultSumPixels);

// cleanup memory on GPU
clImage.close();
```

## sumPixelsSliceBySlice( ClearCLBuffer input )

Sums all pixels in X and Y slice by slice and returns the resulting numbers for all slices as an array.

**Parameters**:  ClearCLBuffer input 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input = clij.push(inputImagePlus);
```

```
// Execute operation on GPU
resultSumPixelsSliceBySlice = clij.op().sumPixelsSliceBySlice(input);
```

```
//show result
print(resultSumPixelsSliceBySlice);

// cleanup memory on GPU
input.close();
```

## sumZProjection( ClearCLBuffer clImage,  ClearCLBuffer clReducedImage )

Determines the sum projection of an image along Z.

**Parameters**:  ClearCLBuffer clImage,  ClearCLBuffer clReducedImage 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
clReducedImage = clij.push(clReducedImageImagePlus);
```

```
// Execute operation on GPU
clij.op().sumZProjection(clImage, clReducedImage);
```

```
//show result

// cleanup memory on GPU
clImage.close();
clReducedImage.close();
```

## threshold( ClearCLBuffer src,  ClearCLBuffer dst,  Float threshold )

Computes a binary image with pixel values 0 and 1. All pixel values x of a given input image with 
value larger or equal to a given threshold t will be set to 1.

f(x,t) = (1 if (x >= t); (0 otherwise))

This plugin is comparable to setting a raw threshold in ImageJ and using the 'Convert to Mask' menu.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float threshold 

**Groovy example**: 
```
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
threshold = 1.0;
```

```
// Execute operation on GPU
clij.op().threshold(src, dst, threshold);
```

```
//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
```


Documented 112 methods.
