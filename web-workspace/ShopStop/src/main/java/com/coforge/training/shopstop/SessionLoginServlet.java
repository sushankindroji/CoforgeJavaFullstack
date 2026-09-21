package com.coforge.training.shopstop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionLoginServlet
 * 
 * /**
 * Servlet implementation class SessionLoginServlet
 * 
 * Session: A session is a way to store information (in variables) to be used across multiple pages. 
 * 			Unlike a cookie, the information is not stored on the user's computer.
 * 
 * HttpSession: HttpSession is an interface provided by the Servlet API that allows you to manage user sessions 
 * 				in a web application.
 * Methods of HttpSession: getId(), getCreationTime(), getLastAccessedTime(), setAttribute(), 
 * 							getAttribute(), removeAttribute(), invalidate();
 */
@WebServlet("/sessionlogin")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Create Application Scope attribute using ServletContext
		getServletContext().setAttribute("app", "ShopStop Online Shopping Portal");

		String username=request.getParameter("username");
		String password=request.getParameter("password");

		if(password.equals("password123"))
		{

			// Create a session using HttpSession and store the username in the session
			HttpSession session=request.getSession();

			session.setAttribute("username",username);
			session.setAttribute("college","CBIT");

			//Session expires after 30 seconds
			session.setMaxInactiveInterval(30);

			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");

			rd.forward(request,response);
		}
		else
		{
			response.sendRedirect("sessionlogin.html");
		}   

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
