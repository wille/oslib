package com.redpois0n.oslib.bsd;

import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class BSDOperatingSystem extends UnixOperatingSystem {

	private Flavor flavor;
	
	public BSDOperatingSystem(Flavor flavor) {
		super(OperatingSystem.BSD);
		this.flavor = flavor;
	}
	
	public BSDOperatingSystem() {
		this(Flavor.getLocalFlavor());
	}
	
	public Flavor getFlavor() {
		return this.flavor;
	}

	@Override
	public String getDisplayString() {
		return flavor.getName();
	}

}
