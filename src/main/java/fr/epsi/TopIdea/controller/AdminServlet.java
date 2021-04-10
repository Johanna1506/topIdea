package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.service.IUserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "adminServlet", value = "/admin/dashboard")
public class AdminServlet extends HttpServlet {

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<List<User>> sorted = this.userService.sortUsersByRole();
        List<User> admins = sorted.get(0);
        List<User> users = sorted.get(1);

        request.setAttribute("admins", admins);
        request.setAttribute("users", users);

        this.getServletContext().getRequestDispatcher("/pages/users.jsp").forward(request, response);
    }
}
