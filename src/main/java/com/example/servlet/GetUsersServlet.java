package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static com.example.Constants.*;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Set<User> userSet = Warehouse.getInstance().getUsers();
        getServletContext().setAttribute(PARAM_USERS, userSet);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute(PARAM_USERS, getServletContext().getAttribute(PARAM_USERS));
        getServletContext().getRequestDispatcher(JSP_USERS_JSP).forward(req, resp);
    }
}
