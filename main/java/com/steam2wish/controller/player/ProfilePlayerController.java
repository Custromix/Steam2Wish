package com.steam2wish.controller.player;

import com.steam2wish.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profile", value = "/profile")
public class ProfilePlayerController extends Controller {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        this.getServletContext().getRequestDispatcher("/Player/profile.jsp").forward(request,response);
    }
    public void destroy() {
    }
}