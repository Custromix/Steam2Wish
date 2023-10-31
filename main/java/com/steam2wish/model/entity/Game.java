package com.steam2wish.model.entity;

import java.util.Date;

public class Game extends Entity{
    private String name;
    private Date releaseDate;
    private String description;

    public Game(String newName, Date newReleaseDate, String newDescription){
        this.setName(newName);
        this.setReleaseDate(newReleaseDate);
        this.setDescription(newDescription);
    }

    public Game(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
