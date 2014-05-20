package es.unileon.ulebank.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.springapp.service.AccountManager;
import es.unileon.ulebank.springapp.service.ClientData;
import es.unileon.ulebank.springapp.service.NewOverdraft;

@Controller
@RequestMapping(value="/addauthorized.htm")
public class AddAuthorizedController {

	protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AccountManager accountManager;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid ClientData clientData, BindingResult result){
    	if(result.hasErrors()){
    		return "addauthorized";
    	}
    	Client client = new Client();
    	client.setDni(clientData.getDni());
    	client.setName(clientData.getName());
    	accountManager.addAuthorized(client);
    	
    	return "redirect:account.htm";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected ClientData formBackingObject(HttpServletRequest request) throws ServletException{
    	ClientData data = new ClientData();
    	return data;
    }

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
    
    
}
