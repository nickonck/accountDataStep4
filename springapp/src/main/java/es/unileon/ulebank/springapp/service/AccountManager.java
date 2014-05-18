package es.unileon.ulebank.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.account.Account;

public interface AccountManager extends Serializable{
	
	public void increasePrice(int percentage);
	
	public List<Account> getProducts();

}
