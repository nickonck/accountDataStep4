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

import es.unileon.ulebank.springapp.service.AccountManager;
import es.unileon.ulebank.springapp.service.NewOverdraft;

@Controller
@RequestMapping(value="setoverdraft.htm")
public class SetOverdraftController {

	protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AccountManager accountManager;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid NewOverdraft newOverdraft, BindingResult result){
    	if(result.hasErrors()){
    		return "setoverdraft";
    	}
    	
    	double overdraft = newOverdraft.getValue();
    	logger.info("Setting overdraft by " + overdraft);
    	
    	accountManager.changeOverdraft(overdraft);
    	
    	return "redirect:/account.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected NewOverdraft formBackingObject(HttpServletRequest request) throws ServletException{
    	NewOverdraft newOverdraft = new NewOverdraft();
    	newOverdraft.setValue(0);
    	return newOverdraft;
    }

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}
