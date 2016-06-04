package oslib.linux;

import java.util.List;

import oslib.Utils;

public class CommandContainsType extends SearchType {
	
	private String[] cmd;
	private String needle;
	
	public CommandContainsType(String[] cmd, String needle) {
		this.cmd = cmd;
		this.needle = needle;
	}

	@Override
	public boolean detect() {		
		try {
			List<String> raw = Utils.readProcess(cmd);
				
			for (String line : raw) {
				if (line.toLowerCase().contains(needle.toLowerCase())) {
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

}
