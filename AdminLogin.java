package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println("emial.."+ email + "passwprd" + password);
		if(email.equals("divya.surapally2@gmail.com")&&password.equals("divya2002")){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			System.out.println("logged in");
			request.getRequestDispatcher("navadmin.html").include(request, response);
			request.getRequestDispatcher("admincarousel.html").include(request, response);
			
		}else{
			//request.getRequestDispatcher("navhome.html").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3>Username or password error</h3>");
			System.out.println("invalid");
			//request.getRequestDispatcher("adminloginform.html").include(request, response);
			out.println("</div>");
		}
		
		
		//request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}