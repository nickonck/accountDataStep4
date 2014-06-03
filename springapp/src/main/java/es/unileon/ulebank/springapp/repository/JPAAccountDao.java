package es.unileon.ulebank.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.account.Account;

@Repository(value = "accountDao")
public class JPAAccountDao implements AccountDao{
	
	private EntityManager em=null;

	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Account> getAccountList() {
		return em.createQuery("select p from Account p order b p.id").getResultList();
	}

	@Transactional(readOnly = false)
	public void saveAccount(Account account) {
		em.merge(account);
	}

}
