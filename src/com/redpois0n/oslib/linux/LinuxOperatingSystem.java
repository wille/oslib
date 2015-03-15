package com.redpois0n.oslib.linux;

import com.redpois0n.oslib.OperatingSystem;
import com.redpois0n.oslib.UnixOperatingSystem;

public class LinuxOperatingSystem extends UnixOperatingSystem {

	private DistroSpec ds;
	
	public LinuxOperatingSystem(DistroSpec ds) {
		super(OperatingSystem.LINUX);
		this.ds = ds;
	}
	
	public LinuxOperatingSystem() {
		this(Distro.getLocalDistroSpec());
	}
	
	public Distro getDistro() {
		return this.ds.getDistro();
	}
	
	public DistroSpec getDistroSpec() {
		return this.ds;
	}

	@Override
	public String getDisplayString() {
		Distro d = ds.getDistro();
				
		String name = d.getDisplayString();
		
		if (ds.getRelease() != null) {
			name += " " + ds.getRelease();
		}
		
		return name;
	}

}
