package net.myapp.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Db {
	
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs=null;
	
	
	public static void start(){
		
		
		System.out.println("-------- MySQL JDBC Connection   Starting------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		//Connection connection = null;
         
		try {
			conn = (Connection) DriverManager
			.getConnection("jdbc:mysql://localhost:3306/ideas_bank","root", "123456");
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void setConnection(Connection connection) {
		Db.conn = connection;
	}
	
	public static void close() throws SQLException {
	   try {
		rs.close();
		stmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
	   finally
	{
		   if (rs!=null)  rs.close();
		   if (stmt!=null)  stmt.close();
		   if (conn!=null)  conn.close();
		
	}
	   
	}
	

	

}
