package com.redpois0n.oslib;

import java.util.List;

public class DistroDetector {
	
	public static DistroSpec getDistro() {
		Distro distro = Distro.UNKNOWN;
		try {
			for (Distro d : Distro.values()) {
				String detect = null;
				String release = null;
				String codename = null;
				
				List<String> checkLSBrelease = Utils.readProcess(new String[] { "type", "-p", "lsb_release" });
				
				if (checkLSBrelease.size() > 0) {
					List<String> lsbRelease = Utils.readProcess(new String[] { "lsb_release", "-irc" });
					
					for (String s : lsbRelease) {
						String[] split = s.split(":");
						String key = split[0].trim();
						String value = split[1].trim();
						
						if (key.equals("Distributor ID")) {
							detect = value;
						} else if (key.equals("Release")) {
							release = value;
						} else if (key.equals("Codename")) {
							codename = value;
						}
					}
					
					if (detect != null) {
						distro = d;
						distro
						break;
					}
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return distro;
	}

}
