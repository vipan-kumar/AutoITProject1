package utils;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;

public class JSONReader {
	
	public Object readJson(String filePath)
	{
		Object obj=null;
		JSONParser jsonParser = new JSONParser();
		try
		{
			FileReader fileReader = new FileReader(filePath);
			obj = jsonParser.parse(fileReader);
		}
		catch(Exception e)
		{
			System.out.println("Exception in utils/JSONReader class: "+ e.getMessage());
		}
		return obj;
	}

}
