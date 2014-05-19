package es.unileon.ulebank.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.springapp.service.AccountManager;

@Controller
public class AccountController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private AccountManager accountManager;
	
	@RequestMapping(value="/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("account", this.accountManager.getAccount());
		logger.info("Returning hello view " + now);
		
		return new ModelAndView("hello", "now", now);
	}
}
