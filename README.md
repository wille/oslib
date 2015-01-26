# oslib
Small library to easily detect running Operating System or Linux dist and architecture

Will soon support OS X and Windows version detection, and more distros.

## Examples

### Detecting if running Elementary OS (Linux)
```java
if (OperatingSystem.getOperatingSystem() == OperatingSystem.LINUX && OperatingSystem.getDistro() == Distro.ELEMENTARYOS) {
    // is running eOS
}
```

### Getting all information available about current OS
```java
if (OperatingSystem.getOperatingSystem() == OperatingSystem.OSX) {
    System.out.println(OperatingSystem.getLongOperatingSystem());
    // will print out Mac OS X Yosemite if running 10.10
}
```