package com.steam2wish.controller.player;


import com.steam2wish.controller.Controller;
import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.repository.PlayerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "usergame", value = "/usergame")
public class PlayerListController extends Controller {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        PlayerRepository rep = new PlayerRepository();
        ArrayList<Entity> players = new ArrayList<>();
        players = rep.getAll();
        request.setAttribute("Player", (Player)players.get(0));
        this.getServletContext().getRequestDispatcher("/Auth/User/usergame.jsp").forward(request,response);
    }
    public void destroy() {
    }
}