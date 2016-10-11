package com.assingment.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	List<Product> allProducts;
	List<Product> items = new ArrayList<>();

	public ShoppingCart() {
		allProducts = new ArrayList<>();
		allProducts.add(new Product("Apple", 0.6));
		allProducts.add(new Product("Orange", 0.25));
	}

	public List<Product> getItems() {
		return items;
	}

	public void addItems(List<String> itemList) {
		for (String item : itemList) {
			items.add(allProducts.stream().filter(p -> p.getName().equalsIgnoreCase(item)).findFirst().get());
		}
		
	}

	public double checkout() {
		double total = items.stream().mapToDouble(p -> p.getPrice()).sum();
		System.out.println(String.format("Total amount of the cart is : %4.2f", total));
		return total;
	}

}
