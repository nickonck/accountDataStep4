package es.unileon.ulebank.springapp.repository;

import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;

public interface ClientDao {

	public List<Client> getClientList();
	
	public void saveClient(Client client);

	void removeClient(Client client);
}
