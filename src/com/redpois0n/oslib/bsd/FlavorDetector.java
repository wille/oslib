package com.redpois0n.oslib.bsd;

import java.io.File;
import java.util.List;

import com.redpois0n.oslib.UnsupportedOperatingSystemException;
import com.redpois0n.oslib.Utils;

public class FlavorDetector {
	
	public static Flavor detect() throws UnsupportedOperatingSystemException {
		Flavor flavor = null;
		
		try {
			List<String> file = Utils.readFile(new File("/var/run/dmesg.boot");
			if (flavor != null) {
				return flavor;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return Flavor.UNKNOWN;
	}

}
