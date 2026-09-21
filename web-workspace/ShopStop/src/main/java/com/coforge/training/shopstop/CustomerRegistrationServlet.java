package com.coforge.training.shopstop;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CustomerRegistrationServlet
 */
@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("cid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");

		String[] categories = request.getParameterValues("category");

		String selectedCategories;

		if (categories != null) {
			selectedCategories = String.join(", ", categories);
		} else {
			selectedCategories = "No Category Selected";
		}

		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		request.setAttribute("city", city);
		request.setAttribute("categories", selectedCategories);
		request.setAttribute("rdate", new java.util.Date().toString());

		RequestDispatcher rd =
				request.getRequestDispatcher("rsuccess.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
