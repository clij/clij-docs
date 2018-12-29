# CLIJ reference

## CLIJ_absolute

Computes the absolute value of every individual pixel x in a given image.

f(x) = |x| 

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_absolute(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Absolute.java)

## CLIJ_addImageAndScalar

Adds a scalar value s to all pixels x of a given image X.

f(x, s) = x + s

**Parameters**: Image source, Image destination, Number scalar

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_addImageAndScalar(source, destination, scalar);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/AddImageAndScalar.java)

## CLIJ_addImages

Calculates the sum of pairs of pixels x and y of two images X and Y.

f(x, y) = x + y

**Parameters**: Image summand1, Image summand2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(summand1);
Ext.CLIJ_push(summand2);
Ext.CLIJ_addImages(summand1, summand2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/AddImages.java)

## CLIJ_addImagesWeighted

Calculates the sum of pairs of pixels x and y from images X and Y weighted with factors a and b.

f(x, y, a, b) = x * a + y * b

**Parameters**: Image summand1, Image summand2, Image destination, Number factor1, Number factor2

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(summand1);
Ext.CLIJ_push(summand2);
Ext.CLIJ_addImagesWeighted(summand1, summand2, destination, factor1, factor2);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/AddImagesWeighted.java)

## CLIJ_argMaximumZProjection

Determines the maximum projection of an image along Z.
Furthermore, another image is generated containing the z-index where the maximum was found (zero based).

**Parameters**: Image source, Image destination_max, Image destination_arg_max

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_argMaximumZProjection(source, destination_max, destination_arg_max);
Ext.CLIJ_pull(destination_max);
Ext.CLIJ_pull(destination_arg_max);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ArgMaximumZProjection.java)

## CLIJ_binaryAnd

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary AND operator &.
All pixel values except 0 in the input images are interpreted as 1.

f(x, y) = x & y

**Parameters**: Image operand1, Image operand2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(operand1);
Ext.CLIJ_push(operand2);
Ext.CLIJ_binaryAnd(operand1, operand2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/BinaryAnd.java)

## CLIJ_binaryNot

Computes a binary image (containing pixel values 0 and 1) from and image X by negating its pixel values
x using the binary NOT operator !
All pixel values except 0 in the input image are interpreted as 1.

f(x) = !x

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_binaryNot(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/BinaryNot.java)

## CLIJ_binaryOr

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary OR operator |.
All pixel values except 0 in the input images are interpreted as 1.f(x, y) = x | y

**Parameters**: Image operand1, Image operand2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(operand1);
Ext.CLIJ_push(operand2);
Ext.CLIJ_binaryOr(operand1, operand2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/BinaryOr.java)

## CLIJ_binaryXOr

Computes a binary image (containing pixel values 0 and 1) from two images X and Y by connecting pairs of
pixels x and y with the binary operators AND &, OR | and NOT !
All pixel values except 0 in the input images are interpreted as 1.

f(x, y) = (x & !y) | (!x & y)

**Parameters**: Image operand1, Image operand2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(operand1);
Ext.CLIJ_push(operand2);
Ext.CLIJ_binaryXOr(operand1, operand2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/BinaryXOr.java)

## CLIJ_blur2D

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

**Parameters**: Image source, Image destination, Number sigmaX, Number sigmaY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_blur2D(source, destination, sigmaX, sigmaY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Blur2D.java)

## CLIJ_blur2DFast

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

The 'fast' implementation is done separable. In case a sigma equals zero, the direction is not blurred.

**Parameters**: Image source, Image destination, Number sigmaX, Number sigmaY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_blur2DFast(source, destination, sigmaX, sigmaY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Blur2DFast.java)

## CLIJ_blur2DIJ

Computes the Gaussian blurred image of an image given a sigma.

The implementation is close to ImageJs Gaussian blur filter. Differences in pixel values compared to 
ImageJ of up to 0.5% need to be tolerated.

**Parameters**: Image source, Image destination, Number sigma

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_blur2DIJ(source, destination, sigma);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Blur2DIJ.java)

## CLIJ_blur3D

Computes the Gaussian blurred image of an image given two sigma values in X, Y and Z. Thus, the filterkernel can have non-isotropic shape.

**Parameters**: Image source, Image destination, Number sigmaX, Number sigmaY, Number sigmaZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_blur3D(source, destination, sigmaX, sigmaY, sigmaZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Blur3D.java)

