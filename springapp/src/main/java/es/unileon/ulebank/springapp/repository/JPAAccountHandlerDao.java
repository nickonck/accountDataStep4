package es.unileon.ulebank.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;

@Repository("accountHandlerDao")
public class JPAAccountHandlerDao implements AccountHandlerDao{

	private EntityManager em=null;

	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<AccountHandler> getAccountHandlerList() {
		return em.createQuery("select p from AccountHandler p order b p.id").getResultList();
	}

	@Transactional(readOnly = false)
	public void saveAccountHandler(AccountHandler account) {
		em.merge(account);
	}

}
