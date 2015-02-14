package com.redpois0n.oslib;

public enum Distro {
	
	UBUNTU("ubuntu"),
	KALI("kali"),
	BACKTRACK("backtrack"),
	CENTOS("centos"),
	DEBIAN("debian"),
	ELEMENTARYOS("elementary os"),
	MINT("mint"),
	SLACKWARE("slackware"),
	ARCH("arch"),
	GENTOO("gentoo"),
	RASPBIAN("raspbian"),
	STEAMOS("steam"),
	FEDORA("fedora"),
	CRUNCHBANG("crunchbang"),
	LXLE("lxle"),
	MAGEIA("mageia"),
	ALPINE("alpine"),
	UNKNOWN("");
	
	private String s;
	
	private Distro(String s) {
		this.s = s;
	}
	
	public String getIdentifier() {
		return this.s;
	}

	/**
	 * Gets this machine linux distro
	 * @return
	 */
	public static Distro getDistro() {
		return getDistro(OperatingSystem.getShortOperatingSystem());
	}

	/**
	 * Returns linux distro found from search string
	 * @return Distro.UNKNOWN if no known distro is found, null if not even Linux is detected from search
	 */
	public static Distro getDistro(String search) {
		Distro distro;
		
		for (Distro d : Distro.values()) {
			if (search.toLowerCase().contains(d.getIdentifier())) {
				return d;
			}
		}
		
		if (OperatingSystem.getOperatingSystem(search) != OperatingSystem.LINUX) {
			distro = null;
		} else {
			distro = UNKNOWN;
		}
		
		return distro;
	}
	
}
