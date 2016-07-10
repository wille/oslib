package oslib.osx;

import oslib.VersionCompare;

public enum OSXVersion implements VersionCompare {
	
	CHEETAH("Cheetah", "10.0"),
	PUMA("Puma", "10.1"),
	JAGUAR("Jaguar", "10.2"),
	PANTHER("Panther", "10.3"),
	TIGER("Tiger", "10.4"),
	LEOPARD("Leopard", "10.5"),
	SNOW_LEOPARD("Snow Leopard", "10.6"),
	LION("Lion", "10.7"),
	MOUNTAIN_LION("Mountain Lion", "10.8"),
	MAVERICKS("Mavericks", "10.9"),
	YOSEMITE("Yosemite", "10.10"),
	EL_CAPITAN("El Capitan", "10.11");

	private String search;
	private String version;
	
	private OSXVersion(String search, String version) {
		this.search = search;
		this.version = version;
	}
	
	/**
	 * Returns codename, such as Yosemite
	 * @return
	 */
	public String getDisplay() {
		return search;
	}
	
	/**
	 * Version of OS X, such as 10.10
	 * @return
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * Gets OSXVersion for this machine
	 * @return
	 */
	public static OSXVersion getFromString() {
		return getFromString(System.getProperty("os.version"));
	}
	
	/**
	 * Gets OSXVersion from string
	 * Will detect "10.11.*" if parameter search is is "10.11"
	 * @param search Can either be version or display name ("10.10", "yosemite")
	 * @return
	 */
	public static OSXVersion getFromString(String search) {
		for (OSXVersion v : OSXVersion.values()) {
			if (search.startsWith(v.getVersion()) || v.getDisplay().toLowerCase().contains(search.toLowerCase())) {
				return v;
			}
		}
		
		return null;
	}
	
	public static OSXVersion getExact(String display, String version) {
		for (OSXVersion v : OSXVersion.values()) {
			if (v.getDisplay().equals(display) && v.getVersion().equals(version)) {
				return v;
			}
		}
		
		return null;
	}

	@Override
	public boolean isNewer(Enum<?> e) {
		return e.ordinal() > this.ordinal();
	}

	@Override
	public boolean isOlder(Enum<?> e) {
		return e.ordinal() < this.ordinal();
	}
}
