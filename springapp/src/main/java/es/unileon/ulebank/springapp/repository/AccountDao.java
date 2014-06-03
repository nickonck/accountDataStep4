package es.unileon.ulebank.springapp.repository;

import java.util.List;

import es.unileon.ulebank.account.Account;

public interface AccountDao {

	public List<Account> getAccountList();
	
	public void saveAccount(Account account);
}
