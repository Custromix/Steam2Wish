package com.steam2wish.controller.authenticator.user;

import com.steam2wish.controller.Controller;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.repository.authenticator.user.AuthenticatorUserRepository;
import com.utils.BCryptManager;

import javax.servlet.http.HttpServlet;

public abstract class AuthenticatorUserController extends Controller {
    protected AuthenticatorUserRepository authUser = new AuthenticatorUserRepository();
    protected BCryptManager bCryptManager = new BCryptManager();
    protected Player player;
}
