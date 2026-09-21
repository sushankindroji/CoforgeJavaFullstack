package com.coforge.training.shopstop;

import jakarta.servlet.ServletException;
import java.time.LocalDateTime;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String company = "Coforge Technologies";
        LocalDateTime dateTime = LocalDateTime.now();

        // Static Login Validation
        if(username.equals("admin") && password.equals("admin123")) {
            
            request.setAttribute("user", username);
            request.setAttribute("company", company);
            request.setAttribute("loginDateTime", dateTime);

            // Forwarding to success.jsp
            request.getRequestDispatcher("success.jsp")
                   .forward(request, response);
        }
        else {
            // Fixed here
            RequestDispatcher rd = request.getRequestDispatcher("failure.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}