package net.myapp.hbr.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.Order;
import net.myapp.dao.model.User;
import net.myapp.dao.model.UserCard;

@Repository
public class UserDAOImpl {
    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
    public void add(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
  //      logger.info("Person saved successfully, Person Details="+p);
    }
    @Transactional
    public void update(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    //    logger.info("Person updated successfully, Person Details="+p);
    }
 
    public List<User> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User").list();
        
        return list;
    }
    @Transactional
    public User getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User p = (User) session.load(User.class, new Integer(id));
       // logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    @Transactional
    public List<Object[]> getTest(int userCardId) {
        Session session = this.sessionFactory.getCurrentSession();      
        Query query = session.createQuery(" select uc,o,od,g,c,ct from UserCard uc "
				                         +" INNER JOIN uc.orderSet as o"
				                         +" INNER JOIN o.orderDetailSet as od"
				                         +" INNER JOIN od.good as g"
				                         +" INNER JOIN uc.card as c"
				                         +" INNER JOIN c.cardType as ct"
				                         +" where uc.id =:id");
        query.setParameter("id", userCardId);
       // query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        //List list = query.list();
        List<Object[]> list = query.list();
		/*for(Object[] arr : list){
			UserCard userCard=(UserCard) arr[0];
	     	Order order=(Order) arr[1];
			System.out.println(userCard.getBalance()+"   "+order.getTotal_amount());
		} 
		*/return list;
    }
    
}
