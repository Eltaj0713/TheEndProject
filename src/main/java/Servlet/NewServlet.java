package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

import java.io.IOException;

@WebServlet(name = "NewServlet", value = "/NewServlet")
public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameterMap().containsKey("name")?req.getParameter("name"):"underfined";
        int age=req.getParameterMap().containsKey("age")?Integer.parseInt(req.getParameter("age")):null;

        var customer=new Customer(name,age);
        req.setAttribute("customer",customer);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,resp);

    }
}
