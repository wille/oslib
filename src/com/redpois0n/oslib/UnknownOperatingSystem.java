package com.redpois0n.oslib;

public class UnknownOperatingSystem extends AbstractOperatingSystem {
	
	public UnknownOperatingSystem() {
		super(OperatingSystem.UNKNOWN);
	}
	
	@Override
	public String getDisplayString() {
		return "Unknown";
	}

	@Override
	public String getDetailedString() {
		return "Unknown";
	}

}
