package com.test.autopractice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 
public class ReadConfigProperties   {
	
	// ReadConfigFromExcel implement IReader
	
	private   Properties properties;
	private static ReadConfigProperties instance;
	private ReadConfigProperties(String fileName) {
		initPropertiesFile(fileName);
	}
	public static ReadConfigProperties getInstance() {
		if (instance == null) {
			instance=new ReadConfigProperties("");
		}
		
		return instance; 

		

	}
	public static ReadConfigProperties getInstance(String fileName) {
		
		if (instance == null) {
			instance=new ReadConfigProperties(fileName );
		}
	 
		return instance; 
	}
	
	private void  initPropertiesFile(String fileName) {
		if(isDefaultPropertiesFile(fileName)){
			properties = getDataFromProperties("configs//config.properties");
		}else{
			properties = getDataFromProperties(fileName);
		}
		
	}
	

	private Properties getDataFromProperties(String fileName) {
 		Properties prop = new Properties();
		
		try {
			InputStream stream = new FileInputStream(new File(fileName));
			prop.load(stream);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return prop;
	}

	private boolean isDefaultPropertiesFile(String fileName) {
		if("".equalsIgnoreCase(fileName))
			return true;
		return false;
	}

 
	public String getApplicationUrl() {
		return properties.getProperty("ApplicationUrl").toString();
	}
 
 
	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("ExplicitWait"));
	}

 
 


}