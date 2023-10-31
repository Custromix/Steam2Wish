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

@WebServlet(name = "userManager", value = "/userManager")
public class PlayerListController extends Controller {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        PlayerRepository rep = new PlayerRepository();
        ArrayList<Entity> players = new ArrayList<>();
        ArrayList<Player> betterplayer =new ArrayList<>();
        players = rep.getAll();
        Player p = (Player)players.get(0);

        for ( Entity e:players) {
            betterplayer.add((Player)e);
        }
        request.setAttribute("Player",betterplayer);

        this.getServletContext().getRequestDispatcher("/Auth/User/userManager.jsp").forward(request,response);
    }
    public void destroy() {
    }
}
