package com.redpois0n.oslib;

public abstract interface VersionCompare {
	
	public abstract boolean isNewer(Enum<?> e);
	public abstract boolean isOlder(Enum<?> e);

}
