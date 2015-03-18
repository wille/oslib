package com.redpois0n.oslib;

/**
 * http://askubuntu.com/questions/72549/how-to-determine-which-window-manager-is-running/227669
 */
public enum DesktopEnvironment {
	
	BUDGIE("Budgie"),
	KDE("KDE"),
	KDE4("KDE4"),
	KDE5("KDE5"),
	MATE("Mate"),
	UNITY("Unity"),
	CINNAMON("Cinnamon"),
	AQUA("Aqua"),
	AERO("Aero"),
	LUNA("Luna"),
	UNKNOWN("Unknown");
	
	private String search;
	private String version;
	
	private DesktopEnvironment(String search) {
		this.search = search;
	}
	
	public String getSearch() {
		return search;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
}
