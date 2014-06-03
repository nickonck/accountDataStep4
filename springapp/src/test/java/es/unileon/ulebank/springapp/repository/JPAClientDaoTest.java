package es.unileon.ulebank.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.client.Client;

public class JPAClientDaoTest {
	
	private ApplicationContext context;
	private ClientDao clientDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		clientDao = (ClientDao) context.getBean("clientDao");
	}

	@Test
	public void testGetProductList() {
		List<Client> clients = clientDao.getClientList();
		assertEquals(clients.size(), 1, 0);
	}
	
	@Test
	public void testSaveProduct() {
		List<Client> clients = clientDao.getClientList();

        Client p = clients.get(0);
        String dc = p.getName();
        p.setName("Diego");
        clientDao.saveClient(p);

        List<Client> updatedClients = clientDao.getClientList();
        Client p2 = updatedClients.get(0);
        assertEquals(p2.getName().compareTo("Diego"),0);

        p2.setName(dc);
        clientDao.saveClient(p2);
	}

}
