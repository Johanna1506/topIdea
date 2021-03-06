package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.Comment;
import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.service.ICommentService;
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

@WebServlet(name = "ideaServlet", value = "/auth/idea")
public class IdeaServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @EJB
    private ICommentService commentService;

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.findByName(request.getUserPrincipal().getName());
        if (!user.isActive()) {
            request.setAttribute("message", "Votre compte a été désactivé.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        Long id = Long.parseLong(request.getParameter("id"));
        Idea idea = ideaService.findOne(id);
        String author = idea.getAuthor().getUsername();
        String category = idea.getCategory().getName();

        List<Comment> comments = commentService.getComments(idea);

        request.setAttribute("idea", idea);
        request.setAttribute("author", author);
        request.setAttribute("category", category);
        request.setAttribute("comments", comments);

        this.getServletContext().getRequestDispatcher("/pages/idea.jsp").forward(request, response);
    }
}