## CLIJ_blur3DFast

Computes the Gaussian blurred image of an image given two sigma values in X, Y and Z. Thus, the filterkernel can have non-isotropic shape.

The 'fast' implementation is done separable. In case a sigma equals zero, the direction is not blurred.

**Parameters**: Image source, Image destination, Number sigmaX, Number sigmaY, Number sigmaZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_blur3DFast(source, destination, sigmaX, sigmaY, sigmaZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Blur3DFast.java)

## CLIJ_blur3DSliceBySlice

Computes the Gaussian blurred image of an image given two sigma values in X and Y. Thus, the filterkernel can have non-isotropic shape.

The Gaussian blur is applied slice by slice in 2D.

**Parameters**: Image source, Image destination, Number sigmaX, Number sigmaY

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_blur3DSliceBySlice(source, destination, sigmaX, sigmaY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Blur3DSliceBySlice.java)

## CLIJ_clear

Resets the GPUs memory by deleting all cached images.

**Parameters**: 

**Available for**: 

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_clear();
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Clear.java)

## CLIJ_copy

Copies an image.

f(x) = x

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_copy(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Copy.java)

## CLIJ_copySlice

This method has two purposes: 
It copies a 2D image to a given slice z position in a 3D image stack or 
It copies a given slice at position z in an image stack to a 2D image.

The first case is only available via ImageJ macro. If you are using it, it is recommended that the 
target 3D image already pre-exists in GPU memory before calling this method. Otherwise, CLIJ create 
the image stack with z planes.

**Parameters**: Image source, Image destination, Number sliceIndex

**Available for**: 3D -> 2D and 2D -> 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_copySlice(source, destination, sliceIndex);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/CopySlice.java)

## CLIJ_crop2D

Crops a given rectangle out of a given image stack.

Note: If the destination image pre-exists already, it will be overwritten and keep it's dimensions.

**Parameters**: Image source, Image destination, Number startX, Number startY, Number width, Number height

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_crop2D(source, destination, startX, startY, width, height);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Crop2D.java)

## CLIJ_crop3D

Crops a given sub-stack out of a given image stack.

Note: If the destination image pre-exists already, it will be overwritten and keep it's dimensions.

**Parameters**: Image source, Image destination, Number startX, Number startY, Number startZ, Number width, Number height, Number depth

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_crop3D(source, destination, startX, startY, startZ, width, height, depth);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Crop3D.java)

## CLIJ_detectMaximaBox

Detects local maxima in a given square/cubic neighborhood. Pixels in the resulting image are set to 1 if
there is no other pixel in a given radius which has a higher intensity, and to 0 otherwise.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_detectMaximaBox(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DetectMaximaBox.java)

## CLIJ_detectMaximaSliceBySliceBox

Detects local maxima in a given square neighborhood of an input image stack. The input image stack is 
processed slice by slice. Pixels in the resulting image are set to 1 if there is no other pixel in a 
given radius which has a higher intensity, and to 0 otherwise.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_detectMaximaSliceBySliceBox(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DetectMaximaSliceBySliceBox.java)

## CLIJ_detectMinimaBox

Detects local minima in a given square/cubic neighborhood. Pixels in the resulting image are set to 1 if
there is no other pixel in a given radius which has a lower intensity, and to 0 otherwise.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_detectMinimaBox(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DetectMinimaBox.java)

## CLIJ_detectMinimaSliceBySliceBox

Detects local minima in a given square neighborhood of an input image stack. The input image stack is 
processed slice by slice. Pixels in the resulting image are set to 1 if there is no other pixel in a 
given radius which has a lower intensity, and to 0 otherwise.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_detectMinimaSliceBySliceBox(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DetectMinimaSliceBySliceBox.java)

## CLIJ_dilateSphere

Computes a binary image with pixel values 0 and 1 containing the binary dilation of a given input image.
The dilation takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_dilateSphere(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DilateSphere.java)

## CLIJ_divideImages

Divides two images X and Y by each other pixel wise.

f(x, y) = x / y

**Parameters**: Image divident, Image divisor, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(divident);
Ext.CLIJ_push(divisor);
Ext.CLIJ_divideImages(divident, divisor, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DivideImages.java)

## CLIJ_downsample2D

Scales an image using given scaling factors for X and Y dimensions. The nearest-neighbor method
is applied. In ImageJ the method which is similar is called 'Interpolation method: none'.

