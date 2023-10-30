package com.steam2wish.model.entity;

import java.util.ArrayList;

public class Player {
    private String name;
    private String firstname;
    private String username;
    private ArrayList<Game> rentGames = new ArrayList<Game>();

    public Player(String newName, String newFirstname, String newUsername){
        this.setName(newName);
        this.setFirstname(newFirstname);
        this.setUsername(newUsername);
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

    public ArrayList<Game> getRentGames() {
        return this.rentGames;
    }

    public ArrayList<Game> addGames(Game newGames) {
        this.rentGames.add(newGames);
        return this.rentGames;
    }
}
