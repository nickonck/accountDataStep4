package es.unileon.ulebank.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.account.Account;

public class JPAAccountDaoTest {
	
	private ApplicationContext context;
	private AccountDao accountDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		accountDao = (AccountDao) context.getBean("accountDao");
	}

	@Test
	public void testGetProductList() {
		List<Account> accounts = accountDao.getAccountList();
		assertEquals(accounts.size(), 1, 0);
	}
	
	@Test
	public void testSaveProduct() {
		
	}

}
