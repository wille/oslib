package oslib.windows;

import oslib.VersionCompare;

public enum WindowsVersion implements VersionCompare {
	
	UNKNOWN("Unknown Windows"),
	WIN2000("Windows 2000"),
	WINXP("Windows XP"),
	WINSERVER2003("Windows 2003"), // Note that Windows Server 2003 identifies itself only as Windows 2003
	WINVISTA("Windows Vista"),
	WINSERVER2008("Windows Server 2008"),
	WIN7("Windows 7"),
	WIN81("Windows 8.1"),
	WIN8("Windows 8"),
	WINSERVER2012("Windows Server 2012"),
	WIN10("Windows 10");
	
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
			if (v != UNKNOWN && v.getSearch().equalsIgnoreCase(search)) {
				return v;
			}
		}
		
		return UNKNOWN;
	}

	@Override
	public boolean isNewer(Enum<?> e) {
		return this.ordinal() > e.ordinal();
	}

	@Override
	public boolean isOlder(Enum<?> e) {
		return this.ordinal() < e.ordinal();
	}

}
