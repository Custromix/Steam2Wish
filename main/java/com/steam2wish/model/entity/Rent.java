package com.steam2wish.model.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Rent extends Entity{
    private int id;
    private Player rentPlayer;
    private Game rentGame;
    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;

    public Rent(Player newPlayer, Game newGame, Date newEndDate){
        this.setRentPlayer(newPlayer);
        this.setRentGame(newGame);
        this.rentStartDate = LocalDateTime.now();
        this.setRentEndDate(newEndDate);
    }

    public Rent(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Player getRentPlayer() {
        return this.rentPlayer;
    }

    public void setRentPlayer(Player newRentPlayer) {
        this.rentPlayer = newRentPlayer;
    }

    public Game getRentGame() {
        return this.rentGame;
    }

    public void setRentGame(Game newRentGame) {
        this.rentGame = newRentGame;
    }

    public LocalDateTime getRentStartDate() {
        return this.rentStartDate;
    }

    public void setRentStartDate(LocalDateTime newRentStartDate) {
        this.rentStartDate = newRentStartDate;
    }
    public void setRentStartDate(String newRentStartDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(newRentStartDate, formatter);
        this.rentStartDate = dateTime;
    }

    public LocalDateTime getRentEndDate() {
        return this.rentEndDate;
    }

    public void setRentEndDate(LocalDateTime newRentEndDate) {
        this.rentEndDate = newRentEndDate;
    }
    public void setRentEndDate(String newRentEndDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(newRentEndDate, formatter);
        this.rentEndDate = dateTime;
    }
}
