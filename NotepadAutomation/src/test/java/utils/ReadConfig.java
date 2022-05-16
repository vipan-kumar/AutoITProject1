package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		try
		{
			prop= new Properties();
			FileInputStream propRead= new FileInputStream("./Configs/config.properties");
			prop.load(propRead);
		}
		catch(Exception e)
		{
			System.out.println("Exception in utils/ReadConfig class: "+e.getMessage());
		}
	}
	
	//Define a method for each property written in config.properties file
	public String getAppName()
	{
		String appName=prop.getProperty("appName");
		return appName;
	}

}
