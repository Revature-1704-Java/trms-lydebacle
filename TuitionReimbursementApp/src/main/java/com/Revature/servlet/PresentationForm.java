package com.Revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PresentationForm
 */
public class PresentationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prid= request.getParameter("prid");
		response.getWriter().append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"		<title>Tuition Reimbursement Management System Presentation Form Page</title>\r\n" + 
				"		<meta name=\"author\" content=\"Samuel Huang\">\r\n" + 
				"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n" + 
				"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n" + 
				"		\r\n" + 
				"		\r\n" + 
				"		<link rel=\"stylesheet\" href=\"project1.css\">\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<div class=\"login-box-wrapper\"> \r\n" + 
				"			<div class=\"reimbursement-box\">\r\n" + 
				"				<div id=\"reimbursement-input\">\r\n" + 
				"					<h2 class=\"welcome\"> Please fill out your presentation!</h2>\r\n" + 
				"\r\n" + 
				"					<form id=\"ReimbursementForm\" action=\"Proj1Controller\" method=\"post\">\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"					  		<label for=\"GradeType\" class=\"text-uppercase\">Type of Grade</label>\r\n" + 
				"					  		<select style=\"display:block; width: 50%; margin-top: 2%; margin-bottom: 2%; margin-left: 25%; margin-right: 25%\" name=\"GradeType\">\r\n" + 
				"					  			<option value = \"1\">P/NP</option>\r\n" + 
				"					  			<option value = \"2\">Letter</option>\r\n" + 
				"					  			<option value = \"3\">Point-scale</option>\r\n" + 
				"					  		</select>\r\n" + 
				"    						\r\n" + 
				"    					</div>\r\n" + 
				"    					<div class=\"form-group\">\r\n" + 
				"						    <label for=\"Grade\" class=\"text-uppercase\">Grade</label>\r\n" + 
				"						    <input style=\"width: 100%;\" type=\"text\" class=\"form-control\" placeholder=\"\" name=\"Grade\">\r\n" + 
				"						    <input style=\"width: 100%;\" type=\"hidden\" class=\"form-control\" placeholder=\"\" name=\"prid\" value="+prid+">\r\n" +
				"						</div>\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"						    <label for=\"attached\" class=\"text-uppercase\">Attached Files/Images (Optional)</label>\r\n" + 
				"						    <input style=\"display:block; width: 50%; margin-top: 2%; margin-bottom: 2%; margin-left: 25%; margin-right: 25%\" type=\"file\" class=\"form-control\" placeholder=\"\">\r\n" + 
				"						</div>\r\n" + 
				"					    <div class=\"form-check\">\r\n" + 
				"							<button type=\"submit\" class=\"sub\">Submit</button>\r\n" + 
				"							<input  type=\"reset\" class=\"reset\">\r\n" + 
				"						</div>\r\n" + 
				"					</form>\r\n" + 
				"				</div>\r\n" + 
				"				\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"\r\n" + 
				"	</body>\r\n" + 
				"</html> \r\n" + 
				"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
