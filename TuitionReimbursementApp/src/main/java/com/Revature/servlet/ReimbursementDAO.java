package com.Revature.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReimbursementDAO {
	
	public static String getEID(String rid) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			ResultSet rs;
			ps=con.prepareStatement("Select EID FROM EMPLOYEES WHERE EID = (SELECT EID FROM REIMBURSEMENTS WHERE RID = "+rid+")");
			rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return rid;
	}
	
	public static String getavalReimburse(String rid) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			ResultSet rs;
			ps=con.prepareStatement("Select AVAILREIMBURST FROM EMPLOYEES WHERE EID = (SELECT EID FROM REIMBURSEMENTS WHERE RID = "+rid+")");
			rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return rid;
	}
}
