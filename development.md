## Developing using maven
CLIJ uses the maven build system. In order to develop CLIJ, use git to get the recent version and maven to build it: 

Clone the clij repository
```
git clone https://github.com/clij/clij
```

Open pom.xml and enter the path of your Fiji installation in the line containing

```
<imagej.app.directory>C:/path/to/Fiji.app
```

Go to the source dir and install it to your Fiji.app

```
cd clij
install.bat
```

For development it is recommended to use an integrated development environment such as IntelliJ or Eclipse.

[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)

