package com.redpois0n.oslib.solaris;

import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class SolarisOperatingSystem extends UnixOperatingSystem {
	
	public SolarisOperatingSystem() {
		super(OperatingSystem.SOLARIS);
	}

	@Override
	public String getDisplayString() {
		return "Solaris";
	}

}
