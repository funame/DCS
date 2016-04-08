package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Person;

import net.myapp.model.Student;
import net.myapp.model.Subject;



@Repository
public class SubjectDAOImpl {

    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
    public void add(Subject p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
 
    public void update(Subject p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
 
    public List<Subject> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Subject> list = session.createQuery("from Subject").list();
        
        return list;
    }
    @Transactional
    public Subject getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Subject p = (Subject) session.load(Subject.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
    @Transactional
    public void test() {

        String hql = "from Student s inner join s.subject";
        Session session = this.sessionFactory.getCurrentSession();
         
        Query query = session.createQuery(hql);
        List<Object[]> listResult = query.list();
         
        for (Object[] aRow : listResult) {
            Student student = (Student) aRow[0];
            Subject subject = (Subject) aRow[1];
            System.out.println(student.getName() + " - " + subject.getName());
        }
        
    }
 
 
}
