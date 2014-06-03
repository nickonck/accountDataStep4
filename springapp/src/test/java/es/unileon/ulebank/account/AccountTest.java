package es.unileon.ulebank.account;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.client.Client;

public class AccountTest {

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
		myAccount= new Account();
		AccountHandler handler=new AccountHandler();
		handler.setAccountNumber(ACCOUNT_NUMBER);
		handler.setBank(BANK_NUMBER);
		handler.setDc(DC_NUMBER);
		handler.setOffice(OFFICE_NUMBER);
		myAccount.setAccountHandler(handler);
		
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
	public void testAccount() {
		Account account=null;
		account = new Account();
		assertNotNull(account);
	}

	@Test
	public void testSetMaxOverdraft() {
		myAccount.setMaxOverdraft(100);
		assertTrue(myAccount.getMaxOverdraft()==100.0);
		myAccount.setMaxOverdraft(-1);
		assertFalse(myAccount.getMaxOverdraft()==-1);
		myAccount.setMaxOverdraft(0);
		assertTrue(myAccount.getMaxOverdraft()==0);
	}

	@Test
	public void testAddTitular() {
		
		
		myAccount.addTitular(client1);
		assertTrue(myAccount.existsTitular(DNI_1));
		assertEquals(myAccount.titularsSize(),1);
		
		myAccount.addTitular(client2);
		assertTrue(myAccount.existsTitular(DNI_2));
		assertEquals(myAccount.titularsSize(),2);
		
		myAccount.addTitular(client3);
		assertEquals(myAccount.titularsSize(),2);
	}

	@Test
	public void testSetTitulars() {
		List<Client> clients= new ArrayList<Client>();
		clients.add(client1);
		clients.add(client2);
		myAccount.setTitulars(clients);
		assertTrue(myAccount.existsTitular(DNI_1));
		assertTrue(myAccount.existsTitular(DNI_2));
		assertEquals(myAccount.titularsSize(),2);
	}

	@Test
	public void testDeleteTitular() {
		List<Client> clients= new ArrayList<Client>();
		clients.add(client1);
		clients.add(client2);
		myAccount.setTitulars(clients);
		assertTrue(myAccount.deleteTitular(DNI_1));
		assertFalse(myAccount.existsTitular(DNI_1));
		assertFalse(myAccount.deleteTitular(DNI_2));
		assertTrue(myAccount.existsTitular(DNI_2));
		assertFalse(myAccount.deleteTitular(DNI_1));
		
	}

	@Test
	public void testGetBalance() {
		assertTrue(myAccount.getBalance()==0.0);
	}

	@Test
	public void testGetMaxOverdraft() {
		assertTrue(myAccount.getMaxOverdraft()==0.0);
		myAccount.setMaxOverdraft(100);
		assertTrue(myAccount.getMaxOverdraft()==100.0);
	}

	@Test
	public void testGetId() {
		assertEquals(myAccount.getAccountHandler().toString().compareTo(BANK_NUMBER+"-"+OFFICE_NUMBER+"-"+DC_NUMBER+"-"+ACCOUNT_NUMBER),0);
	}

}
