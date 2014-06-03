package es.unileon.ulebank.springapp.repository;

import java.util.List;

import es.unileon.ulebank.account.Account;


public class InMemoryAccountDao implements AccountDao {

    private List<Account> accountList;

    public InMemoryAccountDao(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void saveAccount(Account account) {
    }

}