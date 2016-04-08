package com.journaldev.spring.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Person;
 
@Repository
public class PersonDAOImpl implements PersonDAO {
     
//    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
 
    @Override
    public void updatePerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person p : personsList){
     //       logger.info("Person List::"+p);
        }
        return personsList;
    }
 
    @Override
    @Transactional
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Person p = (Person) session.load(Person.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }
 
    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        //logger.info("Person deleted successfully, person details="+p);
    }
    

    
    @Transactional
    public void test() {
        Session session = this.sessionFactory.getCurrentSession();
        
        Query query = session.createSQLQuery("select p.name name1, s.name name2 from Person p "
                + "INNER JOIN subject s on s.id=p.subject_id");
        List<Object[]> list = query.list();
        
        for (Object[]  o:list) {
			System.out.println(o[0]+"   "+o[1]);
		}
        
        
        }
    
    
    
    
 
}