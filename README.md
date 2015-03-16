# oslib
Java library to easily detect running Operating System, Linux dist, architecture and BSD flavor

## Examples

### Detecting if running Elementary OS (Linux)
```java
OperatingSystem os = OperatingSystem.getOperatingSystem();

if (os.getType() == OperatingSystem.LINUX) {
	LinuxOperatingSystem los = (LinuxOperatingSystem) os;
	
	if (los.getDistro() == Distro.ELEMENTARY_OS) {
		System.out.println("Is running eOS");
	} else {
		System.out.println("Is running " + los.getDisplayString());
	}
}
```

### Getting all information available about current OS
```java
OperatingSystem os = OperatingSystem.getOperatingSystem();

if (os.getType() == OperatingSystem.OSX) {
  	OSXOperatingSystem xos = (OSXOperatingSystem) os;
   
   	if (xos.getVersion() == OSXVersion.YOSEMITE) {
   		System.out.println("Is running Yosemite " + xos.getVersion().getVersion());
    	// Will print: Is running Yosemite 10.10
  	}
   
   	System.out.println(xos.getDisplayString());
   	// Will print (if running mavericks): Mac OS X Mavericks 10.9
}

if (os.getType() == OperatingSystem.LINUX) {
	LinuxOperatingSystem los = (LinuxOperatingSystem) os;
	
	System.out.println(los.getDisplayString());
	// Will print (if running Kali): Kali Linux 1.0
	
	if (los.getArch() == Arch.x86_64) {
		System.out.println("Is 64 bit");
	}
}
```