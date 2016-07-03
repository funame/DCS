package net.myapp.test.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.myapp.hbr.dao.PersonDAO;
import net.myapp.hbr.dao.StudentDAOImpl;
import net.myapp.model.Student;

public class Test {
	
	

	   @Autowired(required=true)
	   @Qualifier(value="studentDAO")
	   private static StudentDAOImpl studentDAOImpl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(studentDAOImpl.getById(3).getName());

	}

}
