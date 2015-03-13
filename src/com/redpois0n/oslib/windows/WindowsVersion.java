package com.redpois0n.oslib.windows;

public enum WindowsVersion {
	
	UNKNOWN("Unknown Windows"),
	WIN2000("Windows 2000"),
	WINXP("Windows XP"),
	WINSERVER2003("Windows 2003"), // Note that Windows Server 2003 identifies itself only as Windows 2003
	WINVISTA("Windows Vista"),
	WINSERVER2008("Windows Server 2008"),
	WIN7("Windows 7"),
	WIN8("Windows 8"),
	WIN81("Windows 8.1"),
	WINSERVER2012("Windows Server 2012"),
	WIN10("Windows 10"); // NOT BEING DETECTED BY THE JVM! os.name returns 8.1!
	
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
			if (v != UNKNOWN && v.getSearch().toLowerCase().contains(search.toLowerCase())) {
				return v;
			}
		}
		
		return UNKNOWN;
	}


}
