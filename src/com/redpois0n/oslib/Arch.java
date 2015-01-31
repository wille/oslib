package com.redpois0n.oslib;

public enum Arch {

	x86,
	x86_64,
	UNKNOWN;
	
	/**
	 * Gets arch, either 64-bit or x86
	 * @param arch
	 * @return
	 */
	public static Arch getArch(String s) {
		Arch arch;
		
		if (s.equalsIgnoreCase("x86") || s.equalsIgnoreCase("i386") || s.equalsIgnoreCase("i486") || s.equalsIgnoreCase("i586") || s.equalsIgnoreCase("i686")) {
			arch = Arch.x86;
		} else if (s.equalsIgnoreCase("x86_64") || s.equalsIgnoreCase("amd64") || s.equalsIgnoreCase("k8")) {
			arch = Arch.x86_64;
		} else {
			arch = Arch.UNKNOWN;
		}
		
		return arch;
	}
	
	/**
	 * Gets this machines arch
	 * @return
	 */
	public static Arch getArch() {
		return getArch(getArchString());
	}
	
	/**
	 * Same as System.getProperty("os.arch");
	 * @return
	 */
	public static String getArchString() {
		return System.getProperty("os.arch");
	}
	
}
