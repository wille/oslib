package com.redpois0n.oslib;

public enum Distros {
	
	UBUNTU("ubuntu"),
	KALI("kali"),
	CENTOS("centos"),
	DEBIAN("debian"),
	ELEMENTARYOS("elementary os"),
	MINT("mint"),
	SLACKWARE("slackware"),
	ARCH("arch"),
	GENTOO("gentoo"),
	RASPBIAN("raspbian"),
	STEAMOS("steamos");
	
	private String s;
	
	private Distros(String s) {
		this.s = s;
	}
	
}
