package es.unileon.ulebank.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;

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
		List<Account> accounts = accountDao.getAccountList();

        Account p = accounts.get(0);
        double dc = p.getMaxOverdraft();
        p.setMaxOverdraft(50.0);
        accountDao.saveAccount(p);

        List<Account> updatedAccounts = accountDao.getAccountList();
        Account p2 = updatedAccounts.get(0);
        assertEquals(p2.getMaxOverdraft(),50.0, 1);

        p2.setMaxOverdraft(dc);
        accountDao.saveAccount(p2);
	}

}
