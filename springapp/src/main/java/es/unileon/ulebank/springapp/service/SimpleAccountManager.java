package es.unileon.ulebank.springapp.service;

import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;

public class SimpleAccountManager implements AccountManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Account account;

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account){
		this.account=account;
	}

	@Override
	public void addTitular(Client titular) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTitular(Handler clientHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAuthorized(Client authorized) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAuthorized(Handler clientHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeOverdraft(double overdraft) {
		// TODO Auto-generated method stub
		
	}
	

}
