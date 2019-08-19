package com.ubaid.app.xcite.scrapper;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.ubaid.app.xcite.entity.Product;

@Service
public class ScrapperService
{
	public Product getProduct(Element element)
	{
		Element href = element.selectFirst("div.product-image-wrapper > a");
		Element img = href.selectFirst("img");
		
		String link = href.absUrl("href");
		String name = href.attr("title");
		String imageLink = img.absUrl("src");
		
		//price
		//p.querySelectorAll("div.price-box")[0].querySelectorAll("meta")[0].getAttribute("content");
		String price = element.selectFirst("div.price-box").selectFirst("meta").attr("content");

		Product product = new Product(name, link, imageLink, price, null, null);
		
		return product;
	}
}
