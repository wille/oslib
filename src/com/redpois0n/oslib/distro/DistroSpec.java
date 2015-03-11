package com.redpois0n.oslib.distro;

import com.redpois0n.oslib.Distro;

public class DistroSpec {
	
	private Distro d;
	private String release;
	private String codename;
	
	public DistroSpec(Distro d) {
		this.d = d;
	}
	
	public Distro getDistro() {
		return d;
	}
	
	public String getCodename() {
		return this.codename;
	}
	
	public void setCodename(String codename) {
		this.codename = codename;
	}
	
	public String getRelease() {
		return this.release;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}

}
