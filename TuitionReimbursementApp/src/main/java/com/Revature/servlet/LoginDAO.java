package com.Revature.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			      
			PreparedStatement ps=con.prepareStatement(  
			"SELECT * FROM USERS WHERE username=? AND password=?");  
			ps.setString(1,name);  
			ps.setString(2,pass);  
			      
			ResultSet rs=ps.executeQuery(); 
			
			while(rs.next()) {
				status = true;
			};  
			          
			}catch(Exception e){System.out.println(e);} 
			return status;  
		}  
		 
}
