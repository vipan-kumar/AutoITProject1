/*****************************************************************************************************
 * SPIRA-TEST TC Id : TC-1234
 * AUTHOR			: Vipan Kumar
 * LAST UPDATED ON  : 12-May-2022
 * LAST UPDATED BY  : Praveen Bhaskar
 * REASON OF THE UPDATE : 
 * DESCRIPTION		: Below code contains logic to write data to notepad file
 * 					  each method calls a method from page object model class
 *****************************************************************************************************/


package testCases;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pageObjects.LandingPage;
import utils.JSONReader;
import utils.AllureListener;

@Listeners({AllureListener.class})
public class TC_001_WriteToNotepadTest extends BaseClass{	
	
	@Test(dataProvider = "tc001_step1_dp")
	@Description("Notepad Test.........")
	public void tc_001_runner(String title, String bodyLine1, String bodyLine2, String bodyLine3,String end)
	{
		//creating object of page factory class
		LandingPage lp= new LandingPage(autoIt);
		
		//step 1- opening notepad
		openNotepad(lp,appName);
		logger.info("Notepad opened successfully--log4j2LOG");
		
		//step 2- write test data to notepad
		String testData[] = {title,bodyLine1,bodyLine2,bodyLine3,end};
		writeDataToNotepad(lp,testData);
		
		//save notepad file
		saveNotepadFile(lp);
	}
	@Step("Step 1 - Open Notepad")
	public void openNotepad(LandingPage lp, String appName)
	{
		lp.openNotepad(appName);
	}
	@Step("Step 2 - Write data to notepad")
	public void writeDataToNotepad(LandingPage lp, String testData[])
	{
		for (int i=0;i<testData.length;i++)
		{
			String arrayContent = (String)testData[i];
			lp.writeTextToNotepad(arrayContent);
		}
		Assert.assertTrue(true);
	}
	@Step("Step 3 - Save notepad file")
	public void saveNotepadFile(LandingPage lp)
	{
		lp.saveDocument();
	}
	
	
	//Data provider method(s) should be written here
	@DataProvider(name = "tc001_step1_dp")
	public Iterator<Object[]> tc001_step1_dp()
	{
		ArrayList<Object[]> testData = new ArrayList<Object[]>();
		try {
			String tdFilePath = ".\\src\\test\\java\\testData\\TC_001_S1_TestData.json";
			JSONReader jsonReader = new JSONReader();
			//Calling Json Reader class to read test data fro json file
			Object objTc001s1= jsonReader.readJson(tdFilePath);
			JSONObject jObjTc001s1 = (JSONObject)objTc001s1;
			//getting element values from json file
			String title = (String) jObjTc001s1.get("title");
			String bodyLine1 = (String) jObjTc001s1.get("bodyLine1");
			String bodyLine2 = (String) jObjTc001s1.get("bodyLine2");
			String bodyLine3 = (String) jObjTc001s1.get("bodyLine3");
			String end = (String) jObjTc001s1.get("end");
			//data will be added to Object array which will tehn be added to Arraylist, then iterator will be sent to @Test method
			Object ob[] = {title,bodyLine1,bodyLine2,bodyLine3,end};
			testData.add(ob);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in pageObjects/LandingPage.java"+e.getMessage());
		}
		return testData.iterator();	
	}
		
	
	
	/*Below @Test and dp method an be used in case a data needs to be sent in single shot
	 * 
	
	@Test(dataProvider = "tc001_step1_dp")
	public void writeDataToNotepad(String testData[])
	{
		LandingPage lp= new LandingPage(autoIt);
		lp.openNotepad(appName);
		for (int i=0;i<testData.length;i++)
		{
			String arrayContent = (String)testData[i];
			lp.writeTextToNotepad(arrayContent);
		}
	}
	
	
	//Data provider methods to be written here
	
 	@DataProvider(name = "tc001_step1_dp")
	public Object[] tc001_step1_dp()
	{
		String tdFilePath = ".\\src\\test\\java\\testData\\TC_001_S1_TestData.json";
		JSONReader jsonReader = new JSONReader();
		//Calling Json Reader class to read test data from json file
		Object objTc001s1= jsonReader.readJson(tdFilePath);
		JSONObject jObjTc001s1 = (JSONObject)objTc001s1;
		//getting element values from json file
		String title = (String) jObjTc001s1.get("title");
		String bodyline1 = (String) jObjTc001s1.get("bodyLine1");
		String bodyline2 = (String) jObjTc001s1.get("bodyLine2");
		String bodyline3 = (String) jObjTc001s1.get("bodyLine3");
		String end= (String) jObjTc001s1.get("end");
		//String testData[] = {title,bodyline1,bodyline2,bodyline3,end};
		Object ob[] = {title,bodyline1,bodyline2,bodyline3,end};
		//return testData;
		return ob;
		
	}*/

}
