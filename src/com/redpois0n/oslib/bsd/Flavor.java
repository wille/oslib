package com.redpois0n.oslib.bsd;

import com.redpois0n.oslib.UnsupportedOperatingSystemException;

public enum Flavor {
	
	FREEBS("FreeBSD"),
	OPENBSD("OpenBSD"),
	NETBSD("NetBSD"),
	DRAGONFLYBSD("DragonFlyBSD", "dragonfly"),
	UNKNOWN("Unknown BSD");
	
	private String name;
	private String[] search;
	
	private Flavor(String name, String... search) {
		this.name = name;
		this.search = search;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String[] getSearch() {
		return this.search;
	}
	
	public String getPrimarySearch() {
		return this.search[0];
	}
	
	public static Flavor getFlavorFromString(String s) {
		for (Flavor d : values()) {
			if (d.getName().equalsIgnoreCase(s)) {
				return d;
			}
			
			for (String search : d.getSearch()) {
				if (search.contains(s)) {
					return d;
				}
			}
		}
				
		return Flavor.UNKNOWN;
	}
	
	public static Flavor getLocalFlavor() throws UnsupportedOperatingSystemException {
		return FlavorDetector.detect(true);
	}
}
