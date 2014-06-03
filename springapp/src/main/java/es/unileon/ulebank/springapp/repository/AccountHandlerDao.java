package es.unileon.ulebank.springapp.repository;

import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;

public interface AccountHandlerDao {

	public List<AccountHandler> getAccountHandlerList();
	
	public void saveAccountHandler(AccountHandler account);
}
