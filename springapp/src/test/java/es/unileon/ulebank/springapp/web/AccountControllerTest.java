package es.unileon.ulebank.springapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.springapp.service.SimpleAccountManager;

public class AccountControllerTest {

	AccountController controller;
	private SimpleAccountManager accountManager;
	private Account myAccount;
	
	private static String ACCOUNT_NUMBER="98765432";
	private static String BANK_NUMBER="2098";
	private static String OFFICE_NUMBER="9876";
	private static String DC_NUMBER="14";
	
	@Before
	public void setUp() throws Exception {
		controller= new AccountController();
		accountManager = new SimpleAccountManager();
		myAccount= new Account();
		AccountHandler handler=new AccountHandler();
		handler.setAccountNumber(ACCOUNT_NUMBER);
		handler.setBank(BANK_NUMBER);
		handler.setDc(DC_NUMBER);
		handler.setOffice(OFFICE_NUMBER);
		myAccount.setId(handler);
		
		accountManager.setAccount(myAccount);
		controller.setAccountManager(accountManager);
	}

	@Test
	public void testHandleRequest() throws Exception{
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("account", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Map<String, Object> model = (Map<String, Object>) modelAndView.getModel().get("model");
		assertNotNull(model.get("now"));
		assertEquals(myAccount, model.get("account"));
	}

}
