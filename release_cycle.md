# CLIJ Release cycle
tldr: In order to establish CLIJ as a reliable platform for workflow developers, an annual release cycle is aspired. 
Core functionality of CLIJ will not change between major releases (except hot fixes). 
CLIJ operations may be marked as deprecated in any major release. 
Deprecated operations may be removed with any subsequent major release. 
Thus, developers have at least one year time to make the transition.

The following rules are listed to ease the life of downstream / workflow developers. 
Ultimate goal is to allow development of long-term running, reliable CLIJ based workflows. 
However, to be safe on our side, these rules are not legally binding and may be changed at any point in time.

## Releases
CLIJ is released and distributed via two online resources:
* ImageJ update site: http://sites.imagej.net/clij/
* Bintray maven repository: http://bintray.com/haesleinhuepf/clij/

Workflow developers are recommended to base their tools on the current [major release as stated here](https://clij.github.io/clij-docs/dependingViaMaven).

## CLIJ core libraries
The release cycle includes CLIJs main libraries:
* https://github.com/clij/clij
* https://github.com/clij/clij-core

## Major releases
* Major releases aim to be published annually on June 13th, starting in 2019.
* Major releases aim being backwards compatible. 
* Major releases may mark CLIJ operations as deprecated.
* Major releases may not contain operations which were marked as deprecated in any earlier major release.

## Hot fixes
* Bugfixes and corrections may appear at any point in time. 
* Code changes releated to hot fixes will be available on the master branch of CLIJs repositories.
* Hot fixes appear in the list of [release notes](https://github.com/clij/clij/releases).

## Nightly builds and BETA releases
* Development of CLIJ will be done on the development branch. 
  Developers who want to test nightly-build like versions of CLIJ are suggested to compile the development branch and ship the binaries to their Fiji installation. 
  This can be done by running `mvn install` from the respective root directory.
* By mid of May annually, a BETA release is published to allow workflow developers to test their workflows for compatibility with the new release.

## Further reading
* [Disclaimer / BSD3 license](https://github.com/clij/clij/blob/master/license.txt) 