**Parameters**: Image source, Image destination, Number factorX, Number factorY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_downsample2D(source, destination, factorX, factorY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Downsample2D.java)

## CLIJ_downsample3D

Scales an image using given scaling factors for X and Y dimensions. The nearest-neighbor method
is applied. In ImageJ the method which is similar is called 'Interpolation method: none'.

**Parameters**: Image source, Image destination, Number factorX, Number factorY, Number factorZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_downsample3D(source, destination, factorX, factorY, factorZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Downsample3D.java)

## CLIJ_downsampleSliceBySliceHalfMedian

Scales an image using scaling factors 0.5 for X and Y dimensions. The Z dimension stays untouched.
The median method is applied. Thus, each pixel value in the destination image equals to the median of
four corresponding pixels in the source image.

**Parameters**: Image source, Image destination

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_downsampleSliceBySliceHalfMedian(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/DownsampleSliceBySliceHalfMedian.java)

## CLIJ_erodeBoxIJ

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the Moore-neighborhood (8 pixels in 2D and 26 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

This method is comparable to the 'Erode' menu in ImageJ in case it is applied to a 2D image. The only
difference is that the output image contains values 0 and 1 instead of 0 and 255.

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_erodeBoxIJ(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ErodeBoxIJ.java)

## CLIJ_erodeSphere

Computes a binary image with pixel values 0 and 1 containing the binary erosion of a given input image.
The erosion takes the von-Neumann-neighborhood (4 pixels in 2D and 6 pixels in 3d) into account.
The pixels in the input image with pixel value not equal to 0 will be interpreted as 1.

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_erodeSphere(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ErodeSphere.java)

## CLIJ_flip2D

Flips an image in X and/or Y direction depending on boolean flags.

**Parameters**: Image source, Image destination, Boolean flipX, Boolean flipY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_flip2D(source, destination, flipX, flipY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Flip2D.java)

## CLIJ_flip3D

Flips an image in X, Y and/or Z direction depending on boolean flags.

**Parameters**: Image source, Image destination, Boolean flipX, Boolean flipY, Boolean flipZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_flip3D(source, destination, flipX, flipY, flipZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Flip3D.java)

## CLIJ_help

Searches in the list of CLIJ commands for a given pattern. Lists all commands in case"" is handed
over as parameter.

**Parameters**: String searchFor

**Available for**: -

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_help(searchFor);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Help.java)

## CLIJ_invert

Computes the negative value of all pixels in a given image. It is recommended to convert images to 
32-bit float before applying this operation.

f(x) = - x

For binary images, use binaryNot.

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_invert(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Invert.java)

## CLIJ_localThreshold

Computes a binary image with pixel values 0 and 1 depending on if a pixel value x in image X 
was above of equal to the pixel value m in mask image M.

f(x) = (1 if (x >=  m)); (0 otherwise)

**Parameters**: Image source, Image localThreshold, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_push(localThreshold);
Ext.CLIJ_localThreshold(source, localThreshold, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/LocalThreshold.java)

## CLIJ_mask

Computes a masked image by applying a mask to an image. All pixel values x of image X will be copied
to the destination image in case pixel value m at the same position in the mask image is not equal to 
zero.

f(x,m) = (x if (m != 0); (0 otherwise))

**Parameters**: Image source, Image mask, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_push(mask);
Ext.CLIJ_mask(source, mask, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Mask.java)

## CLIJ_maskStackWithPlane

Computes a masked image by applying a 2D mask to an image stack. All pixel values x of image X will be copied
to the destination image in case pixel value m at the same spatial position in the mask image is not equal to 
zero.

f(x,m) = (x if (m != 0); (0 otherwise))

**Parameters**: Image source, Image mask, Image destination

**Available for**: 3D (first parameter), 2D (second parameter), 3D (result)

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_push(mask);
Ext.CLIJ_maskStackWithPlane(source, mask, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaskStackWithPlane.java)

## CLIJ_maximum2DBox

Computes the local maximum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximum2DBox(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Maximum2DBox.java)

## CLIJ_maximum2DIJ

Computes the local maximum of a pixels circle-like neighborhood. The circle size is specified by 
its radius.

This operation is equal to ImageJs 'Maximum...' menu.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximum2DIJ(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Maximum2DIJ.java)

## CLIJ_maximum2DSphere

