package com.steam2wish.model.entity;

import java.util.Date;

public class Rent {
    private Player rentPlayer;
    private Game rentGame;
    private Date rentStartDate;
    private Date rentEndDate;

    public Rent(Player newPlayer, Game newGame, Date newEndDate){
        this.setRentPlayer(newPlayer);
        this.setRentGame(newGame);
        this.rentStartDate = new Date();
        this.setRentEndDate(newEndDate);
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

    public Date getRentStartDate() {
        return this.rentStartDate;
    }

    public void setRentStartDate(Date newRentStartDate) {
        this.rentStartDate = newRentStartDate;
    }

    public Date getRentEndDate() {
        return this.rentEndDate;
    }

    public void setRentEndDate(Date newRentEndDate) {
        this.rentEndDate = newRentEndDate;
    }
}
