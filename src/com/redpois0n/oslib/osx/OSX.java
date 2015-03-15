package com.redpois0n.oslib.osx;

import java.io.File;
import java.util.List;

import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.Utils;

public class OSX {
	
	public static boolean detect(boolean fallback) {	
		try {		
			File file = new File("/usr/bin/sw_vers");
			
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
			return System.getProperty("os.name").contains(OperatingSystem.OSX.getPrimarySearch());
		}
		
		return false;
	}

}
