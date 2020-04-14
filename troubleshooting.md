# Troubleshooting
## Big Images on NVidia graphics cards
Errors may pop up when processing big images on NVidia cards on Windows (CL_INVALID_COMMAND_QUEUE, CL_INVALID_PROGRAM_EXECUTABLE, CL_MEM_OBJECT_ALLOCATION_FAILURE): The issue is related to a timeout of the operating system interrupting processing on the GPU. Add these keys to the windows registry and restart the machine (warning, don't do this if you're not sure. Ask you IT department for support. [Read the BSD3 license file](license.txt) for details on what why we're not responsible for your actions on your computer ):
```
[HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\GraphicsDrivers]
"TdrDelay"=dword:0000003c
"TdrDdiDelay"=dword:0000003c
```
Here is more information about what TDR is: https://docs.microsoft.com/en-us/windows-hardware/drivers/display/tdr-registry-keys

## Big Images on AMD graphics cards
Similar to NVidia drives (see above), issues may appear due to a timeout when processing large images. The issue is related to a timeout of the operating system interrupting processing on the GPU. Add these keys to the windows registry and restart the machine (warning, don't do this if you're not sure. Ask you IT department for support. [Read the BSD3 license file](license.txt) for details on what why we're not responsible for your actions on your computer ). Similar to the solution above, enter a new key in the registry of Windows in this path
```
HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\GraphicsDrivers
```
The key should be called `TdrDelay` and have a value of 8.

Sources: 
https://community.amd.com/thread/180166
https://support.microsoft.com/en-us/help/2665946/display-driver-stopped-responding-and-has-recovered-error-in-windows-7

## Initialisation fails
Fiji crashes when calling the first CLIJ filter: Check if the initialisation contains a proper name for a GPU.

## Repeated initialisation fails on AMD Vega 10
When creating CLIJ instances and closing them repeatedly, it crashes after about 40 attempts. [This test](https://github.com/clij/clij-core/blob/master/src/test/java/net/haesleinhuepf/clij/test/InitialisationTest.java#L17) allows reproducing the issue on specified hardward. Workaround:
Don't close the CLIJ instance and keep working with the singleton instance.
## Result image is black or shows random textures
This might happend with older GPUs which have not been tested. A helpful workaround is converting all images to 32 bit using `run("32-bit");` before sending them to the GPU.
## filename.cl not found
"java.io.IOException: Cannot find source: [Object] <path/filename.cl>" exception: Navigate to the jars subdirectory of your Fiji installation and locate `clearcl.jar` files, e.g. by typing `dir clearcl*` or `ls clearcl*`. If there are several versions installed, remove the older one. In order to fix this exception, you need at least `clearcl-0.5.5-RH.jar`.
## Problem while setting argument
"clearcl.exceptions.ClearCLException: problem while setting argument 'parameter_of_type_float'": To hand over parameters of type float, you need to explicitly type it. Use `from java.lang import Float` and `Float(1.5)` to handover a value of 1.5 to an OpenCL parameter of type float.
## Class not found on Linux
CLIJ doesn't start on Ubuntu linux with an error message that a class called ClearCLBackendJOCL cannot be initialized. Installing 'ocl-icd-opencl-dev' helped here.
## Exceptions on Linux
CLIJ throws various exceptions, like CL_OUT_OF_HOST_MEMORY on Linux. Try installing an OpenCL-driver such as beignet. On Fedora 27 Linux, this command list helped:

```
sudo yum install ocl-icd-devel
sudo yum install cmake
sudo yum install llvm
sudo yum install llvm-devel
sudo yum install libdrm libdrm-devel
sudo yum install libXext-devel
sudo yum install libXfixes-devel
sudo yum install clang-devel

git clone https://github.com/intel/beignet.git
cd beignet/
mkdir build
cd build
cmake ../
make
sudo make install

```
More info can be found on the website of the [beignet project](https://www.freedesktop.org/wiki/Software/Beignet/).



[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)
