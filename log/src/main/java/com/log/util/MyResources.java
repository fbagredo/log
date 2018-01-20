package com.log.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MyResources {
	
	static ResourceBundle rb = ResourceBundle.getBundle("com.log.util.log");

	public static HashMap<String,String> getProperties() {
		
		HashMap<String,String> properties = new HashMap<String,String> ();
		Enumeration<String> keys = rb.getKeys();
        
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			properties.put(key, value);
		}
		return properties;

	}
}