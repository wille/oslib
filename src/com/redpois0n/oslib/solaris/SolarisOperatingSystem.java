package com.redpois0n.oslib.solaris;

import java.io.Serializable;

import com.redpois0n.oslib.Arch;
import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class SolarisOperatingSystem extends UnixOperatingSystem implements Serializable {
	
	private static final long serialVersionUID = -9050140134144959153L;

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
