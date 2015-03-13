package com.redpois0n.oslib;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		
		if (flavor != null) {
			return new BSDOperatingSystem(flavor);
		}
		
		boolean linux = LinuxDetector.detect(b);
		
		if (linux) {
			return new LinuxOperatingSystem(DistroDetector.detect());
		}
		
		if (OSXDetector.detect(b)) {
			return new OSXOperatingSystem();
		}
		
		if (WindowsDetector.detect(b)) {
			return new WindowsOperatingSystem();
		}
		
		if (SolarisDetector.detect(b)) {
			return new SolarisOperatingSystem();
		}
		
		return null;
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
		return isUnix(getOperatingSystem().getType());
	}
	
	public static boolean isUnix(OperatingSystem os) {
		return os == BSD || os == OSX || os == LINUX;
	}

}
