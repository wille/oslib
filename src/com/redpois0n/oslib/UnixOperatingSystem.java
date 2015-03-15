package com.redpois0n.oslib;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public abstract class UnixOperatingSystem extends AbstractOperatingSystem {

	private String detailed;
	
	public UnixOperatingSystem(OperatingSystem os) {
		super(os);
	}

	@Override
	public String getDetailedString() {
		return detailed == null ? getDisplayString() : detailed;
	}
	
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

}
