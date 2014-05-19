package es.unileon.ulebank.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;

public interface AccountManager extends Serializable{
	
	public Account getAccount();
	
	public void addTitular(Client titular);
	
	public void removeTitular(Handler clientHandler);
	
	public void addAuthorized(Client authorized);
	
	public void removeAuthorized(Handler clientHandler);
	
	public void changeOverdraft(double overdraft);
	
}
