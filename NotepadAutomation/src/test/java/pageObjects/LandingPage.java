package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import autoitx4java.AutoItX;

public class LandingPage {
	
	AutoItX autoIt;
	
	//Constructor
	public LandingPage(AutoItX autoIt)
	{
		this.autoIt = autoIt;
	}
	
	//Declare elements of the page
	//private String notepadHandler;
	//private String nWinHandler = "[CLASS:Notepad]";
	private String ttl_NotepadWinTitle="Untitled - Notepad";
	private String ttl_SaveDialogTitle="Save As";
	private String txtArea_EditBoxControl="[CLASS:Edit; INSTANCE:1]";
	private String btn_SaveButton = "[CLASS:Button;INSTANCE:2]";
	
	//Implement methods to perform the actions
	
	public void openNotepad(String appName)
	{
		autoIt.run(appName,"",3);
		//notepadHandler = autoIt.winGetHandle(nWinHandler);
	}
	
	public void writeTextToNotepad(String content)
	{
		autoIt.winActivate(ttl_NotepadWinTitle);
		autoIt.winWaitActive(ttl_NotepadWinTitle);
		autoIt.ControlSetText(ttl_NotepadWinTitle, "", txtArea_EditBoxControl, content);
		//autoIt.send("{ENTER}");
	}
	
	public void saveDocument()
	{
		autoIt.winActivate(ttl_NotepadWinTitle);
		autoIt.send("^s",false);
		autoIt.winWaitActive(ttl_SaveDialogTitle);
		String filename = generateFileName();
		autoIt.ControlSetText(ttl_SaveDialogTitle, "", txtArea_EditBoxControl, filename);
		autoIt.controlClick(ttl_SaveDialogTitle, "", btn_SaveButton);
		autoIt.winWaitActive(filename);
		autoIt.winClose(filename);
	}
	
	//method to generate new file name each time
	public String generateFileName()
	{
		String filename = null;
		String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		filename="AutomationFile"+fileSuffix;
		return filename;
	}
	
	public void SonarTest() {
		System.out.println("This should appear in sonar failure");
	}

}
