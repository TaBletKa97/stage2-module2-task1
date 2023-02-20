package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.Constants.*;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher(JSP_ADD_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter(PARAM_FIRST_NAME);
        String lastName = req.getParameter(PARAM_LAST_NAME);
        User user = new User(firstName, lastName);
        req.setAttribute(PARAM_USER, user);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.addUser(user);
        getServletContext().getRequestDispatcher(JSP_ADD_JSP).forward(req, resp);
    }
}
