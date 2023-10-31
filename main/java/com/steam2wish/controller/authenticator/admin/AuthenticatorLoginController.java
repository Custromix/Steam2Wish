package com.steam2wish.controller.authenticator.admin;

import com.steam2wish.controller.Controller;
import com.steam2wish.model.entity.Admin;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.repository.authenticator.admin.AuthenticatorAdminRepository;
import com.utils.BCryptManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "log-admin", value = "/log-admin")
public class AuthenticatorLoginController extends Controller {
    private AuthenticatorAdminRepository authAdmin;
    protected BCryptManager bCryptManager = new BCryptManager();
    private Admin admin;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/Auth/Admin/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        admin = new Admin();

        admin.setUsername(request.getParameter("username"));

        String[] playerData = authAdmin.getPotentialAdmin(admin);

        if(playerData[1] != ""){
            if(bCryptManager.verifyHash(request.getParameter("password"), playerData[1])){
                session.setAttribute("id", playerData[0]);
                session.setAttribute("username", admin.getUsername());
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