package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.dto.CommentDto;
import fr.epsi.TopIdea.dto.IdeaDto;
import fr.epsi.TopIdea.entity.Category;
import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.service.ICategoryService;
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

@WebServlet(name = "addCommentServlet", value = "/auth/comment")
public class AddCommentServlet extends HttpServlet {

    @EJB
    private ICommentService commentService;

    @EJB
    private IIdeaService ideaService;

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

        if (idea == null) {
            request.setAttribute("message", "Impossible de trouver cette idee.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }
        request.setAttribute("idea", idea);

        this.getServletContext().getRequestDispatcher("/pages/formComment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.findByName(request.getUserPrincipal().getName());
        if (!user.isActive()) {
            request.setAttribute("message", "Votre compte a été désactivé.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        Long id = Long.parseLong(request.getParameter("id"));

        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(request.getUserPrincipal().getName());
        commentDto.setIdea(id);
        commentDto.setText(request.getParameter("text"));

        commentService.addComment(commentDto);

        request.setAttribute("message", "Votre commentaire a été enregistré.");
        this.getServletContext().getRequestDispatcher("/pages/validation.jsp").forward(request, response);
    }
}
