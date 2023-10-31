package com.steam2wish.model.entity;

import com.utils.BCryptManager;

import java.util.ArrayList;

public class Admin {
    private int id;
    private String username;
    private String password;

    public Admin(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptManager bcrypt = new BCryptManager();
        this.password = bcrypt.hash(password);
    }

}
