package com.Revature.servlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect{

	    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
	        //Properties prop = new Properties();
	    	//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//InputStream in = new FileInputStream("db.properties");
			//prop.load(in);
			//String url = prop.getProperty("url");
			//String user = prop.getProperty("user");
			//String password = prop.getProperty("password");
	    	Class.forName("oracle.jdbc.OracleDriver"); 
	        return DriverManager.getConnection("jdbc:oracle:thin:@project1.csdfpr0qjmc7.us-east-1.rds.amazonaws.com:1521:ORCL", "Lyinky", "loveisgreat2");
	    	//return DriverManager.getConnection(url, user, password);
	    }
};

