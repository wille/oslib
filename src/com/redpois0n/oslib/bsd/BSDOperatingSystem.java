package com.redpois0n.oslib.bsd;

import java.io.Serializable;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class BSDOperatingSystem extends UnixOperatingSystem implements Serializable {

	private static final long serialVersionUID = 3409615002184682276L;
	
	private Flavor flavor;
	
	public BSDOperatingSystem(Flavor flavor, Arch arch) {
		super(OperatingSystem.BSD, arch);
		this.flavor = flavor;
	}
	
	public BSDOperatingSystem() {
		this(Flavor.getLocalFlavor(), Arch.getArch());
	}
	
	public BSDOperatingSystem(Flavor flavor) {
		this(flavor, Arch.getArch());
	}

	public Flavor getFlavor() {
		return this.flavor;
	}

	@Override
	public String getDisplayString() {
		return flavor.getName();
	}

}
