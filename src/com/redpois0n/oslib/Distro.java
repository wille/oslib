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
	STEAMOS("steamos"),
	UNKNOWN("");
	
	private String s;
	
	private Distro(String s) {
		this.s = s;
	}
	
	public String getIdentifier() {
		return this.s;
	}
	
}
