# API design principles

In order to simplify image processing using CLIJ from an application programming interface (API) as well as usability point of view, some general rules have been established:

* All numeric spatial parameters in CLIJ such as radius and sigma are always entered in pixels. There is no operation in CLIJ which makes use of any physical units.
* Pixel coordinates in X, Y and Z are zero-based indiced.
* Only two- and three-dimensional images are supported.
* There are no in-place operations supported in CLIJ. No operation overwrites its input images.
* The currently active image window in ImageJ plays no role in CLIJ. Input and output images must be specified in macros by name explicitly.
* If a specified output image does not exist in GPU memory, it will be generated automatically with a size defined by the executed operation with respect to input image and given parameters.
* If a specified output image exists already in GPU memory, it will be overwritten.
* CLIJ operations called from ImageJ macro have no return values. They either process pixels and save results to images or they save their results to ImageJs results table.
* Binary output images are filled with pixel values 0 and 1. Any input image can serve as binary image and will be interpreted by differentiating 0 and non-zero values.

[Back to CLIJ documentation](https://clij.github.io/) 

[Imprint](https://clij.github.io/imprint)


