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

@WebServlet(name = "updateUserServlet", value = "/admin/update")
public class UpdateUserServlet extends HttpServlet {

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            User admin = userService.findByName(request.getUserPrincipal().getName());
            if (!admin.isActive()) {
                throw new RuntimeException("Votre compte a été désactivé.");
            }

            Long id = Long.parseLong(request.getParameter("id"));
            User user = userService.findOne(id);

            if (admin.getId().equals(user.getId())) {
                throw new IllegalArgumentException("Vous ne pouvez pas gérer votre propre compte.");
            }

            String message;

            String action = request.getParameter("action");
            switch (action) {
                case "activate":
                    userService.activate(user);
                    message = "L'utilisateur a été activé.";
                    break;
                case "deactivate":
                    userService.deactivate(user);
                    message = "L'utilisateur a été désactivé.";
                    break;
                case "suppress":
                    userService.delete(user);
                    message = "L'utilisateur a été supprimé.";
                    break;
                default:
                    throw new IllegalArgumentException("Action inconnue.");
            }

            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/pages/validation.jsp").forward(request, response);
        } catch(Exception e) {
            String message = e.getMessage().substring(e.getMessage().indexOf(':')+1).trim();
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }
    }
}