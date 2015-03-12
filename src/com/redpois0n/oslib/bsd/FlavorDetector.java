package com.redpois0n.oslib.bsd;

import com.redpois0n.oslib.UnsupportedOperatingSystemException;

public class FlavorDetector {
	
	public static Flavor detect() throws UnsupportedOperatingSystemException {
		Flavor flavor = null;
		
		try {
			
			if (flavor != null) {
				return flavor;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return Flavor.UNKNOWN;
	}

}
