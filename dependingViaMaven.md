
### Depending on CLIJ

If you want to access CLIJ from your Java code, it is recommended to depend on CLIJ via Maven dependencies. Add this dependency to the pom.xml file of your project:

```xml
<dependency>
  <groupId>net.haesleinhuepf</groupId>
  <artifactId>clij_</artifactId>
  <version>1.4.1</version>
</dependency>
```

To allow maven finding this artifact, add a repository to your pom.xml file:

```xml
<repository>
  <id>clij</id>
  <url>http://dl.bintray.com/haesleinhuepf/clij</url>
</repository>
```

[Back to CLIJ documentation](https://clij.github.io/)

[Imprint](https://clij.github.io/imprint)

