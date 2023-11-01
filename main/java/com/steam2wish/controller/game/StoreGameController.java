package com.steam2wish.controller.game;

import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Game;
import com.steam2wish.model.repository.GameRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "store", value = "/store")
public class StoreGameController extends GameController {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Entity> games = gameRepository.getAll();
        request.setAttribute("games", games);
        this.getServletContext().getRequestDispatcher("/Game/store.jsp").forward(request, response);


    }

    public void destroy() {
    }
}
