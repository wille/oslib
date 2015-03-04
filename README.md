# oslib
Small library to easily detect running Operating System or Linux dist and architecture

## Examples

### Detecting if running Elementary OS (Linux)
```java
if (OperatingSystem.getOperatingSystem() == OperatingSystem.LINUX && Distro.getDistro() == Distro.ELEMENTARYOS) {
    // is running eOS
}
```

### Getting all information available about current OS
```java
if (OperatingSystem.getOperatingSystem() == OperatingSystem.OSX && OSXVersion.getFromString() == OSXVersion.YOSEMITE) {
    System.out.println(OperatingSystem.getLongOperatingSystem());
    // will print out Mac OS X 10.10 Yosemite x64 if running 10.10
}
```