Computes the local maximum of a pixels ellipsoidal neighborhood. The ellipses size is specified by 
its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximum2DSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Maximum2DSphere.java)

## CLIJ_maximum3DBox

Computes the local maximum of a pixels cube neighborhood. The cubes size is specified by 
its half-width, half-height and half-depth (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY, Number radiusZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximum3DBox(source, destination, radiusX, radiusY, radiusZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Maximum3DBox.java)

## CLIJ_maximum3DSphere

Computes the local maximum of a pixels spherical neighborhood. The spheres size is specified by 
its half-width, half-height and half-depth (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY, Number radiusZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximum3DSphere(source, destination, radiusX, radiusY, radiusZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Maximum3DSphere.java)

## CLIJ_maximumImageAndScalar

Computes the maximum of a constant scalar s and each pixel value x in a given image X.

f(x, s) = max(x, s)

**Parameters**: Image source, Image destination, Number scalar

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximumImageAndScalar(source, destination, scalar);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaximumImageAndScalar.java)

## CLIJ_maximumImages

Computes the maximum of a pair of pixel values x, y from two given images X and Y.

f(x, s) = max(x, y)

**Parameters**: Image source1, Image source2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source1);
Ext.CLIJ_push(source2);
Ext.CLIJ_maximumImages(source1, source2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaximumImages.java)

## CLIJ_maximumOfAllPixels

Determines the maximum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Max'.

**Parameters**: Image source

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximumOfAllPixels(source);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaximumOfAllPixels.java)

## CLIJ_maximumSliceBySliceSphere

Computes the local maximum of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximumSliceBySliceSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaximumSliceBySliceSphere.java)

## CLIJ_maximumXYZProjection

Determines the maximum projection of an image along a given dimension. Furthermore, the X and Y
 dimesions of the resulting image must be specified by the user according to its definition:
X = 0
Y = 1
Z = 2


**Parameters**: Image source, Image destination_max, Number dimensionX, Number dimensionY, Number projectedDimension

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximumXYZProjection(source, destination_max, dimensionX, dimensionY, projectedDimension);
Ext.CLIJ_pull(destination_max);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaximumXYZProjection.java)

## CLIJ_maximumZProjection

Determines the maximum projection of an image along Z.

**Parameters**: Image source, Image destination_max

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_maximumZProjection(source, destination_max);
Ext.CLIJ_pull(destination_max);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MaximumZProjection.java)

## CLIJ_mean2DBox

Computes the local mean average of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_mean2DBox(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Mean2DBox.java)

## CLIJ_mean2DIJ

Computes the local mean average of a pixels circle-like neighborhood. The circle size is specified by 
its radius.

This operation is equal to ImageJs 'Mean...' menu.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_mean2DIJ(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Mean2DIJ.java)

## CLIJ_mean2DSphere

Computes the local mean average of a pixels ellipsoidal neighborhood. The ellipses size is specified by 
its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_mean2DSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Mean2DSphere.java)

## CLIJ_mean3DBox

Computes the local mean average of a pixels cube neighborhood. The cubes size is specified by 
its half-width, half-height and half-depth (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY, Number radiusZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_mean3DBox(source, destination, radiusX, radiusY, radiusZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Mean3DBox.java)

## CLIJ_mean3DSphere

Computes the local mean average of a pixels spherical neighborhood. The spheres size is specified by 
its half-width, half-height and half-depth (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY, Number radiusZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_mean3DSphere(source, destination, radiusX, radiusY, radiusZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Mean3DSphere.java)

## CLIJ_meanOfAllPixels

Determines the mean average of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Mean'.

**Parameters**: Image source

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_meanOfAllPixels(source);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MeanOfAllPixels.java)

## CLIJ_meanSliceBySliceSphere

Computes the local mean average of a pixels ellipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_meanSliceBySliceSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MeanSliceBySliceSphere.java)

## CLIJ_meanZProjection

Determines the mean average projection of an image along Z.

**Parameters**: Image source, Image destination

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_meanZProjection(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MeanZProjection.java)

## CLIJ_median2DSphere

Computes the local median of a pixels ellipsoidal neighborhood. The ellipses size is specified by 
its half-width and half-height (radius).

For technical reasons, the area of the ellipse must have less than 1000 pixels.

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_median2DSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Median2DSphere.java)

## CLIJ_median3DSphere

Computes the local median of a pixels spherical neighborhood. The spheres size is specified by 
its half-width, half-height and half-depth (radius).

