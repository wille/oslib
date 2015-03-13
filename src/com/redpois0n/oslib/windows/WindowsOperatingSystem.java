package com.redpois0n.oslib.windows;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public class WindowsOperatingSystem extends AbstractOperatingSystem {

	private WindowsVersion version;
	
	public WindowsOperatingSystem() {
		this(WindowsVersion.getFromString());
	}
	
	public WindowsOperatingSystem(WindowsVersion version) {
		super(OperatingSystem.WINDOWS);
		this.version = version;
	}
	
	public WindowsVersion getVersion() {
		return this.version;
	}

	@Override
	public String getDisplayString() {
		return version.getSearch();
	}

	@Override
	public String getDetailedString() {
		return version.getSearch();
	}

}
