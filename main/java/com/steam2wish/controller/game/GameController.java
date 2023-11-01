package com.steam2wish.controller.game;

import com.steam2wish.controller.Controller;
import com.steam2wish.model.entity.Game;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.repository.GameRepository;
import com.steam2wish.model.repository.authenticator.user.AuthenticatorUserRepository;
import com.utils.BCryptManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class GameController extends Controller {
    protected GameRepository gameRepository = new GameRepository();
    protected Game game;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        if (session.getAttribute("id") != null){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}