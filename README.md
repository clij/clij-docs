# CLIJ - GPU-accelerated image processing in ImageJ
## Introduction
CLIJ is an OpenCL - ImageJ bridge and a Fiji plugin allowing users with no computer science background to explort GPU-acceleration for their image processing workflows. Increased efforts were put on documentation, code examples, interoperability, extensibility and user-convenience.
CLIJ is based on [ClearCL](http://github.com/ClearControl/ClearCL), [Imglib2](https://github.com/imglib), [ImageJ](http://image.net) and [SciJava](https://github.com/SciJava)

**If you use CLIJ, please cite it:**


If you search for support, please open a thread on the [image.sc](https://image.sc) forum.

[![Image.sc forum](https://img.shields.io/badge/dynamic/json.svg?label=forum&url=https%3A%2F%2Fforum.image.sc%2Ftags%2Fclij.json&query=%24.topic_list.tags.0.topic_count&colorB=brightgreen&suffix=%20topics&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAOCAYAAAAfSC3RAAABPklEQVR42m3SyyqFURTA8Y2BER0TDyExZ+aSPIKUlPIITFzKeQWXwhBlQrmFgUzMMFLKZeguBu5y+//17dP3nc5vuPdee6299gohUYYaDGOyyACq4JmQVoFujOMR77hNfOAGM+hBOQqB9TjHD36xhAa04RCuuXeKOvwHVWIKL9jCK2bRiV284QgL8MwEjAneeo9VNOEaBhzALGtoRy02cIcWhE34jj5YxgW+E5Z4iTPkMYpPLCNY3hdOYEfNbKYdmNngZ1jyEzw7h7AIb3fRTQ95OAZ6yQpGYHMMtOTgouktYwxuXsHgWLLl+4x++Kx1FJrjLTagA77bTPvYgw1rRqY56e+w7GNYsqX6JfPwi7aR+Y5SA+BXtKIRfkfJAYgj14tpOF6+I46c4/cAM3UhM3JxyKsxiOIhH0IO6SH/A1Kb1WBeUjbkAAAAAElFTkSuQmCC)](https://forum.image.sc/tags/clij)


## Overview

* [CLIJ - a quick tour](quickTour)
* [Example benchmarks](benchmarking)
* Installation
  * [Fiji update site](installationInFiji)
  * [Depending on CLIJ via maven](dependingViaMaven)
* Introduction to CLIJ programming
  * [CLIJ for ImageJ Macro programmers](macro_intro)
  * [CLIJ for Java programmers](api_intro)
  * [CLIJ ImageJ Jupyter notebooks in Groovy](https://github.com/clij/clij-notebooks/blob/master/clij-intro.ipynb)
  * [CLIJ execution from the command line](https://github.com/clij/clij-executable-example)
* Application programming interface (API)
  * [API design principles](api_design_priciples)
  * [ImageJ Macro](reference)
  * [Jython](referenceJython)
  * [Java](referenceJava)
  * [Groovy](referenceGroovy)
* Code examples
  * [ImageJ Macro](https://github.com/mpicbg-csbd/clij-docs/tree/master/src/main/macro)
  * [ImageJ BeanShell](https://github.com/mpicbg-csbd/clij-docs/tree/master/src/main/beanshell)
  * [ImageJ Jython](https://github.com/mpicbg-csbd/clij-docs/tree/master/src/main/jython)
  * [ImageJ JavaScript](https://github.com/mpicbg-csbd/clij-docs/tree/master/src/main/javascript)
  * [ImageJ Groovy](https://github.com/mpicbg-csbd/clij-docs/tree/master/src/main/groovy)
  * [Java](https://github.com/mpicbg-csbd/clij-docs/tree/master/src/main/java/net/haesleinhuepf/clij/examples)
* Extending CLIJ functionality
  * [CLIJ plugin template](https://github.com/clij/clij-plugin-template/)
  * [CLIJ example plugin for convolution/deconvolution](https://github.com/clij/clij-custom-convolution-plugin/)
* Troubleshotting
  * [List of tested systems](testedsystems)
  * [Troubleshooting](troubleshooting)
  * [Support](https://image.sc)

## Acknowledgements
Development of CLIJ is a community effort. We would like to thank everybody who helped developing and testing. In particular thanks goes to 
Laurent Thomas (Acquifer), 
Bruno C. Vellutini (MPI CBG),
Jan Brocher (Biovoxxel), 
J\"urgen Gluch (Fraunhofer IKTS),
Tobias Pietzsch (MPI-CBG),
Giovanni Cardone (MPI Biochem),
Damir Krunic (DKFZ),
Gaby G. Martins (IGC),
Daniel J. White (GE),
Nico Stuurman (UCSF),
Johannes Girstmair (MPI CBG).

TODO:
* Remove code examples from clij_
* Remove documentation from clij_, link here
* Update links/intro on clij-notebook
* Finish benchmarking page
* Put Drosophila data sets for benchmarking online
* Add link to BioRxiv


  















