package servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import dao.BookDAO;
import model.Book;

@WebServlet("/ViewBooksServlet")
public class ViewBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Book> books = new BookDAO().getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("viewBooks.jsp").forward(request, response);
    }
}