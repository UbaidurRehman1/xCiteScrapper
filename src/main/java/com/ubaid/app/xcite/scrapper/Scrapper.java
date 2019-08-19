package com.ubaid.app.xcite.scrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubaid.app.xcite.entity.Product;

@Component
public class Scrapper
{
	private Product previousProduct = null;

	@Autowired
	private ScrapperService service;
	private Random random = new Random();
	private boolean flag = false;
	
	public List<Product> scrape(String url)
	{
		List<Product> products = new LinkedList<Product>();
		
		for(int i = 1; i < 200; i++)
		{
			url = url + "?p=" + i;
			products.addAll(getProducts(url));
			if(flag)
				break;
		}
		flag = false;
		
		return products;
	}
	
	private List<Product> getProducts(String url)
	{
		
		List<Product> products = new LinkedList<Product>();
		
		try
		{
			Document document = Jsoup.connect(url).get();
			
			Thread.sleep(random.nextInt(2000));
			
			//all divs of product
			Elements elements = document.select("div.products-grid > div");
			
			for(Element element : elements)
			{
				Product product = service.getProduct(element);
				product.setType(getType(url));
				products.add(product);
				if(product.equals(previousProduct))
					flag = true;
				previousProduct = product;
			}
		}
		catch(Exception exp)
		{
			System.out.println("[Error]: [" + getClass().getSimpleName() +  "]: " + exp.getMessage());
		}
		
		return products;
	}
		
	
	private String getType(String url)
	{
		String[] fragments = url.split("/");
		String type  = fragments[fragments.length - 1];
		type = type.replace(".html", "");
		return type;
	}
}
