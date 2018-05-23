/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstldemo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jstldemo.model.Book;

/**
 *
 * @author PC
 */
@WebServlet
(
        urlPatterns = {"/books"}
)
public class BookServlet extends HttpServlet
{
    private static final int serialVersionUID = -234237;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("978-0980839616", "Java 7: A Beginner's Tutorial", 45.00);
        Book book2 = new Book("978-0980331608", "Struts 2 Design and Programming: A Tutorial", 49.95);
        Book book3 = new Book("978-0975212820", "Dimensional Data WareHouse with MySql: A Tutorial", 39.35);
        
        books.add(book1);
        books.add(book2);
        books.add(book3);
        
        request.setAttribute("books", books);
        RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
        rd.forward(request, response);
    }
}
