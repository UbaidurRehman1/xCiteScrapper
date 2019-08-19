package com.ubaid.app.xcite.urls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class URLScrapper
{
	
	private static final String BASE_URL = "https://www.xcite.com.sa/";
	
	public List<String> getAllURLs()
	{
		Document doc = getDocument(BASE_URL);
		List<String> list = new ArrayList<String>();
		Elements elements = doc.select("li.level0 div.subs-container ul.level0 li.level1>a");
		for(Element element : elements)
		{
			list.add(element.absUrl("href"));
		}
		return list;
	}
	
	public Document getDocument(final String baseURL) 
	{
		
		Document doc = null;
		
		try
		{
			doc = Jsoup.connect(BASE_URL).get();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return doc;
	}
}
