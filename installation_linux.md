# Installation on linux

* Ubuntu
* Fedora

## Installation Ubuntu 18.04 LTS

Fresh OS:

```
(Fiji Is Just) ImageJ 2.0.0-rc-69/1.52p; Java 1.8.0_172 [64-bit]; Linux 5.0.0-23-generic; 93MB of 10833MB (<1%)
java.lang.NoClassDefFoundError: Could not initialize class net.haesleinhuepf.clij.clearcl.backend.jocl.ClearCLBackendJOCL
	at net.haesleinhuepf.clij.clearcl.backend.ClearCLBackends.getBestBackend(ClearCLBackends.java:126)
	at net.haesleinhuepf.clij.CLIJ.getAvailableDeviceNames(CLIJ.java:199)
	at net.haesleinhuepf.clij.macro.AbstractCLIJPlugin.run(AbstractCLIJPlugin.java:218)
	at ij.plugin.filter.PlugInFilterRunner.processOneImage(PlugInFilterRunner.java:266)
	at ij.plugin.filter.PlugInFilterRunner.<init>(PlugInFilterRunner.java:114)
	at ij.IJ.runUserPlugIn(IJ.java:232)
	at ij.IJ.runPlugIn(IJ.java:193)
	at ij.Executer.runCommand(Executer.java:137)
	at ij.Executer.run(Executer.java:66)
	at java.lang.Thread.run(Thread.java:748
```

```
sudo apt-get update
sudo apt-get install ocl-icd-opencl-dev
```

Restart Fiji

```
(Fiji Is Just) ImageJ 2.0.0-rc-69/1.52p; Java 1.8.0_172 [64-bit]; Linux 5.0.0-23-generic; 63MB of 10763MB (<1%)
 
net.haesleinhuepf.clij.clearcl.exceptions.OpenCLException: OpenCL error: -1001 -> Unknown OpenCL error:-1001
	at net.haesleinhuepf.clij.clearcl.backend.BackendUtils.checkOpenCLError(BackendUtils.java:346)
	at net.haesleinhuepf.clij.clearcl.backend.jocl.ClearCLBackendJOCL.lambda$getNumberOfPlatforms$0(ClearCLBackendJOCL.java:83)
	at net.haesleinhuepf.clij.clearcl.backend.BackendUtils.checkExceptions(BackendUtils.java:156)
	at net.haesleinhuepf.clij.clearcl.backend.jocl.ClearCLBackendJOCL.getNumberOfPlatforms(ClearCLBackendJOCL.java:81)
	at net.haesleinhuepf.clij.clearcl.ClearCL.getNumberOfPlatforms(ClearCL.java:44)
	at net.haesleinhuepf.clij.clearcl.ClearCL.getAllDevices(ClearCL.java:232)
	at net.haesleinhuepf.clij.CLIJ.getAvailableDeviceNames(CLIJ.java:201)
	at net.haesleinhuepf.clij.macro.AbstractCLIJPlugin.run(AbstractCLIJPlugin.java:218)
	at ij.plugin.filter.PlugInFilterRunner.processOneImage(PlugInFilterRunner.java:266)
	at ij.plugin.filter.PlugInFilterRunner.<init>(PlugInFilterRunner.java:114)
	at ij.IJ.runUserPlugIn(IJ.java:232)
	at ij.IJ.runPlugIn(IJ.java:193)
	at ij.Executer.runCommand(Executer.java:137)
	at ij.Executer.run(Executer.java:66)
	at java.lang.Thread.run(Thread.java:748)
```

```
sudo apt-get install beignet clinfo
```

Error on command line output:
```
ASSERTION FAILED: Not implemented
  at file /build/beignet-Bevceu/beignet-1.3.2/backend/src/llvm/llvm_scalarize.cpp, function bool gbe::Scalarize::scalarizeInsert(llvm::InsertElementInst*), line 838
```

```
sudo apt-get install build-essential
sudo apt-get install cmake
sudo apt-get install llvm
sudo apt-get install llvm-dev
sudo apt-get install pkg-config
sudo apt-get install libclang-dev
sudo apt-get install lib32z1-dev

git clone https://github.com/intel/beignet.git
cd beignet/
mkdir build
cd build

cmake ../
sudo make install


```

[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)
