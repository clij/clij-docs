## absolute( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the absolute value of every individual pixel x in a given image.

f(x) = |x| 

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().absolute(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## addImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar )

Adds a scalar value s to all pixels x of a given image X.

f(x, s) = x + s

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
scalar = 1.0;

// Execute operation on GPU
<b>clij.op().addImageAndScalar(src, dst, scalar);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## addImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Calculates the sum of pairs of pixels x and y of two images X and Y.

f(x, y) = x + y

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().addImages(src, src1, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
</pre>

## addImagesWeighted( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst,  Float factor,  Float factor1 )

Calculates the sum of pairs of pixels x and y from images X and Y weighted with factors a and b.

f(x, y, a, b) = x * a + y * b

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst,  Float factor,  Float factor1 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);
factor = 1.0;
factor1 = 2.0;

// Execute operation on GPU
<b>clij.op().addImagesWeighted(src, src1, dst, factor, factor1);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
</pre>

## affineTransform( ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform3D at )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  AffineTransform3D at 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().affineTransform(src, dst, at);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## affineTransform( ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float[] matrix 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().affineTransform(src, dst, matrix);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## applyVectorfield( ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer dst )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
vectorX = clij.push(vectorXImagePlus);
vectorY = clij.push(vectorYImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().applyVectorfield(src, vectorX, vectorY, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
vectorX.close();
vectorY.close();
dst.close();
</pre>

## applyVectorfield( ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer vectorZ,  ClearCLBuffer dst )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer vectorX,  ClearCLBuffer vectorY,  ClearCLBuffer vectorZ,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
vectorX = clij.push(vectorXImagePlus);
vectorY = clij.push(vectorYImagePlus);
vectorZ = clij.push(vectorZImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().applyVectorfield(src, vectorX, vectorY, vectorZ, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
vectorX.close();
vectorY.close();
vectorZ.close();
dst.close();
</pre>

## argMaximumZProjection( ClearCLBuffer src,  ClearCLBuffer dst_max,  ClearCLBuffer dst_arg )

Determines the maximum projection of an image along Z.
Furthermore, another image is generated containing the z-index where the maximum was found (zero based).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_max,  ClearCLBuffer dst_arg 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_max = clij.create(src);
dst_arg = clij.create(src);

// Execute operation on GPU
<b>clij.op().argMaximumZProjection(src, dst_max, dst_arg);</b>

//show result
dst_maxImagePlus = clij.pull(dst_max);
dst_maxImagePlus.show());
dst_argImagePlus = clij.pull(dst_arg);
dst_argImagePlus.show());

// cleanup memory on GPU
src.close();
dst_max.close();
dst_arg.close();
</pre>

## automaticThreshold( ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod )

The automatic thresholder utilizes the threshold methods from ImageJ on a histogram determined on 
the GPU to create binary images as similar as possible to ImageJ 'Apply Threshold' method. Enter one 
of these methods in the method text field:
[Default, Huang, Intermodes, IsoData, IJ_IsoData, Li, MaxEntropy, Mean, MinError, Minimum, Moments, Otsu, Percentile, RenyiEntropy, Shanbhag, Triangle, Yen]

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().automaticThreshold(src, dst, userSelectedMethod);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## automaticThreshold( ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod,  Float minimumGreyValue,  Float maximumGreyValue,  Integer numberOfBins )

The automatic thresholder utilizes the threshold methods from ImageJ on a histogram determined on 
the GPU to create binary images as similar as possible to ImageJ 'Apply Threshold' method. Enter one 
of these methods in the method text field:
[Default, Huang, Intermodes, IsoData, IJ_IsoData, Li, MaxEntropy, Mean, MinError, Minimum, Moments, Otsu, Percentile, RenyiEntropy, Shanbhag, Triangle, Yen]

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  String userSelectedMethod,  Float minimumGreyValue,  Float maximumGreyValue,  Integer numberOfBins 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
minimumGreyValue = 1.0;
maximumGreyValue = 2.0;
numberOfBins = 10;

// Execute operation on GPU
<b>clij.op().automaticThreshold(src, dst, userSelectedMethod, minimumGreyValue, maximumGreyValue, numberOfBins);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## binaryAnd( ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary AND operator &.
All pixel values except 0 in the input images are interpreted as 1.

f(x, y) = x & y

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
src2 = clij.push(src2ImagePlus);
dst = clij.create(src1);

// Execute operation on GPU
<b>clij.op().binaryAnd(src1, src2, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
src2.close();
dst.close();
</pre>

## binaryNot( ClearCLBuffer src1,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from and image X by negating its pixel values
x using the binary NOT operator !
All pixel values except 0 in the input image are interpreted as 1.

f(x) = !x

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
dst = clij.create(src1);

// Execute operation on GPU
<b>clij.op().binaryNot(src1, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
dst.close();
</pre>

## binaryOr( ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary OR operator |.
All pixel values except 0 in the input images are interpreted as 1.f(x, y) = x | y

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
src2 = clij.push(src2ImagePlus);
dst = clij.create(src1);

// Execute operation on GPU
<b>clij.op().binaryOr(src1, src2, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
src2.close();
dst.close();
</pre>

## binaryXOr( ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst )

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary operators AND &, OR | and NOT !
All pixel values except 0 in the input images are interpreted as 1.

f(x, y) = (x & !y) | (!x & y)

**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer src2,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
src2 = clij.push(src2ImagePlus);
dst = clij.create(src1);

// Execute operation on GPU
<b>clij.op().binaryXOr(src1, src2, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
src2.close();
dst.close();
</pre>

## blur( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Float sigmaX,  Float sigmaY )

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Float sigmaX,  Float sigmaY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
sigmaX = 1.0;
sigmaY = 2.0;

// Execute operation on GPU
<b>clij.op().blur(src, dst, kernelSizeX, kernelSizeY, sigmaX, sigmaY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## blur( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ,  Float sigmaX,  Float sigmaY,  Float sigmaZ )

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ,  Float sigmaX,  Float sigmaY,  Float sigmaZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;
sigmaX = 1.0;
sigmaY = 2.0;
sigmaZ = 3.0;

// Execute operation on GPU
<b>clij.op().blur(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ, sigmaX, sigmaY, sigmaZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## blurFast( ClearCLBuffer src,  ClearCLBuffer dst,  float blurSigmaX,  float blurSigmaY,  float blurSigmaZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float blurSigmaX,  float blurSigmaY,  float blurSigmaZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().blurFast(src, dst, blurSigmaX, blurSigmaY, blurSigmaZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## blurIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Float sigma )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float sigma 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
sigma = 1.0;

// Execute operation on GPU
<b>clij.op().blurIJ(src, dst, sigma);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## blurSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst,  int kernelSizeX,  int kernelSizeY,  float sigmaX,  float sigmaY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int kernelSizeX,  int kernelSizeY,  float sigmaX,  float sigmaY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().blurSliceBySlice(src, dst, kernelSizeX, kernelSizeY, sigmaX, sigmaY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## copy( ClearCLBuffer src,  ClearCLBuffer dst )

Copies an image.

f(x) = x

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().copy(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## copySlice( ClearCLBuffer src,  ClearCLBuffer dst,  Integer planeIndex )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer planeIndex 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
planeIndex = 10;

// Execute operation on GPU
<b>clij.op().copySlice(src, dst, planeIndex);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## countNonZeroPixelsLocally( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().countNonZeroPixelsLocally(src, dst, radiusX, radiusY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## countNonZeroPixelsLocallySliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().countNonZeroPixelsLocallySliceBySlice(src, dst, radiusX, radiusY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## countNonZeroVoxelsLocally( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().countNonZeroVoxelsLocally(src, dst, radiusX, radiusY, radiusZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## crop( ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
startX = 10;
startY = 20;

// Execute operation on GPU
<b>clij.op().crop(src, dst, startX, startY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## crop( ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY,  Integer startZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer startX,  Integer startY,  Integer startZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
startX = 10;
startY = 20;
startZ = 30;

// Execute operation on GPU
<b>clij.op().crop(src, dst, startX, startY, startZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## crossCorrelation( ClearCLBuffer src1,  ClearCLBuffer meanSrc1,  ClearCLBuffer src2,  ClearCLBuffer meanSrc2,  ClearCLBuffer dst,  int radius,  int deltaPos,  int dimension )



**Parameters**:  ClearCLBuffer src1,  ClearCLBuffer meanSrc1,  ClearCLBuffer src2,  ClearCLBuffer meanSrc2,  ClearCLBuffer dst,  int radius,  int deltaPos,  int dimension 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src1 = clij.push(src1ImagePlus);
meanSrc1 = clij.push(meanSrc1ImagePlus);
src2 = clij.push(src2ImagePlus);
meanSrc2 = clij.push(meanSrc2ImagePlus);
dst = clij.create(src1);

// Execute operation on GPU
<b>clij.op().crossCorrelation(src1, meanSrc1, src2, meanSrc2, dst, radius, deltaPos, dimension);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src1.close();
meanSrc1.close();
src2.close();
meanSrc2.close();
dst.close();
</pre>

## detectMaximaBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local maxima in a given square/cubic neighborhood. Pixels in the resulting image are set to 1 if
there is no other pixel in a given radius which has a higher intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().detectMaximaBox(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## detectMaximaSliceBySliceBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local maxima in a given square neighborhood of an input image stack. The input image stack is 
processed slice by slice. Pixels in the resulting image are set to 1 if there is no other pixel in a 
given radius which has a higher intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().detectMaximaSliceBySliceBox(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## detectMinimaBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local minima in a given square/cubic neighborhood. Pixels in the resulting image are set to 1 if
there is no other pixel in a given radius which has a lower intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().detectMinimaBox(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## detectMinimaSliceBySliceBox( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )

Detects local minima in a given square neighborhood of an input image stack. The input image stack is 
processed slice by slice. Pixels in the resulting image are set to 1 if there is no other pixel in a 
given radius which has a lower intensity, and to 0 otherwise.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().detectMinimaSliceBySliceBox(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## detectOptima( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
detectMaxima = true;

// Execute operation on GPU
<b>clij.op().detectOptima(src, dst, radius, detectMaxima);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## detectOptimaSliceBySlice( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius,  Boolean detectMaxima 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;
detectMaxima = true;

// Execute operation on GPU
<b>clij.op().detectOptimaSliceBySlice(src, dst, radius, detectMaxima);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## dilateBox( ClearCLBuffer src,  ClearCLBuffer dst )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().dilateBox(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## dilateSphere( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary dilation of a given input image.
The dilation takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().dilateSphere(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## divideImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Divides two images X and Y by each other pixel wise.

f(x, y) = x / y

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().divideImages(src, src1, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
</pre>

## downsample( ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY )

Scales an image using given scaling factors for X and Y dimensions. The nearest-neighbor method
is applied. In ImageJ the method which is similar is called 'Interpolation method: none'.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
factorX = 1.0;
factorY = 2.0;

// Execute operation on GPU
<b>clij.op().downsample(src, dst, factorX, factorY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## downsample( ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY,  Float factorZ )

Scales an image using given scaling factors for X and Y dimensions. The nearest-neighbor method
is applied. In ImageJ the method which is similar is called 'Interpolation method: none'.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float factorX,  Float factorY,  Float factorZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
factorX = 1.0;
factorY = 2.0;
factorZ = 3.0;

// Execute operation on GPU
<b>clij.op().downsample(src, dst, factorX, factorY, factorZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## downsampleSliceBySliceHalfMedian( ClearCLBuffer src,  ClearCLBuffer dst )

Scales an image using scaling factors 0.5 for X and Y dimensions. The Z dimension stays untouched.
The median method is applied. Thus, each pixel value in the destination image equals to the median of
four corresponding pixels in the source image.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().downsampleSliceBySliceHalfMedian(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## erodeBox( ClearCLBuffer src,  ClearCLBuffer dst )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().erodeBox(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## erodeSphere( ClearCLBuffer src,  ClearCLBuffer dst )

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().erodeSphere(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## fillHistogram( ClearCLBuffer src,  ClearCLBuffer dstHistogram,  Float minimumGreyValue,  Float maximumGreyValue )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dstHistogram,  Float minimumGreyValue,  Float maximumGreyValue 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dstHistogram = clij.create(src);
minimumGreyValue = 1.0;
maximumGreyValue = 2.0;

// Execute operation on GPU
<b>clij.op().fillHistogram(src, dstHistogram, minimumGreyValue, maximumGreyValue);</b>

//show result
dstHistogramImagePlus = clij.pull(dstHistogram);
dstHistogramImagePlus.show());

// cleanup memory on GPU
src.close();
dstHistogram.close();
</pre>

## flip( ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy )

Flips an image in X and/or Y direction depending on boolean flags.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
flipx = true;
flipy = false;

// Execute operation on GPU
<b>clij.op().flip(src, dst, flipx, flipy);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## flip( ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy,  Boolean flipz )

Flips an image in X and/or Y direction depending on boolean flags.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Boolean flipx,  Boolean flipy,  Boolean flipz 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
flipx = true;
flipy = false;
flipz = false;

// Execute operation on GPU
<b>clij.op().flip(src, dst, flipx, flipy, flipz);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## gradientX( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the gradient of gray values along X. Assuming a, b and c are three adjacent
 pixels in X direction. In the target image will be saved as: b = c - a;

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().gradientX(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## gradientY( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the gradient of gray values along Y. Assuming a, b and c are three adjacent
 pixels in Y direction. In the target image will be saved as: b = c - a;

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().gradientY(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## gradientZ( ClearCLBuffer src,  ClearCLBuffer dst )

Computes the gradient of gray values along Z. Assuming a, b and c are three adjacent
 pixels in Z direction. In the target image will be saved as: b = c - a;

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().gradientZ(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## histogram( ClearCLBuffer image,  Float minGreyValue,  Float maxGreyValue,  int numberOfBins )

Determines the histogram of a given image.

**Parameters**:  ClearCLBuffer image,  Float minGreyValue,  Float maxGreyValue,  int numberOfBins 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
image = clij.push(imageImagePlus);
minGreyValue = 1.0;
maxGreyValue = 2.0;

// Execute operation on GPU
resultHistogram = <b>clij.op().histogram(image, minGreyValue, maxGreyValue, numberOfBins);</b>

//show result
print(resultHistogram);

// cleanup memory on GPU
image.close();
</pre>

## invert( ClearCLBuffer input3d,  ClearCLBuffer output3d )

Computes the negative value of all pixels in a given image. It is recommended to convert images to 
32-bit float before applying this operation.

f(x) = - x

For binary images, use binaryNot.

**Parameters**:  ClearCLBuffer input3d,  ClearCLBuffer output3d 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input3d = clij.push(input3dImagePlus);
output3d = clij.create(input3d);

// Execute operation on GPU
<b>clij.op().invert(input3d, output3d);</b>

//show result
output3dImagePlus = clij.pull(output3d);
output3dImagePlus.show());

// cleanup memory on GPU
input3d.close();
output3d.close();
</pre>

## localThreshold( ClearCLBuffer src,  ClearCLBuffer dst,  ClearCLBuffer threshold )

Computes a binary image with pixel values 0 and 1 depending on if a pixel value x in image X 
was above of equal to the pixel value m in mask image M.

f(x) = (1 if (x >=  m)); (0 otherwise)

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  ClearCLBuffer threshold 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
threshold = clij.push(thresholdImagePlus);

// Execute operation on GPU
<b>clij.op().localThreshold(src, dst, threshold);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
threshold.close();
</pre>

## mask( ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst )

Computes a masked image by applying a mask to an image. All pixel values x of image X will be copied
to the destination image in case pixel value m at the same position in the mask image is not equal to 
zero.

f(x,m) = (x if (m != 0); (0 otherwise))

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
mask = clij.push(maskImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().mask(src, mask, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
mask.close();
dst.close();
</pre>

## maskStackWithPlane( ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst )

Computes a masked image by applying a 2D mask to an image stack. All pixel values x of image X will be copied
to the destination image in case pixel value m at the same spatial position in the mask image is not equal to 
zero.

f(x,m) = (x if (m != 0); (0 otherwise))

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer mask,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
mask = clij.push(maskImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().maskStackWithPlane(src, mask, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
mask.close();
dst.close();
</pre>

## maximumBox( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().maximumBox(src, dst, radiusX, radiusY, radiusZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## maximumIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().maximumIJ(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## maximumImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB )

Computes the maximum of a constant scalar s and each pixel value x in a given image X.

f(x, s) = max(x, s)

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
valueB = 1.0;

// Execute operation on GPU
<b>clij.op().maximumImageAndScalar(src, dst, valueB);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## maximumImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Computes the maximum of a pair of pixel values x, y from two given images X and Y.

f(x, s) = max(x, y)

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().maximumImages(src, src1, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
</pre>

## maximumOfAllPixels( ClearCLBuffer clImage )

Determines the maximum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Max'.

**Parameters**:  ClearCLBuffer clImage 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);

// Execute operation on GPU
resultMaximumOfAllPixels = <b>clij.op().maximumOfAllPixels(clImage);</b>

//show result
print(resultMaximumOfAllPixels);

// cleanup memory on GPU
clImage.close();
</pre>

## maximumSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local maximum of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().maximumSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## maximumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().maximumSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## maximumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;

// Execute operation on GPU
<b>clij.op().maximumSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## maximumXYZProjection( ClearCLBuffer src,  ClearCLBuffer dst_max,  Integer projectedDimensionX,  Integer projectedDimensionY,  Integer projectedDimension )

Determines the maximum projection of an image along a given dimension. Furthermore, the X and Y
 dimesions of the resulting image must be specified by the user according to its definition:
X = 0
Y = 1
Z = 2


**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_max,  Integer projectedDimensionX,  Integer projectedDimensionY,  Integer projectedDimension 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_max = clij.create(src);
projectedDimensionX = 10;
projectedDimensionY = 20;
projectedDimension = 30;

// Execute operation on GPU
<b>clij.op().maximumXYZProjection(src, dst_max, projectedDimensionX, projectedDimensionY, projectedDimension);</b>

//show result
dst_maxImagePlus = clij.pull(dst_max);
dst_maxImagePlus.show());

// cleanup memory on GPU
src.close();
dst_max.close();
</pre>

## maximumZProjection( ClearCLBuffer src,  ClearCLBuffer dst_max )

Determines the maximum projection of an image along Z.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_max 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_max = clij.create(src);

// Execute operation on GPU
<b>clij.op().maximumZProjection(src, dst_max);</b>

//show result
dst_maxImagePlus = clij.pull(dst_max);
dst_maxImagePlus.show());

// cleanup memory on GPU
src.close();
dst_max.close();
</pre>

## meanBox( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().meanBox(src, dst, radiusX, radiusY, radiusZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## meanIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().meanIJ(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## meanSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local mean average of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().meanSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## meanSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().meanSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## meanSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;

// Execute operation on GPU
<b>clij.op().meanSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## meanZProjection( ClearCLBuffer src,  ClearCLBuffer dst )

Determines the mean average projection of an image along Z.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().meanZProjection(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## medianSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local median of a pixels ellipsoidal neighborhood. This is done slice-by-slice in a 3D 
image stack. The ellipses size is specified by its half-width and half-height (radius).

For technical reasons, the area of the ellipse must have less than 1000 pixels.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().medianSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## medianSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().medianSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## medianSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;

// Execute operation on GPU
<b>clij.op().medianSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumBox( ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  int radiusX,  int radiusY,  int radiusZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().minimumBox(src, dst, radiusX, radiusY, radiusZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumIJ( ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer radius 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
radius = 10;

// Execute operation on GPU
<b>clij.op().minimumIJ(src, dst, radius);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB )

Computes the maximum of a constant scalar s and each pixel value x in a given image X.

f(x, s) = min(x, s)

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float valueB 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
valueB = 1.0;

// Execute operation on GPU
<b>clij.op().minimumImageAndScalar(src, dst, valueB);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Computes the minimum of a pair of pixel values x, y from two given images X and Y.

f(x, s) = min(x, y)

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().minimumImages(src, src1, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
</pre>

## minimumOfAllPixels( ClearCLBuffer clImage )

Determines the minimum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Min'.

**Parameters**:  ClearCLBuffer clImage 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);

// Execute operation on GPU
resultMinimumOfAllPixels = <b>clij.op().minimumOfAllPixels(clImage);</b>

//show result
print(resultMinimumOfAllPixels);

// cleanup memory on GPU
clImage.close();
</pre>

## minimumSliceBySliceSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )

Computes the local minimum of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().minimumSliceBySliceSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;

// Execute operation on GPU
<b>clij.op().minimumSphere(src, dst, kernelSizeX, kernelSizeY);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumSphere( ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer kernelSizeX,  Integer kernelSizeY,  Integer kernelSizeZ 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
kernelSizeX = 10;
kernelSizeY = 20;
kernelSizeZ = 30;

// Execute operation on GPU
<b>clij.op().minimumSphere(src, dst, kernelSizeX, kernelSizeY, kernelSizeZ);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## minimumZProjection( ClearCLBuffer src,  ClearCLBuffer dst_min )

Determines the minimum projection of an image along Z.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst_min 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst_min = clij.create(src);

// Execute operation on GPU
<b>clij.op().minimumZProjection(src, dst_min);</b>

//show result
dst_minImagePlus = clij.pull(dst_min);
dst_minImagePlus.show());

// cleanup memory on GPU
src.close();
dst_min.close();
</pre>

## multiplyImageAndCoordinate( ClearCLBuffer src,  ClearCLBuffer dst,  Integer dimension )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Integer dimension 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
dimension = 10;

// Execute operation on GPU
<b>clij.op().multiplyImageAndCoordinate(src, dst, dimension);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## multiplyImageAndScalar( ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar )

Multiplies all pixels value x in a given image X with a constant scalar s.

f(x, s) = x * s

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float scalar 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
scalar = 1.0;

// Execute operation on GPU
<b>clij.op().multiplyImageAndScalar(src, dst, scalar);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## multiplyImages( ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst )

Multiplies all pairs of pixel values x and y from two image X and Y.

f(x, y) = x * y

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer src1,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
src1 = clij.push(src1ImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().multiplyImages(src, src1, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
src1.close();
dst.close();
</pre>

## multiplySliceBySliceWithScalars( ClearCLBuffer src,  ClearCLBuffer dst,  float[] scalars )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  float[] scalars 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().multiplySliceBySliceWithScalars(src, dst, scalars);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## multiplyStackWithPlane( ClearCLBuffer input3d,  ClearCLBuffer input2d,  ClearCLBuffer output3d )

Multiplies all pairs of pixel values x and y from an image stack X and a 2D image Y. x and y are at 
the same spatial position within a plane.

f(x, y) = x * y

**Parameters**:  ClearCLBuffer input3d,  ClearCLBuffer input2d,  ClearCLBuffer output3d 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input3d = clij.push(input3dImagePlus);
input2d = clij.push(input2dImagePlus);
output3d = clij.create(input3d);

// Execute operation on GPU
<b>clij.op().multiplyStackWithPlane(input3d, input2d, output3d);</b>

//show result
output3dImagePlus = clij.pull(output3d);
output3dImagePlus.show());

// cleanup memory on GPU
input3d.close();
input2d.close();
output3d.close();
</pre>

## particleImageVelocimetry2D( ClearCLBuffer input1,  ClearCLBuffer input2,  ClearCLBuffer vfX,  ClearCLBuffer vfY,  int maxDelta  )



**Parameters**:  ClearCLBuffer input1,  ClearCLBuffer input2,  ClearCLBuffer vfX,  ClearCLBuffer vfY,  int maxDelta  

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input1 = clij.push(input1ImagePlus);
input2 = clij.push(input2ImagePlus);
vfX = clij.push(vfXImagePlus);
vfY = clij.push(vfYImagePlus);

// Execute operation on GPU
<b>clij.op().particleImageVelocimetry2D(input1, input2, vfX, vfY, maxDelta);</b>

//show result

// cleanup memory on GPU
input1.close();
input2.close();
vfX.close();
vfY.close();
</pre>

## power( ClearCLBuffer src,  ClearCLBuffer dst,  Float exponent )

Computes all pixels value x to the power of a given exponent a.

f(x, a) = x * a

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float exponent 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
exponent = 1.0;

// Execute operation on GPU
<b>clij.op().power(src, dst, exponent);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## radialProjection( ClearCLBuffer src,  ClearCLBuffer dst,  Float deltaAngle )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float deltaAngle 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
deltaAngle = 1.0;

// Execute operation on GPU
<b>clij.op().radialProjection(src, dst, deltaAngle);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## resliceBottom( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method but
offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().resliceBottom(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## resliceLeft( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes X, Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method 
 but offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().resliceLeft(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## resliceRight( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes X, Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method 
 but offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().resliceRight(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## resliceTop( ClearCLBuffer src,  ClearCLBuffer dst )

Flippes Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method but
offers less flexibility such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().resliceTop(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## rotateLeft( ClearCLBuffer src,  ClearCLBuffer dst )

Rotates a given input image by 90 degrees counter-clockwise. For that, X and Y axis of an image stack
are flipped. This operation is similar to ImageJs 'Reslice [/]' method but offers less flexibility 
such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().rotateLeft(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## rotateRight( ClearCLBuffer src,  ClearCLBuffer dst )

Rotates a given input image by 90 degrees clockwise. For that, X and Y axis of an image stack
are flipped. This operation is similar to ImageJs 'Reslice [/]' method but offers less flexibility 
such as interpolation.

**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);

// Execute operation on GPU
<b>clij.op().rotateRight(src, dst);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>

## set( ClearCLBuffer clImage,  Float value )

Sets all pixel values x of a given image X to a constant value v.

f(x) = v

**Parameters**:  ClearCLBuffer clImage,  Float value 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
value = 1.0;

// Execute operation on GPU
<b>clij.op().set(clImage, value);</b>

//show result

// cleanup memory on GPU
clImage.close();
</pre>

## splitStack( ClearCLBuffer clImageIn,  ClearCLBuffer... clImagesOut )



**Parameters**:  ClearCLBuffer clImageIn,  ClearCLBuffer... clImagesOut 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImageIn = clij.push(clImageInImagePlus);
clImagesOut = clij.push(clImagesOutImagePlus);

// Execute operation on GPU
<b>clij.op().splitStack(clImageIn, clImagesOut);</b>

//show result

// cleanup memory on GPU
clImageIn.close();
clImagesOut.close();
</pre>

## subtract( ClearCLBuffer source1,  ClearCLBuffer source2,  ClearCLBuffer destination )



**Parameters**:  ClearCLBuffer source1,  ClearCLBuffer source2,  ClearCLBuffer destination 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
source1 = clij.push(source1ImagePlus);
source2 = clij.push(source2ImagePlus);
destination = clij.create(source1);

// Execute operation on GPU
<b>clij.op().subtract(source1, source2, destination);</b>

//show result
destinationImagePlus = clij.pull(destination);
destinationImagePlus.show());

// cleanup memory on GPU
source1.close();
source2.close();
destination.close();
</pre>

## subtractImages( ClearCLBuffer subtrahend,  ClearCLBuffer minuend,  ClearCLBuffer destination )

Subtracts one image X from another image Y pixel wise.

f(x, y) = x - y

**Parameters**:  ClearCLBuffer subtrahend,  ClearCLBuffer minuend,  ClearCLBuffer destination 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
subtrahend = clij.push(subtrahendImagePlus);
minuend = clij.push(minuendImagePlus);
destination = clij.create(subtrahend);

// Execute operation on GPU
<b>clij.op().subtractImages(subtrahend, minuend, destination);</b>

//show result
destinationImagePlus = clij.pull(destination);
destinationImagePlus.show());

// cleanup memory on GPU
subtrahend.close();
minuend.close();
destination.close();
</pre>

## sumPixels( ClearCLBuffer clImage )



**Parameters**:  ClearCLBuffer clImage 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);

// Execute operation on GPU
resultSumPixels = <b>clij.op().sumPixels(clImage);</b>

//show result
print(resultSumPixels);

// cleanup memory on GPU
clImage.close();
</pre>

## sumPixelsSliceBySlice( ClearCLBuffer input )



**Parameters**:  ClearCLBuffer input 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
input = clij.push(inputImagePlus);

// Execute operation on GPU
resultSumPixelsSliceBySlice = <b>clij.op().sumPixelsSliceBySlice(input);</b>

//show result
print(resultSumPixelsSliceBySlice);

// cleanup memory on GPU
input.close();
</pre>

## sumZProjection( ClearCLBuffer clImage,  ClearCLBuffer clReducedImage )

Determines the sum projection of an image along Z.

**Parameters**:  ClearCLBuffer clImage,  ClearCLBuffer clReducedImage 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
clImage = clij.push(clImageImagePlus);
clReducedImage = clij.push(clReducedImageImagePlus);

// Execute operation on GPU
<b>clij.op().sumZProjection(clImage, clReducedImage);</b>

//show result

// cleanup memory on GPU
clImage.close();
clReducedImage.close();
</pre>

## threshold( ClearCLBuffer src,  ClearCLBuffer dst,  Float threshold )



**Parameters**:  ClearCLBuffer src,  ClearCLBuffer dst,  Float threshold 

**Groovy example**: 
<pre>
// init CLIJ and GPU
import net.haesleinhuepf.clij.CLIJ;
clij = CLIJ.getInstance();

// get input parameters
src = clij.push(srcImagePlus);
dst = clij.create(src);
threshold = 1.0;

// Execute operation on GPU
<b>clij.op().threshold(src, dst, threshold);</b>

//show result
dstImagePlus = clij.pull(dst);
dstImagePlus.show());

// cleanup memory on GPU
src.close();
dst.close();
</pre>


Documented 103 methods.
