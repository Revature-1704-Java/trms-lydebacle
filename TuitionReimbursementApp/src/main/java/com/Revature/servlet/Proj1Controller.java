package com.Revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		if(request.getParameter("acid") != null) {
			String id = request.getParameter("acid");
			UpdateReimbursementDAO.updateAccept(id, emp.getEmployeeType());
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
