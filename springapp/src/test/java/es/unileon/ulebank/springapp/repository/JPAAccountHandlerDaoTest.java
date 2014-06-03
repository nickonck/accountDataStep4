package es.unileon.ulebank.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;

public class JPAAccountHandlerDaoTest {
	
	private ApplicationContext context;
	private AccountHandlerDao accountHandlerDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		accountHandlerDao = (AccountHandlerDao) context.getBean("accountHandlerDao");
	}

	@Test
	public void testGetProductList() {
		List<AccountHandler> accountHandlers = accountHandlerDao.getAccountHandlerList();
		assertEquals(accountHandlers.size(), 1, 0);
	}
	
	@Test
	public void testSaveProduct() {
		
	}

}
