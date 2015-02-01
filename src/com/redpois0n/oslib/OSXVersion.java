package com.redpois0n.oslib;

public enum OSXVersion {
	
	CHEETAH("cheetah", "10.0"),
	PUMA("puma", "10.1"),
	JAGUAR("jaguar", "10.2"),
	PANTHER("panther", "10.3"),
	TIGER("tiger", "10.4"),
	LEOPARD("leopard", "10.5"),
	SNOW_LEOPARD("snow leopard", "10.6"),
	LION("lion", "10.7"),
	MOUNTAIN_LION("mountain lion", "10.8"),
	MAVERICKS("mavericks", "10.9"),
	YOSEMITE("yosemite", "10.10");
	
	private String search;
	private String version;
	
	private OSXVersion(String search, String version) {
		this.search = search;
		this.version = version;
	}

	/**
	 * Version of OS X, such as 10.10
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Version display name, such as Yosemite
	 * @return
	 */
	public String getSearch() {
		return search;
	}
	
	/**
	 * Gets OSXVersion from string
	 * @param search Can either be version or display name ("10.10", "yosemite")
	 * @return
	 */
	public static OSXVersion getFromString(String search) {
		for (OSXVersion v : OSXVersion.values()) {
			if (v.getVersion().equalsIgnoreCase(search) || v.getSearch().equalsIgnoreCase(search)) {
				return v;
			}
		}
		
		return null;
	}

}
