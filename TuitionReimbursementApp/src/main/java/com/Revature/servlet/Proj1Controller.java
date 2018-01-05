package com.Revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Proj1Controller
 */
public class Proj1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proj1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		Employees emp = (Employees) session.getAttribute("employee");
		
		System.out.println("PRID IS" + request.getParameter("prid"));
		if(request.getParameter("Preid") != null) {
			String id = request.getParameter("Preid");
			UpdateReimbursementDAO.updateStatus(id);
		}
		if(request.getParameter("PreDMid") != null) {
			String id = request.getParameter("PreDMid");
			UpdateReimbursementDAO.updateDMCONFIRM(id);
			for(int i =0; i < emp.getListOfPresentations().size(); i++) {
				if(emp.getListOfPresentations().get(i).getForRid().equals(id)) {
					emp.getListOfPresentations().get(i).setDsconfirm(1);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("PresentationPage");  
		    rd.forward(request,response); 
		}
		if(request.getParameter("PreBCid") != null) {
			System.out.println("Goes in here here for sure");
			String id = request.getParameter("PreBCid");
			UpdateReimbursementDAO.updateBcConfrim(id);
			for(int i =0; i < emp.getListOfPresentations().size(); i++) {
				if(emp.getListOfPresentations().get(i).getForRid().equals(id)) {
					emp.getListOfPresentations().get(i).setBcconfirm(1);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("PresentationPage");  
		    rd.forward(request,response); 
		}
		if(request.getParameter("acid") != null) {
			String id = request.getParameter("acid");
			UpdateReimbursementDAO.updateAccept(id, emp.getEmployeeType());
			emp.deleteReimbursement(id);
			
		}
		if(request.getParameter("canid") != null) {
			String id = request.getParameter("canid");
			UpdateReimbursementDAO.updateCancel(id);
			
			/*
			for(int i =0; i < emp.getListOfReimbursements().size(); i++) {
				if(emp.getListOfReimbursements().get(i).getRID() == Integer.parseInt(id)) {
					emp.getListOfReimbursements().get(i).setStatus(3);
				}
			}*/
			emp.deleteReimbursement(id);
		}
		
		if(request.getParameter("rjid") != null) {
			String id = request.getParameter("rjid");
			UpdateReimbursementDAO.updateDelete(id);
			
			for(int i =0; i < emp.getListOfReimbursements().size(); i++) {
				if(emp.getListOfReimbursements().get(i).getRID() == Integer.parseInt(id)) {
					emp.getListOfReimbursements().get(i).setStatus(2);
				}
			}
			//emp.deleteReimbursement(id);
		}
		if(request.getParameter("altid") != null) {
			String id = request.getParameter("altid");
			int amount = Integer.parseInt(request.getParameter("amount"));
			UpdateReimbursementDAO.alterReimbursementAmount(id, amount);
			for(int i =0; i < emp.getListOfReimbursements().size(); i++) {
				if(emp.getListOfReimbursements().get(i).getRID() == Integer.parseInt(id)) {
					emp.getListOfReimbursements().get(i).setTotalcost(amount);
				}
			}
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("WelcomePage");  
	    rd.forward(request,response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		if(request.getParameter("prid") != null) {
			HttpSession session = request.getSession(false);
			
			LocalDateTime presentTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			Employees emp = (Employees) session.getAttribute("employee");
			String id = request.getParameter("prid");
			System.out.println("RID IS" + id+"");
			System.out.println("EID IS " +ReimbursementDAO.getEID(id)+"");
			System.out.println("AVAL REIMBURSE IS"+ReimbursementDAO.getavalReimburse(id));
			System.out.println(request.getParameter("GradeType"));
			System.out.println(request.getParameter("Grade"));
			
			Reimbursements reimb = new Reimbursements();
			for(int i =0; i < emp.getListOfReimbursements().size(); i++) {
				if(emp.getListOfReimbursements().get(i).getRID() == Integer.parseInt(id)) {
					reimb = emp.getListOfReimbursements().get(i);
				}
			}
			System.out.println(reimb.getCourseStartDate());
			UpdateReimbursementDAO.InsertPresentation(ReimbursementDAO.getEID(id), id, Integer.parseInt(ReimbursementDAO.getavalReimburse(id)), Integer.parseInt(request.getParameter("GradeType")), request.getParameter("Grade"));
			emp.getListOfReimbursements().clear();
			RequestDispatcher rd=request.getRequestDispatcher("WelcomePage");  
		    rd.forward(request,response); 
		}
		if(request.getParameter("username") != null) {      
			String n=request.getParameter("username");
			String p=request.getParameter("password"); 
			Employees emp;
			
			//for now
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();
			
			emp = (Employees) session.getAttribute("employee");
			
			if(emp == null) {
				emp = new Employees();
				session.setAttribute("employee", emp);
			}
			emp.setUsername(n);
			      
			if(LoginDAO.validate(n, p)){  
			    RequestDispatcher rd=request.getRequestDispatcher("WelcomePage");  
			    rd.forward(request,response);
			    //response.sendRedirect("WelcomePage");
			}  
			else{
				
			    RequestDispatcher rd=request.getRequestDispatcher("Websites");  
			    rd.include(request,response);
			    out.println("<script>\r\n" + 
						"			alert(\"Wrong username or password!\");\r\n" + 
						"		</script>");
			    //response.sendRedirect("Websites");
			}  
		}     
		out.close();  
		}  
		
	

}
