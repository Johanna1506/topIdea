package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.voteValue;
import fr.epsi.TopIdea.service.IIdeaService;
import fr.epsi.TopIdea.service.IUserService;
import fr.epsi.TopIdea.service.IVoteService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "topServlet", value = "/top")
public class TopServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @EJB
    private IUserService userService;

    @EJB
    private IVoteService voteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Idea idea = ideaService.findOne(id);

        if (idea == null) {
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        String username = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "camille";
        User user = userService.findByName(username);

        String voteName = request.getParameter("vote");
        try {
            voteValue vote = voteValue.valueOf(voteName);
            voteService.addVote(user, idea, vote);
        } catch(IllegalArgumentException e) {
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        this.getServletContext().getRequestDispatcher("/pages/ideas.jsp").forward(request, response);
    }
}