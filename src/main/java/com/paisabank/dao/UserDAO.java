package com.paisabank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.paisabank.model.User;
import com.paisabank.util.DBConnection;
public class UserDAO {
	public boolean registerUser(User user) {
		Connection con= DBConnection.getConnection();
		try {
			String sql="insert into users(full_name, email, mobile, password) values(?,?,?,?); ";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2,user.getEmail());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());
			int a=ps.executeUpdate();
			return a == 1;
		}catch(Exception e) {
			e.printStackTrace();

			return false;
		}
	}
	/*
	 * public static void main(String [] args) { User user=new
	 * User("Test","abc@gmail.com",1234567890,"test@1"); 
	 * UserDAO ob=new UserDAO();
	 * System.out.println(ob.registerUser(user)); }
	 */
}
