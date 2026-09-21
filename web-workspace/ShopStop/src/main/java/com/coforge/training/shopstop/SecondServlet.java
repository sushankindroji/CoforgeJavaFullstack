package com.coforge.training.shopstop;

import jakarta.servlet.ServletException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SecondServlet
 * 
 * Servlet program to demonstrate HttpServletRequest methods
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecondServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>HttpServletRequest Methods Demo</title>");
		out.println("</head>");
		out.println("<body style='font-family:Arial;'>");

		out.println("<h2>HttpServletRequest Methods Demo</h2>");
		out.println("<hr>");

		out.println("<b>Request Method :</b> " + request.getMethod() + "<br><br>");

		out.println("<b>Request URI :</b> " + request.getRequestURI() + "<br><br>");

		out.println("<b>Request URL :</b> " + request.getRequestURL() + "<br><br>");

		out.println("<b>Context Path :</b> " + request.getContextPath() + "<br><br>");

		out.println("<b>Servlet Path :</b> " + request.getServletPath() + "<br><br>");

		out.println("<b>Protocol :</b> " + request.getProtocol() + "<br><br>");

		out.println("<b>Server Name :</b> " + request.getServerName() + "<br><br>");

		out.println("<b>Server Port :</b> " + request.getServerPort() + "<br><br>");

		out.println("<b>Remote Host :</b> " + request.getRemoteHost() + "<br><br>");

		out.println("<b>Remote Address :</b> " + request.getRemoteAddr() + "<br><br>");

		out.println("<b>Remote Port :</b> " + request.getRemotePort() + "<br><br>");

		out.println("<b>Character Encoding :</b> " + request.getCharacterEncoding() + "<br><br>");

		out.println("<b>Content Type :</b> " + request.getContentType() + "<br><br>");

		out.println("<b>Locale :</b> " + request.getLocale() + "<br><br>");

		out.println("</body>");
		out.println("</html>");

		
		//Link to index.html
        out.println("<br><br><a href='index.html'>Go Back to Home Page</a>");
		out.close();

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
