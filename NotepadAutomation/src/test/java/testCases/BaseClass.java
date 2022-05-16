package testCases;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.jacob.com.LibraryLoader;
import autoitx4java.AutoItX;
import utils.ReadConfig;

public class BaseClass {
	
	AutoItX autoIt;
	File file;
	
	//Read config.properties file
	ReadConfig readConfig=new ReadConfig();
	public String appName=readConfig.getAppName();
	
	//Initiating Log4j2 for logging
	public static Logger logger= LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeClass
	public void setup()
	{
		logger.info("Base class logger message--log4j2LOG");
		//Load Jacob dll and instanciate AutoItx
		file = new File("lib", "jacob-1.20-x64.dll");
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		//System.out.println(LibraryLoader.JACOB_DLL_PATH);
		autoIt=new AutoItX();
	}
	
	@AfterClass
	public void tearDown()
	{
		//to close the application
		autoIt.winClose(appName);
	}
	
}
