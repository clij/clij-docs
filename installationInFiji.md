
## Installation
[Download and install Fiji](https://fiji.sc/Downloads). Afterwards, click the menu `Help > Update...` and activate the [CLIJ update site](installationInFiji.

![Image](images/updatesite.png)

CLIJ is successfully installed, if you find a menu entry _Plugins > ImageJ on GPU (CLIJ)_.

## Windows and MacOS
On Windows and MacOS installation works right away in case the computer has a build-in Intel HD GPU or AMD Ryzen GPU. In case dedicated AMD or NVidia GPUs are used, special driver might have to be installed. Search for more information about drives on the website of the GPU vendors. 

## Windows: AMD and NVidia graphics cards
Errors may pop up when processing big images on NVidia or AMD graphics cards on Windows. The issue is related to a timeout of the operating system interrupting processing on the GPU. Add the following entries keys to the windows registry and restart the machine 
```
[HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\GraphicsDrivers]
"TdrDelay"=dword:0000003c
"TdrDdiDelay"=dword:0000003c
```
Don't do this if you're not aware what that means. Ask you IT department for support. [Read the BSD3 license file](license.txt) for details on what why we're not responsible for your actions on your computer. More technical background information: 
https://docs.microsoft.com/en-us/windows-hardware/drivers/display/tdr-registry-keys
https://community.amd.com/thread/180166
https://support.microsoft.com/en-us/help/2665946/display-driver-stopped-responding-and-has-recovered-error-in-windows-7

## Linux
Linux users need to install drivers for OpenCL, even on Intel HD GPUs. It is recommended to install the packaged [beignet](https://github.com/intel/beignet) and [ocl-icd-devel](https://github.com/OCL-dev/ocl-icd).

[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)

