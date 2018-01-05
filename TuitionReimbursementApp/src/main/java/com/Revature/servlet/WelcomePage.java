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
 * Servlet implementation class WelcomePage
 */
public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomePage() {
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
		LocalDateTime presentTime = LocalDateTime.now();
		HttpSession session = request.getSession(false);
		emp = (Employees) session.getAttribute("employee");
		if(request.getParameter("id") != null) {
			String id = request.getParameter("id");
			emp.deleteReimbursement(id);
		}
		response.setContentType("text/html");	
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"		<title>Tuition Reimbursement Management System Main Page</title>\r\n" + 
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
				"					<h2 style=\"float:left\" class=\"welcome\"> Expense Reimbursements</h2> <button style=\"float:right\"><a class=\"submitReimburse\" href=\"ReimbursementForm\">Submit A Reimbursement</a></button>\r\n"+
				"					<button style=\"float:right\"><a class=\"submitReimburse\" href=\"Websites\">Logout!</a></button>\r\n");  
				if(emp.getEmployeeType() == 3 || emp.getEmployeeType() == 2 || emp.getEmployeeType() == 1 || emp.getEmployeeType() == 4) {
					out.println("<form style=\"float:right\" method=\"post\" action=\"PresentationPage\">\r\n" + 
							"	<input type=\"submit\" value=\"Presentations\"> \r\n" + 
							"</form>");
				}
		out.println(
				"					<table class=\"table\">\r\n" + 
				"						<thead class=\"thead-light\">\r\n" + 
				"							<tr>\r\n" + 
				"								<th scope='col'> R-ID </th>\r\n" + 
				"								<th scope='col'> Requester </th>\r\n" + 
				"								<th scope='col'> Type</th>\r\n" + 
				"								<th scope='col'> Status	</th>\r\n" + 
				"								<th scope='col'> Description </th>\r\n" + 
				"								<th scope='col'> Justification</th>\r\n" +
				"								<th scope='col'> Grading Format </th>\r\n" +
				"								<th scope='col'> Submitted Cost </th>\r\n" +
				"								<th scope='col'> Projected Cost </th>\r\n" + 
				"								<th scope='col'> Date Submitted </th>\r\n" +
				"								<th scope='col'> Course Date Start </th>\r\n" +
				"							</tr>\r\n" + 
				"						</thead>\r\n"+
				"						<tbody>\r\n"
				);
		
		for(Reimbursements rb : emp.getListOfReimbursements()) {
			//System.out.println(LocalDateTime.now());

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	       
	        LocalDateTime RbCourseStart = LocalDateTime.parse(rb.getCourseStartDate().substring(0, 19), formatter);
	        //LocalDateTime fromTemp = LocalDateTime.from(RbDateTime);
	        //long days = fromTemp.until(to, ChronoUnit.DAYS);
	        System.out.println(rb.getDsapproval());
	        System.out.println(rb.getDhapproval());
	        System.out.println(rb.getBcapproval());
	        
	        Long twoWeeks = (long) (60*60*24*14);
	       
	        long diffInSeconds = ChronoUnit.SECONDS.between(presentTime,RbCourseStart);
	        System.out.println(diffInSeconds + "is greater than or less than" + twoWeeks);
	        
	        if(diffInSeconds <= twoWeeks && !(rb.getStatus().equals("Rejected"))) {
	        	out.println("						<tr class=\"table-warning\">\r\n");
	        }
	        
	        
	        else if(rb.getDsapproval() == 1 && rb.getDhapproval() == 1 && rb.getBcapproval() == 1) {
				out.println("						<tr class=\"table-success\">\r\n");
			}
			else if(rb.getStatus().equals("Rejected")) {
				out.println("						<tr class=\"table-danger\">\r\n");
			}
			
			else {
				out.println("						<tr class=\"table-light\">\r\n");
			}
			out.println(			
					"							<th scope='row'>"+rb.getRID()+"</th>\r\n" + 
					"								<td>"+rb.getFirstname()+rb.getLastname()+"</td>\r\n" + 
					"								<td>"+rb.getTypeOfEvent()+"</td>\r\n" + 
					"								<td>"+rb.getStatus()+"</td>\r\n" + 
					"								<td>"+rb.getDescription()+"</td>\r\n" + 
					"								<td>"+rb.getJustification()+"</td>\r\n" +
					"								<td>"+rb.getGradingformat()+"</td>\r\n" +
					"								<td>$"+rb.getTotalcost()+"</td>\r\n" +
					"								<td>$"+rb.getProjectedcost()+"</td>\r\n" + 
					"								<td id="+rb.getRID()+"-sD>"+rb.getDate()+"</td>\r\n" +
					"								<td id="+rb.getRID()+"-cSD>"+rb.getCourseStartDate()+"</td>\r\n");
			String email = UpdateReimbursementDAO.sendEmail(Integer.toString(rb.getRID()));
			System.out.println(emp.getFirstname());
			System.out.println(rb.getFirstname());
			if(!(emp.getFirstname().equals(rb.getFirstname())) ) {
				out.println(
						"								<td><a class=\"emailbutton\" href=mailto:"+email+"><button>Send Email</button></a></td>\r\n");
			}
			if(!(rb.getStatus().equals("Rejected"))) {
				if(emp.getEmployeeType() == 3) {
					out.append("<td>\r\n" + 
							"							<form action=\"Proj1Controller\" method=\"get\">\r\n" + 
							"								<input type=\"text\" name=\"amount\" placeholder=\"amount\">\r\n" + 
							"								<input type=\"hidden\" name=\"altid\" value="+Integer.toString(rb.getRID())+">\r\n" + 
							" 								<input class=\"alterbutton\" type=\"submit\" value=\"Alter Amount\">\r\n" + 
							" 							</form>\r\n" + 
							" 						</td>"
							);
				}
				if(emp.getFirstname().equals(rb.getFirstname()) && emp.getLastname().equals(rb.getLastname())) {
					out.append(
						"								<td><a class=\"rejectbutton\" href=Proj1Controller?canid="+Integer.toString(rb.getRID())+"> <button>Cancel! </button></a></td>\r\n"
						);
					if(rb.getDsapproval() == 1 && rb.getDhapproval() == 1 && rb.getBcapproval() == 1) {
						out.append(
								"								<td><a href=PresentationForm?prid="+Integer.toString(rb.getRID())+"> <button>Submit Presentation! </button></a></td>\r\n"
								);
					}
				}
				if(!(emp.getFirstname().equals(rb.getFirstname()))) {
					if((emp.getEmployeeType() == 2 && rb.getDsapproval() == 0) || (emp.getEmployeeType() == 4 && rb.getDhapproval() == 0) || (emp.getEmployeeType() == 4 && rb.getDsapproval() == 0) || (emp.getEmployeeType() == 5 && rb.getDhapproval() == 0) || (emp.getEmployeeType() == 3 && rb.getBcapproval() == 0) ) {
							out.append(
							"								<td><a class=\"acceptbutton\" href=Proj1Controller?acid="+Integer.toString(rb.getRID())+"> <button>Approve!</button></a></td>\r\n" + 
							"								<td><a class=\"rejectbutton\" href=Proj1Controller?rjid="+Integer.toString(rb.getRID())+"> <button>Reject! </button></a></td>\r\n" + 
							"								\r\n");
						}
					
					//out.append("							</tr>\r\n");
				}
			}
			
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
		ArrayList<Integer> empType = new ArrayList<Integer>();
		empType.add(2);
		empType.add(3);
		empType.add(4);
		empType.add(5);
		
		LocalDateTime presentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		Employees emp;
		
		HttpSession session = request.getSession(false);
		emp = (Employees) session.getAttribute("employee");
		
		if(emp == null) {
			emp = new Employees();
			session.setAttribute("employee", emp);
		}
		
		try {
			Connection con= DBConnect.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			
			
	        ps=con.prepareStatement("SELECT FIRSTNAME, LASTNAME\r\n" + 
	        		"FROM EMPLOYEES E\r\n" + 
	        		"WHERE (SELECT USERID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = E.EID");
	        rs = ps.executeQuery();
	        rs.next();
	       
	        emp.setFirstname(rs.getString(1));
	        emp.setLastname(rs.getString(2));
			ps=con.prepareStatement("SELECT EMPLOYEETYPE FROM EMPLOYEES E WHERE (SELECT USERID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = EID");
		    rs = ps.executeQuery();
		    rs.next();
		    
		    emp.setEmployeeType(rs.getInt(1));
		    System.out.println("EMPLOYEE TYPE IS "+rs.getInt(1));
		    if(rs.getInt(1) == 3) {
		    	ps = con.prepareStatement("SELECT * FROM REIMBURSEMENTS R WHERE BCAPPROVED = 0\r\n" + 
		    			"UNION ALL\r\n" + 
		    			"SELECT * FROM REIMBURSEMENTS R WHERE (SELECT UserID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = R.EID");
		    }
		    if(rs.getInt(1) == 5) {
		    	ps = con.prepareStatement("SELECT * FROM REIMBURSEMENTS R\r\n" + 
		    			"WHERE (SELECT USERID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = (SELECT E.DEPARTMENTHEAD FROM EMPLOYEES E WHERE E.EID = R.EID) AND DHAPPROVED = 0\r\n" + 
		    			"UNION ALL\r\n" + 
		    			"SELECT * FROM REIMBURSEMENTS R1\r\n" + 
		    			"WHERE (SELECT UserID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = R1.EID");
		    }
		    if(rs.getInt(1) == 2) {
		    	ps = con.prepareStatement("SELECT * FROM REIMBURSEMENTS R\r\n" + 
		    			"WHERE (SELECT UserID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = (SELECT E.REPORTSTO FROM EMPLOYEES E WHERE E.EID =  R.EID) AND DSAPPROVED = 0\r\n" + 
		    			"UNION ALL\r\n" + 
		    			"SELECT * FROM REIMBURSEMENTS R1\r\n" + 
		    			"WHERE (SELECT UserID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = R1.EID");
		    }
		    if(rs.getInt(1) == 1) {
		    	ps = con.prepareStatement("SELECT * FROM REIMBURSEMENTS R\r\n" + 
		    			"WHERE (SELECT USERID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = (SELECT E.EID FROM EMPLOYEES E WHERE E.EID = R.EID)");
		    }
		    if(rs.getInt(1) == 4) {
		    	ps=con.prepareStatement("SELECT DISTINCT * FROM REIMBURSEMENTS R\r\n" + 
		    			"    WHERE (SELECT USERID FROM USERS WHERE USERNAME = '"+emp.getUsername()+"') = (SELECT E.DEPARTMENTHEAD FROM EMPLOYEES E WHERE E.EID = R.EID) AND DHAPPROVED = 0\r\n" + 
		    			"    UNION ALL\r\n" + 
		    			"    SELECT DISTINCT * FROM REIMBURSEMENTS R1\r\n" + 
		    			"    WHERE (SELECT UserID\r\n" + 
		    			"    FROM USERS\r\n" + 
		    			"    WHERE USERNAME = '"+emp.getUsername()+"') = (SELECT E1.REPORTSTO FROM EMPLOYEES E1 WHERE E1.EID =  R1.EID) AND DSAPPROVED = 0");
		    	
		    }
		    rs = ps.executeQuery();
		    
			while(rs.next()) {
				LocalDateTime RbDateTime = LocalDateTime.parse(rs.getString(6).substring(0, 19), formatter);
				long diffInSeconds = ChronoUnit.SECONDS.between(presentTime, RbDateTime);
				Long week = (long) (60*60*24*7);
				int dsFlag=rs.getInt(12);
				int dhFlag=rs.getInt(13);
				int bcFlag=rs.getInt(14);
				if(diffInSeconds >= week ) {
					UpdateReimbursementDAO.updateAccept(Integer.toString(rs.getInt(1)), emp.getEmployeeType());
					if(emp.getEmployeeType() == 2) {
						dsFlag = 1;
					}
					if(emp.getEmployeeType() == 3) {
						bcFlag = 1;
					}
					if(emp.getEmployeeType() == 4) {
						dsFlag = 1;
						dhFlag = 1;
					}
					if(emp.getEmployeeType() == 5) {
						dhFlag = 1;
					}
				}
				/* rid, firstname, lastname, typeOfEvent, date, totalcost, descrip, justification, grading format, status */
				Reimbursements rb = new Reimbursements(rs.getInt(1),rs.getString(3), rs.getString(4), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(12), rs.getInt(13), rs.getInt(14));
				
				
				
				
				
				
				
				rb.setTypeOfEvent(rs.getInt(5));
				rb.setStatus(rs.getInt(15));
				rb.setGradingformat(rs.getInt(10));
				rb.setDsapproval(dsFlag);
				rb.setDhapproval(dhFlag);
				rb.setBcapproval(bcFlag);
				rb.setCourseStartDate(rs.getString(16));
				emp.getListOfReimbursements().add(rb);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		response.sendRedirect("WelcomePage");
	}

}
