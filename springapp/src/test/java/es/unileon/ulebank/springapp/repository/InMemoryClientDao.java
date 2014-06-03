package es.unileon.ulebank.springapp.repository;

import java.util.ArrayList;
import java.util.List;

import es.unileon.ulebank.client.Client;

public class InMemoryClientDao implements ClientDao {
	
	List<Client> clients;
	
	public InMemoryClientDao(){
		clients = new ArrayList<Client>();
	}
	
	@Override
	public List<Client> getClientList() {
		return clients;
	}

	@Override
	public void saveClient(Client client) {
		clients.add(client);
	}

	@Override
	public void removeClient(Client client) {
		clients.remove(client);
	}

}
