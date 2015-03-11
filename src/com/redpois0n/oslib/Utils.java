package com.redpois0n.oslib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<String> readProcess(String[] args) throws Exception {
		List<String> raw = new ArrayList<String>();
		
		Process p = Runtime.getRuntime().exec(args);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		
		while ((line = reader.readLine()) != null) {
			raw.add(line);
		}
		
		reader.close();
		
		return raw;
	}

}
