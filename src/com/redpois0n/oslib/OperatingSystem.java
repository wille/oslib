package com.redpois0n.oslib;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.redpois0n.oslib.bsd.Flavor;
import com.redpois0n.oslib.bsd.FlavorDetector;
import com.redpois0n.oslib.linux.DistroDetector;
import com.redpois0n.oslib.linux.LinuxDetector;
import com.redpois0n.oslib.osx.OSXDetector;
import com.redpois0n.oslib.osx.OSXVersion;
import com.redpois0n.oslib.solaris.SolarisDetector;
import com.redpois0n.oslib.windows.WindowsDetector;

public enum OperatingSystem {

	WINDOWS("Windows", "win"),
	OSX("Mac OS X", "mac"),
	LINUX("Linux", "linux"),
	SOLARIS("Solaris", "solaris", "sunos"),
	BSD("BSD"),
	UNKNOWN("unknown", "unknown");
	
	private static String shortDisplay;
	
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
			
			for (String s : o.getSearch()) {
				if (str.contains(s)) {
					os = o;
					break;
				}
			}
		}

		return os;
	}

	/**
	 * Gets this machines operating system
	 * @return
	 */
	public static OperatingSystem getOperatingSystem() {
		if (FlavorDetector.detect(true) != null) {
			return BSD;
		}
		
		if (LinuxDetector.detect(true)) {
			return LINUX;
		}
		
		if (OSXDetector.detect(true)) {
			return OSX;
		}
		
		if (WindowsDetector.detect(true)) {
			return WINDOWS;
		}
		
		if (SolarisDetector.detect(true)) {
			return SOLARIS;
		}
		
		return UNKNOWN;
	}
	
	/**
	 * Gets basic operating system string
	 * @return Few examples are "Windows 8.1", "Ubuntu Linux" and "Mac OS X 10.10"
	 */
	public static String getShortOperatingSystem() {
		if (shortDisplay == null) {
			if (OperatingSystem.getOperatingSystem() == OperatingSystem.LINUX) {
				shortDisplay = DistroDetector.detect().getDistro().getDisplayString();
			} else if (OperatingSystem.getOperatingSystem() == OperatingSystem.OSX) {
				shortDisplay = System.getProperty("os.name") + " " + OSXVersion.getFromString().getDisplay();
			} else if (OperatingSystem.getOperatingSystem() == OperatingSystem.SOLARIS) {
				shortDisplay = "Solaris"; // I prefer Solaris over SunOS
			} else {
				shortDisplay = System.getProperty("os.name");
			}
		}

		return shortDisplay;
	}

	/**
	 * Gets long operating system string
	 * @return Will return "uname -a" on Linux, on other systems os.name + os.version + os.arch
	 */
	public static String getLongOperatingSystem() {
		String longName;
		
		if (OperatingSystem.getOperatingSystem() == OperatingSystem.LINUX) {
			longName = getUname();
		} else if (OperatingSystem.getOperatingSystem() == OperatingSystem.OSX) {
			longName = System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + OSXVersion.getFromString().getSearch() + " " + Arch.getStringFromArch();
		} else {
			longName = System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + Arch.getArchString();
		}
		
		return longName;
	}

	/**
	 * Runs the command "uname -a" and reads the first line
	 * @return
	 */
	public static String getUname() {
		String uname = null;
		
		try {
			Process p = Runtime.getRuntime().exec(new String[] { "uname", "-a"});
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			uname = reader.readLine();
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return uname;
	}
	
	public static boolean isUnix() {
		return isUnix(getOperatingSystem());
	}
	
	public static boolean isUnix(OperatingSystem os) {
		return os == BSD || os == OSX || os == LINUX;
	}

}
