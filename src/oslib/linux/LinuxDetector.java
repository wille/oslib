package oslib.linux;

import oslib.OperatingSystem;

public class LinuxDetector {
	
	public static boolean detect(boolean fallback) {
		if (fallback) {
			return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.LINUX.getPrimarySearch());
		}
		
		return false;
	}

}
