package es.unileon.ulebank.springapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.springapp.repository.AccountDao;
import es.unileon.ulebank.springapp.repository.ClientDao;

@Component
public class SimpleAccountManager implements AccountManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ClientDao clientDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public Account getAccount() {
		return accountDao.getAccountList().get(0);
	}
	
	public void setAccount(Account account){
		accountDao.saveAccount(account);
	}

	@Override
	public void addTitular(Client titular) {
		titular.setAccount(accountDao.getAccountList().get(0).getId());
		accountDao.getAccountList().get(0).addTitular(titular);
		accountDao.saveAccount(accountDao.getAccountList().get(0));
		clientDao.saveClient(titular);
	}

	@Override
	public boolean removeTitular(String clientDni) {
		List<Client> clients = clientDao.getClientList();
		Client client = null;
		boolean result = false;
		int i=0;
		while(!result && i<clients.size()){
			client=clients.get(i);
			if(client.getDni().compareTo(clientDni)==0){
				result=true;
			}
			i++;
		}
		if(result){
//			accountDao.getAccountList().get(0).deleteTitular(clientDni);
//			accountDao.saveAccount(accountDao.getAccountList().get(0));
			clientDao.removeClient(client);
		}
		return result;
	}

	@Override
	public void changeOverdraft(double overdraft) {
		List<Account> list = accountDao.getAccountList();
		Account account=list.get(0);
		account.setMaxOverdraft(overdraft);
		accountDao.saveAccount(account);
	}
	

}
