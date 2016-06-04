package oslib.windows;

import oslib.OperatingSystem;

public class WindowsDetector {
	
	public static boolean detect(boolean fallback) {
		if (fallback) {
			return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.WINDOWS.getPrimarySearch());
		}
		
		return false;
	}

}
