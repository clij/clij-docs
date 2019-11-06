# CLIJ - a quick tour
CLIJ is a [Fiji](https://fiji.sc) plugin for GPU-accelerated image processing based on [OpenCL](https://opencl.prg). However, it is not necessary to learn OpenCL. CLIJ has about 100 predefined functions allowing you to process your images on the GPU.

It is recommended to use it from Fiji script editor using the ImageJ macro language. For the ease of use, auto-completion is enabled for editing CLIJ workflows.
![Image](images/autocompletion.png)

Furthermore, CLIJ has its own menu: `Plugins > ImageJ on GPU (CLIJ)` with sub menus offering all CLIJ functionality.
![Image](images/menu.gif)

When clicking on the menu, you see a dialog asking for the parameters of the specific CLIJ operation. Furthermore, user documentation and parameter exlanation is given in the same dialog.
![Image](images/dialogs.gif)

If ImageJs macro recorder up and running, the parameters entered in the dialog are recorded together with additional call necessary for pushing the image to the GPUs memory and pull the result back:
![Image](images/macro_recorder.png)

For exploring CLIJ further, it is recommended to read the [introduction for macro programmers](macro_intro) and have a look at the [code examples](https://clij.github.io/clij-docs/src/main/macro);

[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)

