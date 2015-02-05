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
		
		if (search.toLowerCase().contains("ubuntu")) {
			distro = UBUNTU;
		} else if (search.toLowerCase().contains("kali")) {
			distro = KALI;
		} else if (search.toLowerCase().contains("backtrack")) {
			distro = BACKTRACK;
		} else if (search.toLowerCase().contains("centos")) {
			distro = CENTOS;
		} else if (search.toLowerCase().contains("debian")) {
			distro = DEBIAN;
		} else if (search.toLowerCase().contains("elementary")) {
			distro = ELEMENTARYOS;
		} else if (search.toLowerCase().contains("mint")) {
			distro = MINT;
		} else if (search.toLowerCase().contains("slackware")) {
			distro = SLACKWARE;
		} else if (search.toLowerCase().contains("arch")) {
			distro = ARCH;
		} else if (search.toLowerCase().contains("gentoo")) {
			distro = GENTOO;
		} else if (search.toLowerCase().contains("raspbian")) {
			distro = RASPBIAN;
		} else if (search.toLowerCase().contains("steam")) {
			distro = STEAMOS;
		} else if (search.toLowerCase().contains("fedora")) {
			distro = FEDORA;
		} else if (search.toLowerCase().contains("crunchbang")) {
			distro = CRUNCHBANG;
		} else if (search.toLowerCase().contains("lxle")) {
			distro = LXLE;
		} else if (search.toLowerCase().contains("mageia")) {
			distro = MAGEIA;
		} else if (OperatingSystem.getOperatingSystem(search) != OperatingSystem.LINUX) {
			distro = null;
		} else {
			distro = UNKNOWN;
		}
		
		return distro;
	}
	
}
