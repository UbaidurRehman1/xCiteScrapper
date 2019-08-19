package com.ubaid.app;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ubaid.app.xcite.scrapper.Scrapper;
import com.ubaid.app.xcite.urls.FileUtils;
import com.ubaid.app.xcite.urls.URLScrapper;


@SpringBootApplication
public class XciteScrapperApplication implements CommandLineRunner
{

	public static void main(String[] args)
	{
		SpringApplication.run(XciteScrapperApplication.class, args);		
	}

	@Bean
	public Scrapper getScrapper()
	{
		return new Scrapper();
	}
	
	@Bean
	public FileUtils getFileUtils()
	{
		return new FileUtils();
	}
	
	@Bean
	public URLScrapper getURLScrapper()
	{
		return new URLScrapper();
	}
	

	@Override
	public void run(String... args) throws Exception
	{
		Scrapper scrapper = getScrapper();
		scrapper.scrape("https://www.xcite.com.sa/computers-tablets/tablets.html");
	}
	
	@SuppressWarnings("unused")
	private String getFilePath()
	{
		File file = new File("extracted/urls.txt");
		file.delete();
		try
		{
			if(file.createNewFile())
			{
				System.out.println("[INFO]: File Created");
			}
		}
		catch (IOException e)
		{
			System.out.println("[Error]: " + e.getMessage());
		}
		
		String path = file.getAbsolutePath();
		
		return path;
	}
}
