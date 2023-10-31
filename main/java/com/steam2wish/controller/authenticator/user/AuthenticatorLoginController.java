package com.steam2wish.controller.authenticator.user;

import com.steam2wish.model.entity.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class AuthenticatorLoginController extends AuthenticatorUserController {
    Player player;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        this.getServletContext().getRequestDispatcher("/Auth/User/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        player = new Player();

        player.setUsername(request.getParameter("username"));

        String[] playerData = authUser.getPotentialUser(player);

        if(playerData[1] != ""){
            if(bCryptManager.verifyHash(request.getParameter("password"), playerData[1])){
                session.setAttribute("id", playerData[0]);
                session.setAttribute("username", player.getUsername());
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            }else{
                this.getServletContext().getRequestDispatcher("/Auth/User/login.jsp").forward(request,response);
            }
        }else{
            this.getServletContext().getRequestDispatcher("/Auth/User/login.jsp").forward(request,response);
        }
    }
    public void destroy() {
    }
}