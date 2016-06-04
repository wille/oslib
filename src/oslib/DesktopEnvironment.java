package oslib;

public enum DesktopEnvironment {
	
	GNOME("GNOME"),
	BUDGIE("Budgie"),
	ENLIGHTEMENT("Enlightement"),
	KDE("KDE"),
	KDE4("KDE4"),
	KDE5("KDE5"),
	MATE("Mate"),
	UNITY("Unity"),
	CINNAMON("Cinnamon"),
	LUMINA("Lumina"),
	AQUA("Aqua"),
	AERO("Aero"),
	LUNA("Luna"),
	LXDE("LXDE"),
	XFCE("XFCE"),
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
	
	public String getDisplayString() {
		String name = search;
		
		if (version != null) {
			name += " " + version;
		}
		
		return name;
	}
	
	public static DesktopEnvironment getFromString(String s) {
		for (DesktopEnvironment de : DesktopEnvironment.values()) {
			if (de.getSearch().equalsIgnoreCase(s)) {
				return de;
			}
		}
		
		return UNKNOWN;
	}
}
