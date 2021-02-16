package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;

import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/")
public class HomeServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Idea> tops = this.ideaService.findTops();
        request.setAttribute("tops", tops);

        List<User> brains = this.userService.findBrains();
        request.setAttribute("brains", brains);

        List<Idea> buzz = this.ideaService.findBuzz();
        request.setAttribute("buzz", buzz);

        this.getServletContext().getRequestDispatcher("pages/home.jsp").forward(request, response);

    }
}