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

@WebServlet(name = "userServlet", value = "/admin/user")
public class UserServlet extends HttpServlet {

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User admin = userService.findByName(request.getUserPrincipal().getName());
        if (!admin.isActive()) {
            request.setAttribute("message", "Votre compte a été désactivé.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.findOne(id);
        request.setAttribute("user", user);

        request.setAttribute("admin", user.isAdmin());

        this.getServletContext().getRequestDispatcher("/pages/user.jsp").forward(request, response);
    }
}