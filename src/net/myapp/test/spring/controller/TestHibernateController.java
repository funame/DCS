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

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.service.PersonService;

import java.util.Locale;

@Controller
public class TestHibernateController {
	@Autowired
    private MessageSource messageSource;
	
	   @Autowired(required=true)
	   //@Qualifier(value="personService")
	   //private PersonService personService;
	   @Qualifier(value="personDAO")
	   private PersonDAO personDAO;
	 
/*	
	   @Autowired(required=true)
	   @Qualifier(value="personService")
	    public void setPersonService(PersonService ps){
	        this.personService = ps;
	    }*/
	 
	 
	  ////normal page passing to default/jsp folder page inside of main.jsp
	  @RequestMapping(value="/helloHiber",method = RequestMethod.GET)
	   public String printHello(Locale locale) {
	   
       
         //System.out.println("data from db :"+personService.getPersonById(1).getName());
         System.out.println("data from db :"+personDAO.getPersonById(1));
      
         
         personDAO.test();
		 return "hello";
	   }
	  
	  
}
//http://www.journaldev.com/3531/spring-mvc-hibernate-mysql-integration-crud-example-tutorial
//http://javaonlineguide.net/2015/03/spring-4-and-hibernate-4-integration-example-project-in-eclipse-without-maven-support.html

//http://www.codejava.net/frameworks/hibernate/hibernate-query-language-hql-example 