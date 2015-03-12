package com.redpois0n.oslib;

import com.redpois0n.oslib.linux.DistroDetector;
import com.redpois0n.oslib.linux.DistroSpec;

public class Debug {
	
	public static void main(String[] args) {
		DistroSpec ds = DistroDetector.detect();
		
		System.out.println(ds.getDistro().name());
		System.out.println(ds.getDistro().getName());
		System.out.println(ds.getCodename());
		System.out.println(ds.getRelease());
	}

}
