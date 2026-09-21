package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import dao.BookDAO;
import model.*;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String type = request.getParameter("bookType");
        Book book;
        
        if ("Printed".equals(type)) {
            PrintedBook pb = new PrintedBook();
            pb.setPages(Integer.parseInt(request.getParameter("pages")));
            pb.setShelfNo(request.getParameter("shelfNo"));
            pb.setEdition(request.getParameter("edition"));
            book = pb;
        } else {
            EBook eb = new EBook();
            eb.setFileFormat(request.getParameter("fileFormat"));
            eb.setFileSize(Double.parseDouble(request.getParameter("fileSize")));
            eb.setDownloadLink(request.getParameter("downloadLink"));
            book = eb;
        }
        
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setPublisher(request.getParameter("publisher"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPrice(Double.parseDouble(request.getParameter("price")));
        book.setCategory(request.getParameter("category"));
        
        new BookDAO().saveBook(book);
        response.sendRedirect("ViewBooksServlet");
    }
}