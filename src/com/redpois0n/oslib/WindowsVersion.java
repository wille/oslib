package com.redpois0n.oslib;

public enum WindowsVersion {
	
	WIN2000("windows 2000"),
	WINXP("windows xp"),
	WINSERVER2003("windows 2003"), // Note that Windows Server 2003 identifies itself only as Windows 2003
	WINVISTA("windows vista"),
	WINSERVER2008("windows server 2008"),
	WIN7("windows 7"),
	WIN8("windows 8"),
	WIN81("windows 8.1"),
	WINSERVER2012("windows server 2012"),
	WIN10("windows 10"); // NOT BEING DETECTED BY THE JVM! os.name returns 8.1!
	
	private String search;
	
	private WindowsVersion(String search) {
		this.search = search;
	}
	
	public String getSearch() {
		return search;
	}
	
	/**
	 * Returns WindowsVersion for current machine
	 * @return
	 */
	public static WindowsVersion getFromString() {
		return getFromString(System.getProperty("os.name"));
	}
	
	/**
	 * Gets WindowsVersion from string
	 * @param search Can only be strings like "windows 8", not version number
	 * @return
	 */
	public static WindowsVersion getFromString(String search) {
		for (WindowsVersion v : WindowsVersion.values()) {
			if (v.getSearch().toLowerCase().contains(search.toLowerCase())) {
				return v;
			}
		}
		
		return null;
	}


}
