## Installation in MicroManger

In order to get CLIJ accessible from [MicroManager 2.0 gamma](https://valelab4.ucsf.edu/~MM/nightlyBuilds/2.0.0-gamma/Windows/) scripting interface, please copy these files from the recent [CLIJ release](https://github.com/clij/clij/releases) into the `/plugins/` directory of MicroManager:
* [clij_1.4.5.jar](https://github.com/clij/clij/releases/download/1.4.5/clij_-1.4.5.jar)
* [clij-clearcl-0.10.4.jar](https://github.com/clij/clij/releases/download/1.4.5/clij-clearcl-0.10.4.jar)
* [clij-core-1.4.5.jar](https://github.com/clij/clij/releases/download/1.4.5/clij-core-1.4.5.jar)
* [clij-coremem-0.6.0.jar](https://github.com/clij/clij/releases/download/1.4.5/clij-coremem-0.6.0.jar)
* [imagej-common-0.28.2.jar](https://sites.imagej.net/Java-8/jars/imagej-common-0.28.2.jar-20190516211613)
* [imglib2-realtransform-2.1.0.jar](https://sites.imagej.net/Java-8/jars/imglib2-realtransform-2.1.0.jar-20181204141527)
* [imglib2-ij-2.0.0-beta-44.jar](https://sites.imagej.net/Java-8/jars/imglib2-ij-2.0.0-beta-44.jar-20181204141527)
* [clij-advanced-filters_-0.21.3.jar](https://github.com/clij/clij-advanced-filters/releases/download/0.21.3/clij-advanced-filters_-0.21.3.jar)
* [fiji-lib-2.1.2.jar](https://sites.imagej.net/Java-8/jars/fiji-lib-2.1.2.jar-20170530201750)

Afterwards, restart MicroManager. You can try if it works by running [this beanshell script](https://github.com/clij/clij-docs/blob/master/src/main/beanshell/clij_micromanager.bsh) to see if it works.

[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)
