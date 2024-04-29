package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.dto.User;

public class User_Dao {
	public void saveUser(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider","root", "root");
			PreparedStatement ps=con.prepareStatement("insert into user_mgmt (name,age,mobile,email,password) values(?,?,?,?,?)");
			
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setLong(3, user.getMobile());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			
			
			
			ps.executeUpdate();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider","root", "root");
			PreparedStatement ps=con.prepareStatement("select * from user_mgmt where email=? and password=?");
			
		
			ps.setString(1,email);
			ps.setString(2, password);
			 
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			
			User user=new User();
			
			String name=rs.getString("name");
			int age=rs.getInt("age");
			Long mobile=rs.getLong("mobile");
			String mail=rs.getString("email");
			String pwd=rs.getString("password");
			int id =rs.getInt("id");
			
			user.setName(name);
			user.setAge(age);
			user.setMobile(mobile);
			user.setEmail(email);
			user.setPassword(password);
			
			
			return user;
			
		      }
					
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
		
	
		
		
		
	}

}
