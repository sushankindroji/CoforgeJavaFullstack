package com.cofrge.training.hibernateweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import com.cofrge.training.hibernateweb.dao.UserDAO;
import com.cofrge.training.hibernateweb.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
 
    public UserServlet() {
        super();
        dao=new UserDAO();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String[] skills = request.getParameterValues("skills");

        User user = new User();
        user.setName(name);
        if (skills != null) user.setSkills(Arrays.asList(skills));

        dao.save(user); 
        response.sendRedirect("listUsers.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
