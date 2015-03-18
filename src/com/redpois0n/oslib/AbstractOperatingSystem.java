package com.redpois0n.oslib;

public abstract class AbstractOperatingSystem {
	
	protected OperatingSystem type;
	protected Arch arch;

	public AbstractOperatingSystem(OperatingSystem type, Arch arch) {
		this.type = type;
		this.arch = arch;
	}
	
	public OperatingSystem getType() {
		return this.type;
	}
	
	public Arch getArch() {
		return this.arch;
	}
	
	/**
	 * Returns display string
	 * @return
	 */
	public abstract String getDisplayString();
	
	/**
	 * Returns detailed string
	 * @return
	 */
	public abstract String getDetailedString();
	
	public DesktopEnvironment getDesktopEnvironment() {
		return DEDetector.detect();
	}
}
