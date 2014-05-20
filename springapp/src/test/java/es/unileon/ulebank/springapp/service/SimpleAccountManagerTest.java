package es.unileon.ulebank.springapp.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.client.Client;

public class SimpleAccountManagerTest {

	private SimpleAccountManager accountManager;
	
	private Account myAccount;
	private Client client1;
	private Client client2;
	private Client client3;
	
	private static String DNI_1="67954765K";
	private static String DNI_2="09845764E";
	
	private static String ACCOUNT_NUMBER="98765432";
	private static String BANK_NUMBER="2098";
	private static String OFFICE_NUMBER="9876";
	private static String DC_NUMBER="14";
	
	@Before
	public void setUp() throws Exception {
		accountManager = new SimpleAccountManager();
		myAccount= new Account();
		AccountHandler handler=new AccountHandler();
		handler.setAccountNumber(ACCOUNT_NUMBER);
		handler.setBank(BANK_NUMBER);
		handler.setDc(DC_NUMBER);
		handler.setOffice(OFFICE_NUMBER);
		myAccount.setId(handler);
		
		accountManager.setAccount(myAccount);
		
		client1=new Client();
		client1.setDni(DNI_1);
		client1.setName("pepito");
		
		client2= new Client();
		client2.setDni(DNI_2);
		client2.setName("jaimito");
		
		client3= new Client();
		client3.setDni(DNI_1);
		client3.setName("luisito");
	}

	@Test
	public void testGetAndSetAccount() {
		accountManager= new SimpleAccountManager();
		accountManager.setAccount(myAccount);
		assertNotNull(accountManager.getAccount());
	}

	@Test
	public void testAddTitular() {
		accountManager.addTitular(client1);
		assertTrue(accountManager.getAccount().existsTitular(DNI_1));
		accountManager.addTitular(client3);
		assertEquals(accountManager.getAccount().titularsSize(),1);
	}

	@Test
	public void testRemoveTitular() {
		accountManager.addTitular(client1);
		assertFalse(accountManager.removeTitular(DNI_1));
		accountManager.addTitular(client2);
		assertTrue(accountManager.removeTitular(DNI_2));
	}

	@Test
	public void testAddAuthorized() {
		accountManager.addAuthorized(client1);
		assertTrue(accountManager.getAccount().existsAuthorized(DNI_1));
		accountManager.addAuthorized(client3);
		assertEquals(accountManager.getAccount().authorizedSize(),1);
	}

	@Test
	public void testRemoveAuthorized() {
		accountManager.addAuthorized(client1);
		accountManager.addAuthorized(client2);
		assertTrue(accountManager.removeAuthorized(DNI_1));
		assertTrue(accountManager.removeAuthorized(DNI_2));
	}

	@Test
	public void testChangeOverdraft() {
		accountManager.changeOverdraft(100.0);
		assertTrue(accountManager.getAccount().getMaxOverdraft()==100.0);
	}

}
