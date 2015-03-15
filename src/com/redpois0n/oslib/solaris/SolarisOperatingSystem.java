package com.redpois0n.oslib.solaris;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class SolarisOperatingSystem extends UnixOperatingSystem {
	
	public SolarisOperatingSystem() {
		this(Arch.getArch());
	}
	
	public SolarisOperatingSystem(Arch arch) {
		super(OperatingSystem.SOLARIS, arch);
	}

	@Override
	public String getDisplayString() {
		return "Solaris";
	}

}
