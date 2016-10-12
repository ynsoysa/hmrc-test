package com.assingment.shopping;

import java.util.ArrayList;
import java.util.List;

import com.assingment.shopping.offer.BuyOneGetOneFreeOffer;
import com.assingment.shopping.offer.Offer;

public class ShoppingCart {
	
	List<Product> allProducts;
	List<Product> items = new ArrayList<>();
	List<Offer> offers = new ArrayList<>();

	public ShoppingCart() {
		allProducts = new ArrayList<>();
		allProducts.add(new Product("Apple", 0.6));
		allProducts.add(new Product("Orange", 0.25));
		
		//add all offers to apply
		offers.add(new BuyOneGetOneFreeOffer());
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
		for (Offer offer : offers) {
			total -= offer.applyOffer(items);
		}
		System.out.println(String.format("Total amount of the cart is : %4.2f", total));
		return total;
	}

}
