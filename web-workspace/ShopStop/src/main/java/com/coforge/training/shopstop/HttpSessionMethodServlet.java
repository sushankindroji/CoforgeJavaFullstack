package com.coforge.training.shopstop;

import jakarta.servlet.ServletException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class HttpSessionMethodServlet
 */
@WebServlet("/sessionMethods")
public class HttpSessionMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HttpSessionMethodServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// Create or retrieve existing session
		HttpSession session = request.getSession();

		// Store session attributes
		session.setAttribute("username", "Rajashekar");
		session.setAttribute("course", "Java Full Stack");
		session.setAttribute("city", "Mangalore");

		// ------- Session Visit Counter -------
		Integer count = (Integer) session.getAttribute("count");

		if (count == null) {
			count = 1;
		} else {
			count++;
		}

		session.setAttribute("count", count);

		out.println("<html>");
		out.println("<head>");
		out.println("<title>HttpSession Methods Demo</title>");
		out.println("</head>");

		out.println("<body style='font-family:Arial;background:#f4f4f4;'>");

		out.println("<div style='width:650px;margin:40px auto;"
				+ "background:white;padding:20px;"
				+ "border-radius:10px;"
				+ "box-shadow:0px 0px 10px gray;'>");

		out.println("<h2 style='color:blue;text-align:center;'>");
		out.println("HttpSession Methods Demonstration");
		out.println("</h2><hr>");

		out.println("<b>Session ID :</b>"
				+ session.getId() + "<br><br>");

		out.println("<b>Username :</b>"
				+ session.getAttribute("username") + "<br><br>");

		out.println("<b>Course :</b> "
				+ session.getAttribute("course") + "<br><br>");

		out.println("<b>City :</b> "
				+ session.getAttribute("city") + "<br><br>");

		out.println("<b>Creation Time :</b> "
				+ new Date(session.getCreationTime()) + "<br><br>");

		out.println("<b>Last Accessed Time :</b> "
				+ new Date(session.getLastAccessedTime()) + "<br><br>");

		out.println("<b>Max Inactive Interval :</b> "
				+ session.getMaxInactiveInterval()
				+ " Seconds<br><br>");

		out.println("<b>Is New Session :</b> "
				+ session.isNew() + "<br><br>");

		out.println("<h3 style='color:green;'>");
		out.println("Page Refresh Count : " + count);
		out.println("</h3>");

		out.println("<br>");

		out.println("<a href='logout'>");
		out.println("<button style='padding:10px 20px;"
				+ "background:red;color:white;"
				+ "border:none;border-radius:5px;'>");
		out.println("Logout");
		out.println("</button>");
		out.println("</a>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
