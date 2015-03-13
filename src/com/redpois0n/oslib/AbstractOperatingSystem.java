package com.redpois0n.oslib;

public abstract class AbstractOperatingSystem {
	
	protected OperatingSystem type;

	public AbstractOperatingSystem(OperatingSystem type) {
		this.type = type;
	}
	
	public OperatingSystem getType() {
		return this.type;
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
}
