package es.unileon.ulebank.springapp.service;

import java.io.Serializable;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;

public interface AccountManager extends Serializable{
	
	public Account getAccount();
	
	public void addTitular(Client titular);
	
	public boolean removeTitular(String clientDni);
	
	public void changeOverdraft(double newOverdraft);
}
