package net.myapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.myapp.model.User;

public class UserDAO {
	
	
	public  List<User> getUserList() throws SQLException
	{
		List<User> userList=new ArrayList<User>();
		User user;
		
		Db.rs=Db.stmt.executeQuery("Select * FROM users");
		
		while (Db.rs.next()) {
			user=new User();
			
			user.setName(Db.rs.getString("name"));
			user.setPhone(Db.rs.getString("phone"));
			user.setId(Db.rs.getInt("id"));
			
			userList.add(user);
			
		}
		return userList;
		
		
		
	}

}
