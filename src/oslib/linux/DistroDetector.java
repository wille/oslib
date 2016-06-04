package oslib.linux;

import java.io.File;
import java.util.List;
import java.util.Map;

import oslib.Utils;

public class DistroDetector {
	
	public static DistroSpec detect() {
		Distro distro = null;
		try {
			String detect = null;
			String release = null;
			String codename = null;
	
			boolean lsbReleaseExists = false;
			
			List<String> lsbRelease = null;
			
			try {
				lsbRelease = Utils.readProcess(new String[] { "lsb_release", "-irc" });
				lsbReleaseExists = lsbRelease.size() == 3;
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
			
			boolean b = false;

			for (Distro d : Distro.values()) {
				if (b) {
					break;
				}				
				
				if (distro == null && lsbReleaseExists) {			
					for (String s : lsbRelease) {
						String[] split = s.split(":");
						String key = split[0].trim();
						String value = split[1].trim();
						
						if (key.equals("Distributor ID")) {
							detect = value;
						} else if (key.equals("Release")) {
							release = value;
							if (value.toLowerCase().contains("kali")) {
								distro = Distro.KALI;
								release = null;
								break;
							}
						} else if (key.equals("Codename")) {
							codename = value;
							if (value.toLowerCase().contains("debian") && detect != null && detect.toLowerCase().contains("mint")) {
								distro = Distro.LMDE;
								break;
							}
						}
					}				
				}
				if (distro == null && lsbRelease == null && osreleaseMap != null) {		
					String distribid = osreleaseMap.get("DISTRIB_ID");
										
					if (detect == null && distribid != null) {
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
				
				if (distro == null && lsbreleaseMap != null) {
					String distribid = osreleaseMap.get("DISTRIB_ID");
					
					if (distribid != null) {
						detect = distribid.replace("\"", "");
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
				
				if (distro == null) {
					if (d.getName().equalsIgnoreCase(detect)) {
						distro = d;
					}
					
					if (detect != null) {
						for (Object o : d.getSearchTypes()) {
							if (o instanceof String) {
								String s = (String) o;

								if (s.toLowerCase().contains(detect.toLowerCase())) {
									distro = d;
									break;
								}
							}
						}
					}
					
					for (Object o : d.getSearchTypes()) {
						if (o instanceof SearchType) {
							SearchType st = (SearchType) o;

							if (st.detect() && distro == null) {
								distro = d;
								break;
							}
						}
					}
				}
				
				if (distro == Distro.NIXOS) {					
					try {
						List<String> nixVersion = Utils.readProcess(new String[] { "nixos-version" });
						release = nixVersion.get(0);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				if (distro != null) {
					DistroSpec spec = new DistroSpec(distro);
					spec.setRelease(release);
					spec.setCodename(codename);
					
					return spec;
				}
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return new DistroSpec(Distro.UNKNOWN);
	}
}
