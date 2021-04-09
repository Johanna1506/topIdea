package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.service.IIdeaService;
import fr.epsi.TopIdea.service.IUserService;

import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Idea> tops = this.ideaService.getTops();
        request.setAttribute("tops", tops);

        List<User> brains = this.userService.getBrains();
        request.setAttribute("brains", brains);

        List<Idea> buzz = this.ideaService.getBuzz();
        request.setAttribute("buzz", buzz);

//        System.out.println(request.getUserPrincipal());
//        System.out.println(request.isUserInRole("ADMIN"));

        this.getServletContext().getRequestDispatcher("/pages/home.jsp").forward(request, response);
    }
}