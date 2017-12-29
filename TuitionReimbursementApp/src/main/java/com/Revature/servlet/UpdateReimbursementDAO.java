package com.Revature.servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UpdateReimbursementDAO {
	public static void updateAccept(String acid, int employeeType){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(acid);
			System.out.println(employeeType);
			if(employeeType == 2 || employeeType == 4) {
				String sql = "BEGIN\r\n" + 
						"    UPDATE_DSREIMBURSEMENTS("+acid+");\r\n" + 
						"END;";
				System.out.println(sql);
				ps=con.prepareStatement(sql);
				//ps.setString(1, acid);
				ps.executeQuery(); 
			}
			if(employeeType == 5 || employeeType == 4) {
				String sql = "UPDATE REIMBURSEMENTS SET DHAPPROVED = 1 WHERE RID = "+acid+"";
				ps=con.prepareStatement(sql);
				//ps.setString(1, acid);
				ps.executeUpdate(); 
			}
			if(employeeType == 3) {
				String sql = "UPDATE REIMBURSEMENTS SET BCAPPROVED = 1 WHERE RID = "+acid+"";
				ps=con.prepareStatement(sql);
				ps.executeUpdate(); 
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void updateDelete(String acid){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(acid);
			ps=con.prepareStatement("UPDATE REIMBURSEMENTS SET STATUS = 2 WHERE RID = "+acid+"");
			ps.executeUpdate(); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static String sendEmail(String rid) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			ResultSet rs;
			ps=con.prepareStatement("Select EMAIL FROM EMPLOYEES WHERE EID = (SELECT EID FROM REIMBURSEMENTS WHERE RID = "+rid+")");
			rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return rid;
	}
}
