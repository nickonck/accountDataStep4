package com.companyname.springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTests {

	private Product product;
	
	@Before
	public void setUp() throws Exception {
		product = new Product();
	}

	@Test
	public void testSetAndGetDescription() {
		String description = "Description";
		assertNull(product.getDescription());
		product.setDescription(description);
		assertEquals(description, product.getDescription());
	}

	@Test
	public void testSetAndGetPrice() {
		double price = 100.0;
		product.setPrice(price);
		assertEquals(price, product.getPrice(), 0);
	}

	@Test
	public void testToString() {
		double price = 100.0;
		String description = "Description";
		product.setDescription(description);
		product.setPrice(price);
		assertEquals(product.toString().compareTo("Description: " + description + ";Price: " + price),0);
	}

}
