package com.assingment.shopping;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void testCreateShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertNotNull(shoppingCart);
	}
	
	@Test
	public void testEmptyShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		List<Product> items = shoppingCart.getItems();
		assertTrue(items.isEmpty());
	}
	
	@Test
	public void testAddItem() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItems(Arrays.asList(new String[] {"Apple"}));
		List<Product> items = shoppingCart.getItems();
		assertEquals(1, items.size());
		assertEquals("Apple", items.get(0).getName());
	}
	
	@Test
	public void testAddMultipleItems() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItems(Arrays.asList(new String[] {"Apple", "Orange", "Apple"}));
		List<Product> items = shoppingCart.getItems();
		assertEquals(3, items.size());
	}
	
	@Test
	public void testEmptyItemsPrice() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertFalse(shoppingCart.checkout() > 0);
	}
	
	@Test
	public void testMultipleItemsPrice() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItems(Arrays.asList(new String[] {"Apple", "Apple", "Orange", "Apple"}));
		assertEquals("2.05", String.valueOf(shoppingCart.checkout()));
	}

}
