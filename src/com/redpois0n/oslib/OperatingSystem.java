package com.redpois0n.oslib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public enum OperatingSystem {

	WINDOWS("win"),
	OSX("mac"),
	LINUX("linux"),
	SOLARIS("solaris", "sunos"),
	FREEBSD("freebsd"),
	OPENBSD("openbsd"),
	NETBSD("netbsd"),
	ANDROID("android"),
	UNKNOWN("unknown");

	private static String shortName;
	private static String longName;
	
	private String[] search;
	
	static {
		if (getOperatingSystem() != WINDOWS) {
			longName = getUname();
		}
	}
	
	private OperatingSystem(String... search) {
		this.search = search;
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
		if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
			return ANDROID;
		}
		return getOperatingSystem(System.getProperty("os.name"));
	}
	
	/**
	 * Gets basic operating system string
	 * @return Few examples are "Windows 8.1", "Ubuntu Linux" and "Mac OS X 10.10"
	 */
	public static String getShortOperatingSystem() {
		if (shortName == null) {
			if (OperatingSystem.getOperatingSystem() == OperatingSystem.LINUX) {
				try {
					String uname = getUname();
					
					/**
					 * Returns distros that doesn't modify /etc/*-release
					 */
					if (uname != null) {
						if (uname.toLowerCase().contains("raspbian")) {
							shortName = "Raspbian Linux";
						} else if (uname.toLowerCase().contains("crunchbang")) {
							shortName = "Crunchbang Linux";
						} else if (uname.toLowerCase().contains("lxle")) {
							shortName = "LXLE Linux";
						}
						
						if (shortName != null) {
							return shortName;
						}
					}
					
					boolean lsb = true;
					
					File file = new File("/etc/lsb-release");
					 
					if (!file.exists()) {
						file = new File("/etc/os-release");
						lsb = false;
					}
					
					if (!file.exists()) {
						File[] files = new File("/etc/").listFiles();
						
						if (files != null) {
							for (File possible : files) {
								if (possible.getName().toLowerCase().endsWith("-release")) {
									file = possible;
									break;
								}
							}
						}
						lsb = false;
					}
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					String firstLine = null;
					String s;
					while ((s = reader.readLine()) != null) {
						if (firstLine == null) {
							firstLine = s;
						}
						if (lsb && s.startsWith("DISTRIB_ID=")) {
							shortName = s.substring(11, s.length()).replace("\"", "");
							if (!shortName.toLowerCase().contains("linux")) {
								shortName += " Linux";
							}
							reader.close();
							break;
						} else if (s.startsWith("NAME=")) {
							shortName = s.substring(5, s.length()).replace("\"", "");
							if (!shortName.toLowerCase().contains("linux")) {
								shortName += " Linux";
							}
							reader.close();
							break;
						}
					}
					reader.close();
					
					if (shortName == null) {
						shortName = firstLine;
						if (!shortName.toLowerCase().contains("linux")) {
							shortName += " Linux";
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					shortName = System.getProperty("os.name");
				}
			} else if (OperatingSystem.getOperatingSystem() == OperatingSystem.OSX) {
				shortName = System.getProperty("os.name") + " " + OSXVersion.getFromString(System.getProperty("os.version")).getDisplay();
			} else if (OperatingSystem.getOperatingSystem() == OperatingSystem.SOLARIS) {
				shortName = "Solaris"; // I prefer Solaris over SunOS
			} else {
				shortName = System.getProperty("os.name");
			}
		}

		return shortName;
	}

	/**
	 * Gets long operating system string
	 * @return Will return "uname -a" on Linux, on other systems os.name + os.version + os.arch
	 */
	public static String getLongOperatingSystem() {
		if (OperatingSystem.getOperatingSystem() == OperatingSystem.LINUX) {
			if (longName == null) {
				longName = System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + Arch.getArchString();
			}
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

}
