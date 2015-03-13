package com.redpois0n.oslib.osx;

import java.io.File;
import java.util.List;

import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.Utils;

public class OSX {
	
	public static boolean detect(boolean fallback) {
		File file = new File("/usr/bin/sw_vers");
		
		List<String> lines = Utils.readFile(file);
		
		if (fallback) {
			return System.getProperty("os.name").contains(OperatingSystem.OSX.getPrimarySearch());
		}
		
		return false;
	}

}
