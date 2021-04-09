package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.voteValue;
import fr.epsi.TopIdea.service.IIdeaService;
import fr.epsi.TopIdea.service.IUserService;
import fr.epsi.TopIdea.service.IVoteService;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "voteServlet", value = "/vote")
public class VoteServlet extends HttpServlet {

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
            request.setAttribute("message", "Impossible de trouver cette idee.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        String username = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "camille";
        String voteName = request.getParameter("vote");

        try {
            User user = userService.findByName(username);
            voteValue vote = voteValue.valueOf(voteName);
            voteService.addVote(user, idea, vote);
            request.setAttribute("idea", idea);
            this.getServletContext().getRequestDispatcher("/pages/voteConfirmation.jsp").forward(request, response);
        } catch(NoResultException e) {
            request.setAttribute("message", "Cet utilisateur n'existe pas.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }
        catch(Exception e) {
            String message = e.getMessage().substring(e.getMessage().indexOf(':')+1).trim();
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }
    }
}