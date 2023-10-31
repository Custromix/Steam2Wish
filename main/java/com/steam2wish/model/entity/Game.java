package com.steam2wish.model.entity;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Game extends Entity{

    private int id;
    private Admin admin;
    private String name;
    private LocalDateTime releaseDate;
    private String description;
    private LocalDateTime addedDate;

    public Game(String newName, LocalDateTime newReleaseDate, String newDescription){
        this.setName(newName);
        this.setReleaseDate(newReleaseDate);
        this.setDescription(newDescription);
    }

    public Game(){}

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin newAdmin) {
        this.admin = newAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime newReleaseDate) {
        this.releaseDate = newReleaseDate;
    }

    public void setReleaseDate(String newReleaseDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(newReleaseDate, formatter);
        this.releaseDate = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAddedDate() {
        return this.addedDate;
    }

    public void setAddedDate(LocalDateTime newAddedDate) {
        this.addedDate = newAddedDate;
    }

    public void setAddedDate(String newAddedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(newAddedDate, formatter);
        this.addedDate = dateTime;
    }
}
