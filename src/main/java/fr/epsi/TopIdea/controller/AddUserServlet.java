package fr.epsi.TopIdea.controller;

import fr.epsi.TopIdea.dto.UserDto;
import fr.epsi.TopIdea.service.IUserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "signupServlet", value = "/signup")
public class AddUserServlet extends HttpServlet {

    @EJB
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/formUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto();
        userDto.setUsername(request.getParameter("username"));
        userDto.setPassword(request.getParameter("password"));

        userService.register(userDto);

        request.setAttribute("message", "Votre compte a été créé.");
        this.getServletContext().getRequestDispatcher("/pages/validation.jsp").forward(request, response);
    }
}
