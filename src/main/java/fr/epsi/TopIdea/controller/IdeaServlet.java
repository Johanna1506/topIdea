package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.service.IIdeaService;
import fr.epsi.TopIdea.service.IUserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ideaServlet", value = "/idea")
public class IdeaServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Idea idea = ideaService.findOne(id);
        request.setAttribute("idea", idea);

        this.getServletContext().getRequestDispatcher("/pages/idea.jsp").forward(request, response);
    }
}