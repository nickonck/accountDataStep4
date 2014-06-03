package es.unileon.ulebank.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.client.Client;

@Repository("clientDao")
public class JPAClientDao implements ClientDao{
	
	private EntityManager em=null;

	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Client> getClientList() {
		return em.createQuery("select p from Client p order by p.id").getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveClient(Client client) {
		em.merge(client);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void removeClient(Client client){
		em.remove(em.merge(client));
	}

}
