package com.redpois0n.oslib;

import com.redpois0n.oslib.bsd.BSDOperatingSystem;
import com.redpois0n.oslib.bsd.Flavor;
import com.redpois0n.oslib.bsd.FlavorDetector;
import com.redpois0n.oslib.linux.DistroDetector;
import com.redpois0n.oslib.linux.LinuxDetector;
import com.redpois0n.oslib.linux.LinuxOperatingSystem;
import com.redpois0n.oslib.osx.OSXDetector;
import com.redpois0n.oslib.osx.OSXOperatingSystem;
import com.redpois0n.oslib.solaris.SolarisDetector;
import com.redpois0n.oslib.solaris.SolarisOperatingSystem;
import com.redpois0n.oslib.windows.WindowsDetector;
import com.redpois0n.oslib.windows.WindowsOperatingSystem;

public enum OperatingSystem {

	WINDOWS("Windows", "win"),
	OSX("Mac OS X", "mac"),
	LINUX("Linux", "linux"),
	SOLARIS("Solaris", "solaris", "sunos"),
	BSD("BSD"),
	UNKNOWN("unknown", "unknown");
		
	private String name;
	private String[] search;
	
	private OperatingSystem(String name, String... search) {
		this.name = name;
		this.search = search;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String[] getSearch() {
		return this.search;
	}
	
	public String getPrimarySearch() {
		return this.search[0];
	}
	
	/**
	 * Gets the operating system (Not linux distro)
	 * @param str String like System.getProperty("os.name");
	 * @return
	 */
	public static OperatingSystem getOperatingSystem(String str) {
		str = str.toLowerCase();

		OperatingSystem os = null;
		
		for (OperatingSystem o : OperatingSystem.values()) {
			if (os != null) {
				break;
			}
			
			if (o.getName().equalsIgnoreCase(str)) {
				os = o;
				break;
			}
			
			for (String s : o.getSearch()) {
				if (str.contains(s)) {
					os = o;
					break;
				}
			}
		}

		return os;
	}
	
	public static AbstractOperatingSystem getOperatingSystem() {
		return getOperatingSystem(true);
	}

	/**
	 * Gets this machines operating system
	 * @return
	 */
	public static AbstractOperatingSystem getOperatingSystem(boolean b) {
		Flavor flavor = FlavorDetector.detect(b);
		
		AbstractOperatingSystem os = new UnknownOperatingSystem();
		
		if (flavor != null) {
			os = new BSDOperatingSystem(flavor);
		}
				
		if (LinuxDetector.detect(b)) {
			os = new LinuxOperatingSystem(DistroDetector.detect());
		}
		
		if (OSXDetector.detect(b)) {
			os = new OSXOperatingSystem();
		}
		
		if (WindowsDetector.detect(b)) {
			os = new WindowsOperatingSystem();
		}
		
		if (SolarisDetector.detect(b)) {
			os = new SolarisOperatingSystem();
		}
		
		if (os instanceof UnixOperatingSystem) {
			UnixOperatingSystem uos = (UnixOperatingSystem) os;
			uos.setDetailed(Utils.getUname());
		}
		
		return os;
	}
	
	public static boolean isUnix() {
		return isUnix(getOperatingSystem().getType());
	}
	
	public static boolean isUnix(OperatingSystem os) {
		return os == BSD || os == OSX || os == LINUX || os == SOLARIS;
	}

}
