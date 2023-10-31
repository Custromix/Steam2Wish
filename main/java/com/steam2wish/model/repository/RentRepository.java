package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Game;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.entity.Rent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentRepository extends RepositoryGlobal implements RepositoryTemplate{

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> rents = new ArrayList<>();

        try{
            PreparedStatement selectPlayer = myConnection.prepareStatement("SELECT * FROM rent");
            ResultSet result = selectPlayer.executeQuery();
            while(result.next()) {
                Rent newRent = new Rent();

                Player newPlayer = new Player();
                newPlayer.setId(Integer.parseInt(result.getString(2)));
                Game newGame = new Game();
                newPlayer.setId(Integer.parseInt(result.getString(3)));

                newRent.setId(Integer.parseInt(result.getString(1)));
                newRent.setRentPlayer(newPlayer);
                newRent.setRentGame(newGame);
                newRent.setRentStartDate(result.getString(4));
                newRent.setRentEndDate(result.getString(5));
                rents.add(newRent);
            }
        }catch (SQLException e){
            error = e.getMessage();
        }

        return rents;
    }

    @Override
    public Rent get(int id) {
        Rent newRent = new Rent();

        try{
            PreparedStatement selectPlayer = myConnection.prepareStatement("SELECT * FROM rent WHERE ID_RENT = ?");
            selectPlayer.setString(1, String.valueOf(id));
            ResultSet result = selectPlayer.executeQuery();
            while(result.next()) {
                Player newPlayer = new Player();
                newPlayer.setId(Integer.parseInt(result.getString(2)));
                Game newGame = new Game();
                newPlayer.setId(Integer.parseInt(result.getString(3)));

                newRent.setId(Integer.parseInt(result.getString(1)));
                newRent.setRentPlayer(newPlayer);
                newRent.setRentGame(newGame);
                newRent.setRentStartDate(result.getString(4));
                newRent.setRentEndDate(result.getString(5));
            }
        }catch (SQLException e){
            error = e.getMessage();
        }

        return newRent;
    }

    @Override
    public boolean add(Entity newEntity) {
        Rent newRent = (Rent)newEntity;
        boolean isInsert = true;

        try{
            PreparedStatement insertGame = myConnection.prepareStatement("INSERT INTO rent(ID_MEMBERS, ID_GAMES, START_DATE, END_DATE) VALUES (?,?,?,?)");
            insertGame.setString(1, String.valueOf(newRent.getRentPlayer().getId()));
            insertGame.setString(2, String.valueOf(newRent.getRentGame().getId()));
            insertGame.setString(3, newRent.getRentStartDate().toString());
            insertGame.setString(4, newRent.getRentEndDate().toString());
            insertGame.executeUpdate();

        }catch (SQLException e){
            error = e.getMessage();
            isInsert = false;
        }

        return isInsert;
    }

    @Override
    public boolean edit(Entity newEntity) {
        Rent newRent = (Rent)newEntity;
        boolean isUpdate = true;

        try{
            PreparedStatement insertGame = myConnection.prepareStatement("UPDATE rent SET ID_MEMBERS = ?, ID_GAMES = ?, START_DATE = ?, END_DATE = ? WHERE ID_RENT = ?");
            insertGame.setString(1, String.valueOf(newRent.getRentPlayer().getId()));
            insertGame.setString(2, String.valueOf(newRent.getRentGame().getId()));
            insertGame.setString(3, newRent.getRentStartDate().toString());
            insertGame.setString(4, newRent.getRentEndDate().toString());
            insertGame.setString(5, String.valueOf(newRent.getId()));
            insertGame.executeUpdate();

        }catch (SQLException e){
            error = e.getMessage();
            isUpdate = false;
        }

        return isUpdate;
    }

    @Override
    public boolean remove() {
        return false;
    }
}
