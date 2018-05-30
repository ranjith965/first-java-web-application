package com.in28minute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	private UserValidationService valid = new UserValidationService();
	
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res)
	        throws ServletException, IOException {
		req.setAttribute("name", req.getParameter("name"));
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,
				res);
	}
	
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res)
	        throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		if(valid.isUserValid(name,password)) {
			req.setAttribute("name", req.getParameter("name"));
			req.setAttribute("password",req.getParameter("password"));
			req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req,
					res);
		}
		else {
			req.setAttribute("errorMessage", "Invalid Credentials");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,
					res);
		}
		
	}
	
	
}
