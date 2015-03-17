package com.redpois0n.oslib.osx;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class OSXOperatingSystem extends UnixOperatingSystem {

	private OSXVersion version;
	
	public OSXOperatingSystem() {
		this(OSXVersion.getFromString());
	}
	
	public OSXOperatingSystem(OSXVersion version, Arch arch) {
		super(OperatingSystem.OSX, arch);
		this.version = version;
	}
	
	public OSXOperatingSystem(OSXVersion version) {
		this(version, Arch.getArch());
	}
	
	public void setVersion(OSXVersion version) {
		this.version = version;
	}

	public OSXVersion getVersion() {
		return this.version;
	}

	@Override
	public String getDisplayString() {
		return "Mac OS X " + version.getDisplay() + " " + version.getVersion();
	}

	@Override
	public String getDetailedString() {
		return "Mac OS X " + version.getDisplay() + " " + version.getVersion();
	}

}