For technical reasons, the volume of the sphere must contain less than 1000 voxels.

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_median3DSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Median3DSphere.java)

## CLIJ_medianSliceBySliceSphere

Computes the local median of a pixels ellipsoidal neighborhood. This is done slice-by-slice in a 3D 
image stack. The ellipses size is specified by its half-width and half-height (radius).

For technical reasons, the area of the ellipse must have less than 1000 pixels.

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_medianSliceBySliceSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MedianSliceBySliceSphere.java)

## CLIJ_minimum2DBox

Computes the local minimum of a pixels rectangular neighborhood. The rectangles size is specified by 
its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimum2DBox(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Minimum2DBox.java)

## CLIJ_minimum2DIJ

Computes the local minimum of a pixels circle-like neighborhood. The circle size is specified by 
its radius.

This operation is equal to ImageJs 'Minimum...' menu.

**Parameters**: Image source, Image destination, Number radius

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimum2DIJ(source, destination, radius);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Minimum2DIJ.java)

## CLIJ_minimum2DSphere

Computes the local minimum of a pixels ellipsoidal neighborhood. The ellipses size is specified by 
its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 2D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimum2DSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Minimum2DSphere.java)

## CLIJ_minimum3DBox

Computes the local minimum of a pixels cube neighborhood. The cubes size is specified by 
its half-width, half-height and half-depth (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY, Number radiusZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimum3DBox(source, destination, radiusX, radiusY, radiusZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Minimum3DBox.java)

## CLIJ_minimum3DSphere

Computes the local minimum of a pixels spherical neighborhood. The spheres size is specified by 
its half-width, half-height and half-depth (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY, Number radiusZ

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimum3DSphere(source, destination, radiusX, radiusY, radiusZ);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Minimum3DSphere.java)

## CLIJ_minimumImageAndScalar

Computes the maximum of a constant scalar s and each pixel value x in a given image X.

f(x, s) = min(x, s)

**Parameters**: Image source, Image destination, Number scalar

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimumImageAndScalar(source, destination, scalar);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MinimumImageAndScalar.java)

## CLIJ_minimumImages

Computes the minimum of a pair of pixel values x, y from two given images X and Y.

f(x, s) = min(x, y)

**Parameters**: Image source1, Image source2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source1);
Ext.CLIJ_push(source2);
Ext.CLIJ_minimumImages(source1, source2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MinimumImages.java)

## CLIJ_minimumOfAllPixels

Determines the minimum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Min'.

**Parameters**: Image source

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimumOfAllPixels(source);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MinimumOfAllPixels.java)

## CLIJ_minimumSliceBySliceSphere

Computes the local minimum of a pixels elllipsoidal 2D neighborhood in an image stack 
slice by slice. The ellipses size is specified by its half-width and half-height (radius).

**Parameters**: Image source, Image destination, Number radiusX, Number radiusY

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimumSliceBySliceSphere(source, destination, radiusX, radiusY);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MinimumSliceBySliceSphere.java)

## CLIJ_minimumZProjection

Determines the minimum projection of an image along Z.

**Parameters**: Image source, Image destination_sum

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_minimumZProjection(source, destination_sum);
Ext.CLIJ_pull(destination_sum);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MinimumZProjection.java)

## CLIJ_multiplyImageAndScalar

Multiplies all pixels value x in a given image X with a constant scalar s.

f(x, s) = x * s

**Parameters**: Image source, Image destination, Number scalar

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_multiplyImageAndScalar(source, destination, scalar);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MultiplyImageAndScalar.java)

## CLIJ_multiplyImages

Multiplies all pairs of pixel values x and y from two image X and Y.

f(x, y) = x * y

**Parameters**: Image factor1, Image factor2, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(factor1);
Ext.CLIJ_push(factor2);
Ext.CLIJ_multiplyImages(factor1, factor2, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MultiplyImages.java)

## CLIJ_multiplyStackWithPlane

Multiplies all pairs of pixel values x and y from an image stack X and a 2D image Y. x and y are at 
the same spatial position within a plane.

f(x, y) = x * y

**Parameters**: Image sourceStack, Image sourcePlane, Image destination

**Available for**: 3D (first parameter), 2D (second parameter), 3D (result)

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(sourceStack);
Ext.CLIJ_push(sourcePlane);
Ext.CLIJ_multiplyStackWithPlane(sourceStack, sourcePlane, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/MultiplyStackWithPlane.java)

