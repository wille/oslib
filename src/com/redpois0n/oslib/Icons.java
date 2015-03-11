package com.redpois0n.oslib;

import java.io.File;
import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Icons {
	
	public static Icon getIcon() {
		return getIcon(OperatingSystem.getOperatingSystem(), OperatingSystem.getLongOperatingSystem());
	}
	
	@SuppressWarnings("deprecation")
	public static Icon getIcon(OperatingSystem os, String longs) {
		String icon = getIconString(os, longs);
		
		try {
			return new ImageIcon(new File("icons/" + icon + ".png").toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getIconString() {
		return getIconString(OperatingSystem.getOperatingSystem(), OperatingSystem.getLongOperatingSystem());
	}
	
	public static String getIconString(OperatingSystem os, String longs) {
		String icon;
		
		if (os == OperatingSystem.WINDOWS) {
			if (longs.startsWith("Windows 8")) {
				icon = "os_win8";
			} else if (longs.startsWith("Windows XP")) {
				icon = "os_winxp";
			} else if (longs.startsWith("Windows 200")) {
				icon = "os_win2000";
			} else {
				icon = "os_win";
			}
		} else if (os == OperatingSystem.LINUX) {
			Distro d = Distro.getDistro(longs);
			if (d == null || d != null && d == Distro.UNKNOWN) {
				icon = "os_linux";
			} else {
				icon = "dist_" + d.getSearchTypes().replace(" ", "");
			}
		} else if (os == null){
			icon = "os_unknown";
		} else {
			icon = "os_" + os.getPrimarySearch();
		}
		
		return icon;
	}
	
	public static String getIconFromStringOnly(String longs) {
		OperatingSystem os = null;
		
		for (OperatingSystem o : OperatingSystem.values()) {
			if (os != null) {
				break;
			}
			for (String s : o.getSearch()) {
				if (longs.toLowerCase().contains(s)) {
					os = o;
					break;
				}
			}
		}
		
		return getIconString(os, longs);
	}

}
