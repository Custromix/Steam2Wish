package com.steam2wish.controller.authenticator.user;

import com.steam2wish.model.entity.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class AuthenticatorRegisterController extends AuthenticatorUserController {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        this.getServletContext().getRequestDispatcher("/Auth/User/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        player = new Player();

        player.setFirstname(request.getParameter("firstname"));
        player.setName(request.getParameter("name"));
        player.setUsername(request.getParameter("username"));
        player.setPassword(request.getParameter("password"));

        if(authUser.addUser(player)){
            this.getServletContext().getRequestDispatcher("/Auth/User/login.jsp").forward(request, response);
        }else{
            this.getServletContext().getRequestDispatcher("/Auth/User/register.jsp").forward(request, response);
        }
    }


    public void destroy() {
    }
}