package es.unileon.ulebank.springapp.service;


import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;

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
		account.addTitular(titular);
		
	}

	@Override
	public boolean removeTitular(String clientDni) {
		return account.deleteTitular(clientDni);
		
	}

	@Override
	public void addAuthorized(Client authorized) {
		account.addAuthorized(authorized);
	}

	@Override
	public boolean removeAuthorized(String clientDni) {
		return account.deleteAuthorized(clientDni);
		
	}

	@Override
	public void changeOverdraft(double overdraft) {
		account.setMaxOverdraft(overdraft);		
	}
	

}
