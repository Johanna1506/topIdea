package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.dto.IdeaDto;
import fr.epsi.TopIdea.entity.Category;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.service.ICategoryService;
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

@WebServlet(name = "addIdeaServlet", value = "/auth/newidea")
public class AddIdeaServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @EJB
    private ICategoryService categoryService;

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.findByName(request.getUserPrincipal().getName());
        if (!user.isActive()) {
            request.setAttribute("message", "Votre compte a été désactivé.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        List<Category> categories = this.categoryService.findAll();
        request.setAttribute("categories", categories);

        this.getServletContext().getRequestDispatcher("/pages/formIdea.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.findByName(request.getUserPrincipal().getName());
        if (!user.isActive()) {
            request.setAttribute("message", "Votre compte a été désactivé.");
            this.getServletContext().getRequestDispatcher("/pages/nope.jsp").forward(request, response);
        }

        IdeaDto ideaDto = new IdeaDto();
        ideaDto.setTitle(request.getParameter("title"));
        ideaDto.setCategory(request.getParameter("category"));
        ideaDto.setDescription(request.getParameter("description"));
        ideaDto.setImage(request.getParameter("image"));
        ideaDto.setAuthor(request.getUserPrincipal().getName());

        ideaService.create(ideaDto);

        request.setAttribute("message", "Votre idée a été enregistrée.");
        this.getServletContext().getRequestDispatcher("/pages/validation.jsp").forward(request, response);
    }
}
