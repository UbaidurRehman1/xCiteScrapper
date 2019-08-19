package com.ubaid.app.xcite.urls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileUtils
{
	public boolean write(String path, List<String> items)
	{
		try
		{
			File file = new File(path);
			FileOutputStream outputStream = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			
			for(String url : items)
			{
				System.out.println("[Info]: [Write]: " + url);
				writer.write(url);
				writer.newLine();
			}
			
			writer.close();
		}
		catch(IOException exp)
		{
			System.out.println("[Error]: " + exp.getMessage());
		}
		
		return true;
	}
}
