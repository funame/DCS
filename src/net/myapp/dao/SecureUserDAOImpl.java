package net.myapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import net.myapp.dao.model.SecureUser;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.helper.CommonUtil;

public class SecureUserDAOImpl implements SecureUserDAO {
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
	@Override
	@Transactional
	public SecureUser getSecureUser(String login) throws UserNotFoundException {
		   Session session = this.sessionFactory.getCurrentSession();      
	       Query query=session.createQuery(" from SecureUser where login=:login");
	       query.setString("login", login);
	       SecureUser s=(SecureUser) query.uniqueResult();
	       if (CommonUtil.isNull(s))  throw new UserNotFoundException(login);
	       return s;
	    }

}
