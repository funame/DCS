package net.myapp.test.spring.controller;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.service.PersonService;

import java.util.Locale;

@Controller
public class TestController {
	@Autowired
    private MessageSource messageSource;

	 
	

	 
	 
	  ////normal page passing to default/jsp folder page inside of main.jsp
	  @RequestMapping(value="/hello",method = RequestMethod.GET)
	   public String printHello(Locale locale) {
	      //model.addAttribute("message", "Hello Spring MVC Framework!");
         Log.debug("salamun aleykum"+locale);
         String[] args = { "Fuad"};
         Log.debug(messageSource.getMessage("app.title", args, locale));
 
         System.out.println("salam");
         
		 RequestHelper.setAttribute("message", "Rustem");
	     return "hello";
	   }
	  
	  
	  @RequestMapping(value="/ajaxTest",method = RequestMethod.GET)
	   public String printHello1() {
	    

		 RequestHelper.setAttribute("message", "Rustem");
	     return "ajaxTest";
	   }
	  ////////////////////that is return string or java object for parsing to json 
	   @ResponseBody
	   @RequestMapping(value="/GetName1",method=RequestMethod.GET)
	   public   String printHello2(@RequestParam String name) {
		System.out.println("ajax work");
	    
		return "Hi "+ name+" I am ajax in spring mvc";
	   }
       
	   //////////////////without responcebody  return name of jsp file in view/ajax/test1.jsp folder
	   @RequestMapping(value="/GetName",method=RequestMethod.GET)
	   public   String printHello3(@RequestParam String name) {
		System.out.println("ajax work");
	    
		return "test1";
	   }


}
