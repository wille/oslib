package com.redpois0n.oslib.solaris;

import com.redpois0n.oslib.OperatingSystem;

public class SolarisDetector {
	
	public static boolean detect(boolean fallback) {
		if (fallback) {
			for (String search : OperatingSystem.SOLARIS.getSearch()) {
				if (System.getProperty("os.name").toLowerCase().contains(search)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
