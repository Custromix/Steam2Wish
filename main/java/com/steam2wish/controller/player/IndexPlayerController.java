package com.steam2wish.controller.player;

import com.steam2wish.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profil", value = "/profil")
public class IndexPlayerController extends Controller {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
    public void destroy() {
    }
}