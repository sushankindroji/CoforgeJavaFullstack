package com.coforge.training.shopstop;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// use existing session, if any, otherwise return null
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate(); // Invalidate the session to log out the user
		}

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><body style='font-family:Arial;"
				+ "text-align:center;margin-top:100px;'>");

		out.println("<h2 style='color:red;'>");
		out.println("Session Invalidated Successfully");
		out.println("</h2>");

		out.println("<a href='sessionMethods'>");
		out.println("<button style='padding:10px 20px;'>");
		out.println("Start New Session");
		out.println("</button>");
		out.println("</a>");

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
