package com.redpois0n.oslib;

/**
 * http://askubuntu.com/questions/72549/how-to-determine-which-window-manager-is-running/227669
 */
public enum DesktopEnvironment {
	
	KDE(Family.KDE, "kde"),
	UNITY3D(Family.UNITY, "ubuntu"),
	UNITY2D(Family.UNITY, "ubuntu-2d"),
	GNOME(Family.GNOME, "gnome-shell"),
	GNOME_CLASSIC(Family.GNOME, "gnome-classic"),
	GNOME_CLASSIC_NOEFFECTS(Family.GNOME, "gnome-fallback"),
	XFCE(Family.XFCE, "xfce"),
	CINNAMON(Family.GNOME, "cinnamon"),
	PANTHEON(Family.PANTHEON, "pantheon");
	
	private Family family;
	private String search;
	
	private DesktopEnvironment(Family family, String search) {
		this.family = family;
		this.search = search;
	}
	
	public String getSearch() {
		return search;
	}
	
	public Family getFamily() {
		return family;
	}

	public static DesktopEnvironment getFromSessionString() {
		String env = System.getenv("GDMSESSION");
		return getFromSessionString(env);
	}
	
	public static DesktopEnvironment getFromSessionString(String env) {
		for (DesktopEnvironment v : DesktopEnvironment.values()) {
			if (v.getSearch().toLowerCase().contains(env.toLowerCase())) {
				return v;
			}
		}
		
		return null;
	}
	
	public static DesktopEnvironment getFromCurrentDesktopString() {
		String env = System.getenv("XDG_CURRENT_DESKTOP");
		return getFromCurrentDesktopString(env);
	}
	
	public static DesktopEnvironment getFromCurrentDesktopString(String env) {
		for (DesktopEnvironment v : DesktopEnvironment.values()) {
			if (v.getFamily().getSearch().toLowerCase().contains(env.toLowerCase())) {
				return v;
			}
		}
		
		return null;
	}

	public static DesktopEnvironment getFromString(String search) {
		for (DesktopEnvironment v : DesktopEnvironment.values()) {
			if (v.getFamily().getSearch().toLowerCase().contains(search.toLowerCase()) || v.getSearch().toLowerCase().contains(search.toLowerCase())) {
				return v;
			}
		}
		
		return null;
	}
	
	public static enum Family {
		
		KDE("kde"),
		UNITY("unity"),
		GNOME("gnome"),
		XFCE("xfce"),
		LXDE("lxde"),
		PANTHEON("pantheon");
		
		private String search;
		
		private Family(String search) {
			this.search = search;
		}
		
		public String getSearch() {
			return search;
		}
	}
}
