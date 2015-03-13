package com.redpois0n.oslib.solaris;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public class SolarisOperatingSystem extends AbstractOperatingSystem {

	public SolarisOperatingSystem() {
		super(OperatingSystem.SOLARIS);
	}

	@Override
	public String getDisplayString() {
		return "Solaris";
	}

	@Override
	public String getDetailedString() {
		return null;
	}

}
