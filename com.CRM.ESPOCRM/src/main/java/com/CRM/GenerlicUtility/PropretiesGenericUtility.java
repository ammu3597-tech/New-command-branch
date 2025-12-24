package com.CRM.GenerlicUtility;

import java.io.FileInputStream;

import java.util.Properties;

public class PropretiesGenericUtility {
	public String getTheDataFromProperties(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./Config Data/commondata.Properties");
		Properties ps=new Properties(); 
		ps.load(fis);
		String data=ps.getProperty(key);
		return data;
}
}