package es.unileon.ulebank.springapp.service;

import java.util.List;

import es.unileon.ulebank.account.Account;

public class SimpleAccountManager implements AccountManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Account> products;

	public void increasePrice(int percentage) {
		if(products != null){
			for (Account product : products){
				//double newPrice = product.getPrice().doubleValue() * (100 + percentage)/100;
				//product.setPrice(newPrice);
			}
		}
	}

	public List<Account> getProducts() {
		return products;
	}
	
	public void setProducts(List<Account> products){
		this.products=products;
	}

}
