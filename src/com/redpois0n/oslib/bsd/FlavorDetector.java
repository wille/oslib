package com.redpois0n.oslib.bsd;

import java.io.File;
import java.util.List;

import com.redpois0n.oslib.UnsupportedOperatingSystemException;
import com.redpois0n.oslib.Utils;

public class FlavorDetector {
	
	public static Flavor detect(boolean fallback) throws UnsupportedOperatingSystemException {
		Flavor flavor = null;
		
		List<String> file = null;
		
		try {
			file = Utils.readFile(new File("/var/run/dmesg.boot"));				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (file != null) {
			for (String line : file) {
				flavor = Flavor.getFlavorFromString(line);
				
				if (flavor != null) {
					return flavor;
				}
			}
		}
		
		if (fallback) {
			String prop = System.getProperty("os.name");
			
			flavor = Flavor.getFlavorFromString(prop);
			
			if (flavor != null) {
				return flavor;
			}
		}
		
		return null;
	}

}
