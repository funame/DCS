package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Person;

import net.myapp.model.Student;


@Repository
public class StudentDAOImpl {

    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
    public void add(Student p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    @Transactional
    public void update(Student p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
 
    public List<Student> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> list = session.createQuery("from Student").list();
        
        return list;
    }
    @Transactional
    public Student getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Student p = (Student) session.load(Student.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
 
}
