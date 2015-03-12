package com.redpois0n.oslib.bsd;

public enum Flavor {
	
	FREEBS("FreeBSD"),
	OPENBSD("OpenBSD"),
	NETBSD("NetBSD"),
	DRAGONFLYBSD("DragonFlyBSD", "dragonfly");
	
	
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
}
