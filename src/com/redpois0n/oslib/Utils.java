package com.redpois0n.oslib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static Map<String, String> mapFile(File file, String delimiter) throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		
		while ((line = reader.readLine()) != null) {
			String[] split = line.split(delimiter);
			String key = split[0].trim();
			String value = split[1].trim();
			map.put(key, value);
		}
		
		reader.close();

		return map;
	}

}
