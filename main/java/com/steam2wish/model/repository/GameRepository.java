package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Admin;
import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Game;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameRepository extends RepositoryGlobal implements RepositoryTemplate{

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> games = new ArrayList<>();

        try{
            PreparedStatement selectGame = myConnection.prepareStatement("SELECT * FROM games");
            ResultSet result = selectGame.executeQuery();
            while(result.next()) {
                Game newGame = new Game();
                newGame.setId(Integer.parseInt(result.getString(1)));
                Admin newAdmin = new Admin();
                newAdmin.setId(Integer.parseInt(result.getString(2)));
                newGame.setAdmin(newAdmin);
                newGame.setReleaseDate(result.getString(3));
                newGame.setDescription(result.getString(4));
                newGame.setAddedDate(result.getString(4));
                games.add(newGame);
            }
        }catch (SQLException e){
            error = e.getMessage();
        }

        return games;
    }

    @Override
    public Entity get(int id) {
        Game newGame = new Game();

        try{
            PreparedStatement selectGame = myConnection.prepareStatement("SELECT * FROM games WHERE ID_GAMES = ?");
            selectGame.setString(1, String.valueOf(id));
            ResultSet result = selectGame.executeQuery();
            while(result.next()) {
                newGame.setId(Integer.parseInt(result.getString(1)));
                Admin newAdmin = new Admin();
                newAdmin.setId(Integer.parseInt(result.getString(2)));
                newGame.setAdmin(newAdmin);
                newGame.setReleaseDate(result.getString(3));
                newGame.setDescription(result.getString(4));
                newGame.setAddedDate(result.getString(4));
            }
        }catch (SQLException e){
            error = e.getMessage();
        }

        return newGame;
    }

    @Override
    public boolean add(Entity newEntity) {
        Game newGame = (Game)newEntity;
        boolean isInsert = true;

        try{
            PreparedStatement insertGame = myConnection.prepareStatement("INSERT INTO games(ID_ADMIN, NAME, RELEASED_DATE, DESCRIPTION, ADDED_DATE) VALUES (?,?,?,?,?)");
            insertGame.setString(1, String.valueOf(newGame.getAdmin().getId()));
            insertGame.setString(2, newGame.getName());
            insertGame.setString(3, newGame.getReleaseDate().toString());
            insertGame.setString(4, newGame.getDescription());
            insertGame.setString(5, newGame.getAddedDate().toString());
            insertGame.executeUpdate();

        }catch (SQLException e){
            error = e.getMessage();
            isInsert = false;
        }

        return isInsert;
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }
}
