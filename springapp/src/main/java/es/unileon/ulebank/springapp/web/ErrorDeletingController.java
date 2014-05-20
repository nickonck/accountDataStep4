package es.unileon.ulebank.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="errordeleting.htm")
public class ErrorDeletingController {

	@RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Validated Object obj, BindingResult result){
		return "redirect:account.htm";
    }
	
	@RequestMapping(method = RequestMethod.GET)
    protected Object formBackingObject(HttpServletRequest request) throws ServletException{
		return new Object();
  }
}
