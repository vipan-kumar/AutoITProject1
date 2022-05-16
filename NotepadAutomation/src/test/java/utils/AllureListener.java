package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	//Method to take screenshot
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot(byte[] screenShot) {
	    return screenShot;
	}
	
	//Method to write text for screenshot
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
	    return message;
	}
	
	//Implementing the ITestListner interface methods
	
	@Override
	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		System.out.println("::::::::: Starting Test: "+iTestContext.getName()+" :::::::::");
	}
	

	@Override
	public void onFinish(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		System.out.println("::::::::: Finishing Test: "+iTestContext.getName()+" :::::::::");
	}
	
	@Override
	public void onTestStart(ITestResult iTestResult)
	{
		System.out.println("::::::::: Starting method "+iTestResult.getName()+" :::::::::");
	}
	
	@Override
	public void onTestSuccess(ITestResult iTestResult)
	{
		System.out.println("::::::::: Method "+iTestResult.getName()+" executed successfully :::::::::");
	}
	
	@Override
	public void onTestFailure(ITestResult iTestResult)
	{
		System.out.println("::::::::: Method "+iTestResult.getName()+" got failed :::::::::");
		
		//Take allure screenshot
		saveScreenshot(null);
		
		//Add message log
		saveTextLog(getTestMethodName(iTestResult) + "failed and screenshot is taken");
	}
	
	@Override
	public void onTestSkipped(ITestResult iTestResult)
	{
		System.out.println("::::::::: Method "+iTestResult.getName()+" is skipped :::::::::");
	}
	
}