## CLIJ_power

Computes all pixels value x to the power of a given exponent a.

f(x, a) = x * a

**Parameters**: Image source, Image destination, Number exponent

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_power(source, destination, exponent);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Power.java)

## CLIJ_pull

Copies an image specified by its name from GPU memory back to ImageJ and shows it.

**Parameters**: String image

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_pull(image);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Pull.java)

## CLIJ_push

Copies an image specified by its name to GPU memory in order to process it there later.

**Parameters**: String image

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(image);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Push.java)

## CLIJ_release

Frees memory of a specified image in GPU memory.

**Parameters**: Image image

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(image);
Ext.CLIJ_release(image);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Release.java)

## CLIJ_reportMemory

Prints a list of all images cached in the GPU to ImageJs log window together with a sum of memory 
consumption.

**Parameters**: 

**Available for**: -

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_reportMemory();
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ReportMemory.java)

## CLIJ_resliceBottom

Flippes Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method but
offers less flexibility such as interpolation.

**Parameters**: Image source, Image destination

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_resliceBottom(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ResliceBottom.java)

## CLIJ_resliceLeft

Flippes X, Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method 
 but offers less flexibility such as interpolation.

**Parameters**: Image source, Image destination

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_resliceLeft(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ResliceLeft.java)

## CLIJ_resliceRadial

Computes a radial projection of an image stack. Starting point for the line is the center in any 
X/Y-plane of a given input image stack. This operation is similar to ImageJs 'Radial Reslice' method but offers less flexibility.

**Parameters**: Image source, Image destination, Number numberOfAngles, Number angleStepSize

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_resliceRadial(source, destination, numberOfAngles, angleStepSize);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ResliceRadial.java)

## CLIJ_resliceRight

Flippes X, Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method 
 but offers less flexibility such as interpolation.

**Parameters**: Image source, Image destination

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_resliceRight(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ResliceRight.java)

## CLIJ_resliceTop

Flippes Y and Z axis of an image stack. This operation is similar to ImageJs 'Reslice [/]' method but
offers less flexibility such as interpolation.

**Parameters**: Image source, Image destination

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_resliceTop(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ResliceTop.java)

## CLIJ_rotateLeft

Rotates a given input image by 90 degrees counter-clockwise. For that, X and Y axis of an image stack
are flipped. This operation is similar to ImageJs 'Reslice [/]' method but offers less flexibility 
such as interpolation.

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_rotateLeft(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/RotateLeft.java)

## CLIJ_rotateRight

Rotates a given input image by 90 degrees clockwise. For that, X and Y axis of an image stack
are flipped. This operation is similar to ImageJs 'Reslice [/]' method but offers less flexibility 
such as interpolation.

**Parameters**: Image source, Image destination

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_rotateRight(source, destination);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/RotateRight.java)

## CLIJ_set

Sets all pixel values x of a given image X to a constant value v.

f(x) = v

**Parameters**: Image source, Number value

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_set(source, value);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/Set.java)

## CLIJ_sumOfAllPixels

Determines the sum of all pixels in a given image. It will be stored in a new row of ImageJs
Results table in the column 'Sum'.

**Parameters**: Image source

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_sumOfAllPixels(source);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/SumOfAllPixels.java)

## CLIJ_sumZProjection

Determines the sum projection of an image along Z.

**Parameters**: Image source, Image destination_sum

**Available for**: 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_sumZProjection(source, destination_sum);
Ext.CLIJ_pull(destination_sum);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/SumZProjection.java)

## CLIJ_thresholdIJ

Computes a binary image with pixel values 0 and 1. All pixel values x of a given input image with 
value larger or equal to a given threshold t will be set to 1.

f(x,t) = (1 if (x >= t); (0 otherwise))

This plugin is comparable to setting a raw threshold in ImageJ and using the 'Convert to Mask' menu.

**Parameters**: Image source, Image destination, Number threshold

**Available for**: 2D, 3D

**Macro example**: 
```
run("CLIJ Macro Extensions", "cl_device=");
Ext.CLIJ_push(source);
Ext.CLIJ_thresholdIJ(source, destination, threshold);
Ext.CLIJ_pull(destination);
```
[Link to source](http://github.com/clij/clij/tree/master/src/main/java/net/haesleinhuepf/clij/macro/modules/ThresholdIJ.java)

