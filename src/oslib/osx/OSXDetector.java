package oslib.osx;

import java.io.File;
import java.util.List;

import oslib.OperatingSystem;
import oslib.Utils;

public class OSXDetector {
	
	public static boolean detect(boolean fallback) {
		File file = new File("/usr/bin/sw_vers");
		
		try {
			List<String> lines = Utils.readFile(file);
			
			for (String line : lines) {
				if (line.contains(OperatingSystem.OSX.getName())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (fallback) {
			return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.OSX.getPrimarySearch());
		}
		
		return false;
	}

}
