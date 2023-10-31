package com.steam2wish.model.entity;

import com.utils.BCryptManager;

import java.util.ArrayList;

public class Player extends Entity{
    private int id;
    private String name;
    private String firstname;
    private String username;
    private String password;
    private ArrayList<Game> rentGames = new ArrayList<Game>();

    public Player(String newName, String newFirstname, String newUsername){
        this.setName(newName);
        this.setFirstname(newFirstname);
        this.setUsername(newUsername);
    }

    public Player(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName.toUpperCase();
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String newFirstname) {
        this.firstname = newFirstname.substring(0,1).toUpperCase() + newFirstname.substring(1).toLowerCase();
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

    public ArrayList<Game> getRentGames() {
        return this.rentGames;
    }

    public ArrayList<Game> addGames(Game newGames) {
        this.rentGames.add(newGames);
        return this.rentGames;
    }

}
