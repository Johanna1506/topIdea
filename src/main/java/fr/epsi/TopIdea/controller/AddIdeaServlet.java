package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.dto.IdeaDto;
import fr.epsi.TopIdea.service.IIdeaService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddIdeaServlet extends HttpServlet {

    @EJB
    private IIdeaService ideaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("username", "toto");
        this.getServletContext().getRequestDispatcher("/pages/formIdea.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IdeaDto ideaDto = new IdeaDto();
        ideaDto.setTitle(request.getParameter("title"));
        ideaDto.setCategory(request.getParameter("category"));
        ideaDto.setDescription(request.getParameter("description"));
        ideaDto.setImage(request.getParameter("image"));
        ideaDto.setAuthor(request.getSession().getAttribute("username").toString());

        ideaService.create(ideaDto);

        this.getServletContext().getRequestDispatcher("/pages/validation.jsp").forward(request, response);
    }
}
