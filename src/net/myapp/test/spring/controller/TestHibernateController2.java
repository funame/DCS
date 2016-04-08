package net.myapp.test.spring.controller;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;
import net.myapp.model.Student;
import net.myapp.model.Subject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.dao.StudentDAOImpl;
import com.journaldev.spring.dao.SubjectDAOImpl;
import com.journaldev.spring.service.PersonService;

import java.util.Locale;


@Controller
public class TestHibernateController2 {
	@Autowired
    private MessageSource messageSource;
	
	   @Autowired(required=true)
	   @Qualifier(value="studentDAO")
	   private StudentDAOImpl studentDAO;
	 
	   @Autowired(required=true)
	   @Qualifier(value="subjectDAO")
	   private SubjectDAOImpl subjectDAO;
	 
	
	  @RequestMapping(value="/helloStudent",method = RequestMethod.GET)
	   public String printHello(Locale locale) {
	   
       Log.debug("hi");
         //System.out.println("data from db :"+studentDAO.getById(1).getName());
      
         
         /*
          * 
          * for adding student 
          * 
          * 
          * Student adil=new Student();
         adil.setName("Adil");
         adil.setSurname("Zeynalov");
         adil.setEmail("adil@mail.ru");
         adil.setPhone("12345");
         
         
         studentDAO.add(adil);
         */
         
         /*
          * 
          * for adding subject
          * 
          * Subject java=new Subject();
         java.setName("Java");
         java.setDescr("---");
         
         subjectDAO.add(java);
         System.out.println(java.getId());
         
         */
         
         
         /*
          * for update student
          * join with subject
          * 
          * 
          * Student st=studentDAO.getById(2);
         
         st.setSubject(subjectDAO.getById(1));
         studentDAO.update(st);
         */
         
         //Student st=studentDAO.getById(1);
         //System.out.println(st.getGroup().getTeacher().getName());
         
         subjectDAO.test();
         return "hello";
	   }
	  
	  
}
//http://www.journaldev.com/3531/spring-mvc-hibernate-mysql-integration-crud-example-tutorial
//http://javaonlineguide.net/2015/03/spring-4-and-hibernate-4-integration-example-project-in-eclipse-without-maven-support.html

