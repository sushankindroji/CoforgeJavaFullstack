package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import dao.UserDAO;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirmPassword");
        
        UserDAO dao = new UserDAO();
        
        if (!password.equals(confirm)) {
            request.setAttribute("error", "Passwords do not match!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        if (dao.isEmailExists(email)) {
            request.setAttribute("error", "Email already exists!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setPassword(password);
        
        if (dao.register(user)) {
            request.setAttribute("message", "Registration Successful!");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Registration Failed!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}