package com.redpois0n.oslib;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.redpois0n.oslib.distro.DistroSpec;
import com.redpois0n.oslib.distro.SearchType;

public class DistroDetector {
	
	public static DistroSpec getDistro() {
		Distro distro = null;
		try {
			String detect = null;
			String release = null;
			String codename = null;
	
			boolean lsbReleaseExists = false;
			
			List<String> lsbRelease = null;
			
			try {
				lsbRelease = Utils.readProcess(new String[] { "lsb_release", "-irc" });
				lsbReleaseExists = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
						
			Map<String, String> osreleaseMap = null;
			Map<String, String> lsbreleaseMap = null;
			
			try {
				osreleaseMap = Utils.mapFile(new File("/etc/os-release"), "=");
			} catch (Exception e) {
				System.out.println("Failed to load /etc/os-release");
			}
			
			try {
				lsbreleaseMap = Utils.mapFile(new File("/etc/lsb-release"), "=");
			} catch (Exception ex) {
				System.out.println("Failed to load /etc/lsb-release");
			}

			for (Distro d : Distro.values()) {		
				for (Object o : d.getSearchTypes()) {
					if (o instanceof SearchType) {
						SearchType st = (SearchType) o;
						
						System.out.println("Checking " + st.getClass().getSimpleName() + "; " + st.detect());
						if (st.detect()) {
							distro = d;
							break;
						}
					}
				}
				
				if (distro != null) {
					break;
				}
				
				if (lsbReleaseExists) {
					
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
				}
				
				if (lsbreleaseMap == null && osreleaseMap != null && detect == null) {		
					String distribid = osreleaseMap.get("DISTRIB_ID");
					
					if (distribid != null) {
						detect = distribid.replace("\"", "");;
					}
					
					String name = osreleaseMap.get("NAME");
					
					if (distribid == null && name != null) {
						detect = name.replace("\"", "");;
					}
					
					String version = osreleaseMap.get("VERSION_ID");
					
					if (version != null) {
						release = version.replace("\"", "");
					}
					
					String distribrelease = osreleaseMap.get("DISTRIB_RELEASE");
					
					if (distribrelease != null) {
						release = distribrelease.replace("\"", "");
					}
					
					String distribcodename = osreleaseMap.get("DISTRIB_CODENAME");
					
					if (distribcodename != null) {
						codename = distribcodename.replace("\"", "");
					}
				}
				
				if (lsbreleaseMap != null) {
					String distribid = osreleaseMap.get("DISTRIB_ID");
					
					if (distribid != null) {
						if (distribid.toLowerCase().contains("mint") && distribid.toLowerCase().contains("debian")) {
							detect = "LMDE";
						} else if (distribid.toLowerCase().contains("mint")) {
							detect = "Linux Mint";
						} else {
							detect = distribid.replace("\"", "");
						}
					}

					String distribrelease = osreleaseMap.get("DISTRIB_RELEASE");
					
					if (distribrelease != null) {
						release = distribrelease.replace("\"", "");
					}
					
					String distribcodename = osreleaseMap.get("DISTRIB_CODENAME");
					
					if (distribcodename != null) {
						codename = distribcodename.replace("\"", "");
					}
				}
				
				for (Object o : d.getSearchTypes()) {
					if (o instanceof String) {
						String s = (String) o;
						
						if (s.equalsIgnoreCase(detect)) {
							distro = d;
							break;
						}
					}
				}
			}
			
			if (distro != null) {
				DistroSpec spec = new DistroSpec(search(detect));
				spec.setRelease(release);
				spec.setCodename(codename);
				
				return spec;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static Distro search(String name) {
		for (Distro d : Distro.values()) {
			for (Object o : d.getSearchTypes()) {
				if (o instanceof String) {
					String s = (String) o;
					
					if (s.equalsIgnoreCase(name)) {
						return d;
					}
				} else if (o instanceof SearchType) {
					SearchType st = (SearchType) o;
					
					if (st.detect()) {
						return d;
					}
				}
			}
		}
		
		return Distro.UNKNOWN;
	}

}
