package com.redpois0n.oslib.osx;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public class OSXOperatingSystem extends AbstractOperatingSystem {

	private OSXVersion version;
	
	public OSXOperatingSystem() {
		this(OSXVersion.getFromString());
	}
	
	public OSXOperatingSystem(OSXVersion version) {
		super(OperatingSystem.OSX);
		this.version = version;
	}
	
	public void setVersion(OSXVersion version) {
		this.version = version;
	}

	public OSXVersion getVersion() {
		return this.version;
	}

	@Override
	public String getDisplayString() {
		return "Mac OS X " + version.getDisplay();
	}

	@Override
	public String getDetailedString() {
		return "Mac OS X " + version.getDisplay() + " " + version.getVersion();
	}

}
