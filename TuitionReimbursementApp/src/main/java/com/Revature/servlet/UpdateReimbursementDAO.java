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
	public static void updateCancel(String acid){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(acid);
			ps=con.prepareStatement("DELETE FROM REIMBURSEMENTS WHERE RID = "+acid+"");
			ps.executeUpdate(); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void updateBcConfrim(String Preid){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(Preid);
			ps=con.prepareStatement("UPDATE PRESENTATIONS SET BCCONFIRM = 1 WHERE FOR_RID = "+Preid+"");
			ps.executeUpdate(); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void updateDMCONFIRM(String Preid){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(Preid);
			ps=con.prepareStatement("UPDATE PRESENTATIONS SET DMCONFIRM = 1 WHERE FOR_RID = "+Preid+"");
			ps.executeUpdate(); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public static void updateStatus(String Preid){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(Preid);
			ps=con.prepareStatement("UPDATE REIMBURSEMENTS SET STATUS = 1 WHERE RID = "+Preid+"");
			ps.executeUpdate(); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void alterReimbursementAmount(String altid, int amount) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			System.out.println(altid);
			ps=con.prepareStatement("UPDATE REIMBURSEMENTS SET COST = "+amount+" WHERE RID = "+altid+"");
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
	
	public static void InsertPresentation(String eid, String rid, int reimburseAmount, int gradeType, String grade) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			
			ps=con.prepareStatement("INSERT INTO PRESENTATIONS (Emp_author, FOR_RID, AVAILABLEREIMBURSE, GRADETYPE, GRADE) VALUES ('"+eid+"','"+ rid+"',"+reimburseAmount+","+gradeType+",'" +grade+"')");
			ps.executeQuery();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
	public static void InsertReimbursement(String eid, String rid, int reimburseAmount, int gradeType, String grade) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con= DBConnect.getConnection();  
			PreparedStatement ps;
			
			ps=con.prepareStatement("INSERT INTO PRESENTATIONS (Emp_author, FOR_RID, AVAILABLEREIMBURSE, GRADETYPE, GRADE) VALUES ('"+eid+"','"+ rid+"',"+reimburseAmount+","+gradeType+",'" +grade+"')");
			ps.executeQuery();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
	
}
