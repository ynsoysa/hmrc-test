package com.assingment.shopping;

/**
 * Class for product details
 * @author Yasantha
 *
 */
public class Product {

	private String name;
	private double price;
	
	public Product() {
		super();
	}
	 
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
