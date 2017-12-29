package com.Revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Websites
 */
public class Websites extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Websites() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"		<title>Tuition Reimbursement Management System</title>\r\n" + 
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
				"			<div class=\"login-box\">\r\n" + 
				"				<div id=\"login-input\">\r\n" + 
				"					<h2 class=\"welcome\"> Welcome to Tuition Reimbursement! Please login!</h2>\r\n" + 
				"\r\n" + 
				"					<form name=\"someForm\" action=\"Proj1Controller\" method='post'>\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"					  		<label for=\"exampleInputEmail1\" class=\"text-uppercase\">Username</label>\r\n" + 
				"    						<input type=\"text\" class=\"form-control\" placeholder=\"\" name=\"username\" required>\r\n" + 
				"    					</div>\r\n" + 
				"    					<div class=\"form-group\">\r\n" + 
				"						    <label for=\"exampleInputPassword1\" class=\"text-uppercase\">Password</label>\r\n" + 
				"						    <input type=\"password\" class=\"form-control\" placeholder=\"\" name=\"password\" required>\r\n" + 
				"						</div>\r\n" + 
				"					    <div class=\"form-check\">\r\n" + 
				"							<label class=\"form-check-label\">\r\n" + 
				"							<input type=\"checkbox\" class=\"form-check-input\">\r\n" + 
				"							<small>Remember Me</small>\r\n" + 
				"							</label>\r\n" + 
				"							<button type=\"submit\" class=\"btn btn-login float-right\" id=\"somebutton\">Submit</button>\r\n" + 
				"\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"register\">\r\n" + 
				"							Don't have an account? <span class=\"signup\">\r\n" + 
				"								<a id=\"signuplink\" href=\"#\">Sign up</a></span>\r\n" + 
				"						</div>\r\n" + 
				"					</form>\r\n" + 
				"					\r\n" + 
				"				</div>\r\n" + 
				"				\r\n" + 
				"				<div id=\"slider-container\">\r\n" + 
				"					<div class=\"slider-wrapper\">\r\n" + 
				"						<div class=\"slideshow\">\r\n" + 
				"							\r\n" + 
				"							<div class=\"slide one\">\r\n" + 
				"								<img class=\"classimage1\" src=\"https://i.imgur.com/ngYFURn.jpg\" />\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"slide two\">\r\n" + 
				"								<img src=\"https://i.imgur.com/WgJCc2i.jpg\" />\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"slide three\">		\r\n" + 
				"								<img class=\"slideimage\" src=\"https://i.imgur.com/GPUGdTg.jpg\" />\r\n" + 
				"							</div>\r\n" + 
				"\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
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
