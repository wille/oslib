package com.redpois0n.oslib.linux;

import com.redpois0n.oslib.Utils;

public class CommandExistsType extends SearchType {
	
	private String cmd;
	
	public CommandExistsType(String cmd) {
		this.cmd = cmd;
	}

	@Override
	public boolean detect() {		
		try {
			Utils.readProcess(new String[] { cmd });
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

}
