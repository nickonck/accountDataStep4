package es.unileon.ulebank.springapp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.springapp.web.AccountController;

public class AccountControllerTests {

	@Test
	public void testHandleRequestView() throws Exception{
		AccountController controller = new AccountController();
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		String nowValue = (String) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
	}

}
