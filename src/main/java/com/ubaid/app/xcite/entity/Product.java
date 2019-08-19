package com.ubaid.app.xcite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "productLink")
	private String productLink;
	
	@Column(name = "imageLink")
	private String imageLink;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "brand")
	private String brand;

	public Product(String name, String productLink, String imageLink, String price, String type, String brand) {
		super();
		this.name = name;
		this.productLink = productLink;
		this.imageLink = imageLink;
		this.price = price;
		this.type = type;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productLink == null) ? 0 : productLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productLink == null) {
			if (other.productLink != null)
				return false;
		} else if (!productLink.equals(other.productLink))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", productLink=" + productLink + ", imageLink=" + imageLink + ", price="
				+ price + ", type=" + type + ", brand=" + brand + "]";
	}
	
	
	
	
}
