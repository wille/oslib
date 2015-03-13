package com.redpois0n.oslib.bsd;

import com.redpois0n.oslib.AbstractOperatingSystem;
import com.redpois0n.oslib.OperatingSystem;

public class BSDOperatingSystem extends AbstractOperatingSystem {

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

}
