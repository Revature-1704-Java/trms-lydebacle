package com.Revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PresentationPage
 */
public class PresentationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Employees emp;
		//LocalDateTime presentTime = LocalDateTime.now();
		HttpSession session = request.getSession(false);
		emp = (Employees) session.getAttribute("employee");
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"		<title>Tuition Reimbursement Management System Presentations</title>\r\n" + 
				"		<meta name=\"author\" content=\"Samuel Huang\">\r\n" + 
				"		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\">\r\n" + 
				"		<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\" integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\" integrity=\"sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<link rel=\"stylesheet\" href=\"project1.css\">\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<div class=\"login-box-wrapper\"> \r\n" + 
				"			<div class=\"expense-box\">\r\n" + 
				"				<div id=\"expense-input\">\r\n" + 
				"					<h2 style=\"float:left\" class=\"welcome\"> Presentations</h2>\r\n" +
				"					<button style=\"float:right\"><a style=\"text-decoration:none\" class=\"submitReimburse\" href=\"Websites\">Logout!</a></button>\r\n"+
				"					<button style=\"float:right\"><a style=\"text-decoration:none\" class=\"submitReimburse\" href=\"WelcomePage\">Reimbursements</a></button>\r\n"+
				"					<table class=\"table\">\r\n" + 
				"						<thead class=\"thead-light\">\r\n" + 
				"							<tr>\r\n" + 
				"								<th scope='col'> P-ID </th>\r\n" + 
				"								<th scope='col'> Presenter </th>\r\n" + 
				"								<th scope='col'> FOR-RID</th>\r\n" + 
				"								<th scope='col'> Available Reimbursement	</th>\r\n" + 
				"								<th scope='col'> GradeType </th>\r\n" + 
				"								<th scope='col'> Grade</th>\r\n" + 
				"							</tr>\r\n" + 
				"						</thead>\r\n" + 
				"						<tbody>\r\n" + 
				"");
		
		for(Presentations pre : emp.getListOfPresentations()) {
			
	        
	       
			
			
			out.println("						<tr class=\"table-light\">\r\n");
			
			out.println(			
					"							<th scope='row'>"+pre.getPreID()+"</th>\r\n" + 
					"								<td>"+pre.getEid()+"</td>\r\n" + 
					"								<td>"+pre.getForRid()+"</td>\r\n" + 
					"								<td>"+pre.getAvailableReimburse()+"</td>\r\n" + 
					"								<td>"+pre.getGradeType()+"</td>\r\n" + 
					"								<td>"+pre.getGrade()+"</td>\r\n");
			
			
			if(pre.getBcconfirm() == 0) {
				if(emp.getEmployeeType() == 3) {
					out.append(
							"								<td><a class=\"rejectbutton\" href=Proj1Controller?PreBCid="+pre.getForRid()+"> <button>Confirm! </button></a></td>\r\n" 
							
							);
				}
			}
			
			if(pre.getDsconfirm() == 0) {
				if(emp.getEmployeeType() == 2 || emp.getEmployeeType() == 4) {
					out.append(
							"								<td><a class=\"rejectbutton\" href=Proj1Controller?PreDMid="+pre.getForRid()+"> <button>Confirm! </button></a></td>\r\n" 
							
							);
				}
			}
			if(pre.getBcconfirm() == 1 && pre.getDsconfirm() == 1 ){
				UpdateReimbursementDAO.updateStatus(pre.getForRid());
			}
					
					//out.append("							</tr>\r\n");
		
			
			out.append("							</tr>\r\n");
		}
		out.append("						</tbody>\r\n" + 
				"					</table>\r\n" + 
				"					\r\n" + 
				"				</div>\r\n" + 
				"				\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"		\r\n" + 
				"	</body>\r\n" + 
				"</html> \r\n"
		);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Goes into post");
		ArrayList<Integer> empType = new ArrayList<Integer>();
		empType.add(2);
		empType.add(3);
		empType.add(4);
		empType.add(5);
		
		Employees emp;
		
		HttpSession session = request.getSession(false);
		emp = (Employees) session.getAttribute("employee");
		
		
		try {
			Connection con= DBConnect.getConnection();
			PreparedStatement ps = null;
			ResultSet rs;
			
			
	        
		    if(emp.getEmployeeType() == 3) {
		    	ps = con.prepareStatement("SELECT * FROM PRESENTATIONS WHERE BCCONFIRM = 0");
		    }
		    if(emp.getEmployeeType() == 1) {
		    	ps = con.prepareStatement("SELECT * FROM PRESENTATIONS P\r\n" + 
		    			"WHERE (SELECT UserID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"')= P.Emp_author"); 
		    			
		    }
		    if(emp.getEmployeeType() == 2 || emp.getEmployeeType() == 4 ) {
		    	ps = con.prepareStatement("SELECT * FROM Presentations P\r\n" + 
		    			"WHERE (SELECT UserID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = (SELECT E.REPORTSTO FROM EMPLOYEES E WHERE E.EID =  P.Emp_author) AND DMCONFIRM = 0\r\n");
		    }
		    rs = ps.executeQuery();
			while(rs.next()) {
				boolean flag = false;
				if(emp.getListOfPresentations().size() >0) {
					for(int i=0; i<emp.getListOfPresentations().size(); i++) {
						if(emp.getListOfPresentations().get(i).getForRid() == rs.getString(3)) {
							flag = true;
						};
					}
				}
				if(flag == false) {
					Presentations pre = new Presentations(rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					
					
					/*pre.setEid(rs.getString(2));
					pre.setForRid(rs.getString(3));
					pre.setAvailableReimburse(rs.getInt(4));
					pre.setGradeType(rs.getString(5));
					pre.setGrade(rs.getString(6));
					pre.setCoursedate(rs.getString(7));*/
					pre.setPreID(rs.getString(1));
					if(pre.getBcconfirm() == 1 && pre.getDsconfirm() == 1 ){
						UpdateReimbursementDAO.updateStatus(pre.getForRid());
					}
					
					
					emp.getListOfPresentations().add(pre);
					for(int i=0; i<emp.getListOfPresentations().size(); i++) {
						System.out.println(emp.getListOfPresentations().get(i));
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		response.sendRedirect("PresentationPage");
	
	}

}
