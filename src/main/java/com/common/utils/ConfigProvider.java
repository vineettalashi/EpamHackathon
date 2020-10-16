package com.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConfigProvider {

	private static Properties prop = new Properties();
	private static FileInputStream input;
	private final static Logger logger = LoggerFactory.getLogger(ConfigProvider.class);

	static {
		try {
			input = new FileInputStream(Constants.configFilePath);
			prop.load(input);
		} catch (IOException e) {
			logger.warn("Config.properties not found!!!!");
		}
	}
	
	public static String get(String Key) {
		
		String value=null;
		if(Key==null)
			return null;
		
		value = prop.getProperty(Key).trim();
		return value;
	}

}
