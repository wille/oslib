package com.redpois0n.oslib;

import com.redpois0n.oslib.windows.WindowsOperatingSystem;
import com.redpois0n.oslib.windows.WindowsVersion;

public class DEDetector {

	public static DesktopEnvironment detect() {
		AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();
		
		DesktopEnvironment de = DesktopEnvironment.UNKNOWN;
		
		if (os.getType() == OperatingSystem.WINDOWS) {
			WindowsOperatingSystem wos = (WindowsOperatingSystem) os;
			
			if (wos.getVersion() == WindowsVersion.WIN7 || wos.getVersion() == WindowsVersion.WIN8 || wos.getVersion() == WindowsVersion.WIN81 || wos.getVersion() == WindowsVersion.WINSERVER2012 || wos.getVersion() == WindowsVersion.WINVISTA) {
				de = DesktopEnvironment.AERO;
			} else {
				de = DesktopEnvironment.LUNA;
			}
		} else if (os.getType() == OperatingSystem.OSX) {
			de = DesktopEnvironment.AQUA;
		} else {
			
		}
		
		return de;
	}
}
