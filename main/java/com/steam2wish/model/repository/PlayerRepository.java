package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.entity.Rent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerRepository extends RepositoryGlobal implements RepositoryTemplate{

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> players = new ArrayList<>();
        try{
            PreparedStatement selectPlayer = myConnection.prepareStatement("SELECT * FROM members");
            ResultSet result = selectPlayer.executeQuery();
            while(result.next()) {
                Player newPlayer = new Player();
                newPlayer.setId(Integer.parseInt(result.getString(1)));
                newPlayer.setName(result.getString(2));
                newPlayer.setFirstname(result.getString(3));
                newPlayer.setUsername(result.getString(4));
                players.add(new Player());
            }
        }catch (SQLException e){
            error = e.getMessage();
        }
        return players;
    }

    @Override
    public Player get(int id) {
        Player player = new Player();

        try{
            PreparedStatement selectPlayer = myConnection.prepareStatement("SELECT * FROM members WHERE ID_MEMBERS = ?");
            selectPlayer.setString(1, String.valueOf(id));
            ResultSet result = selectPlayer.executeQuery();
            while(result.next()) {
                player.setId(Integer.parseInt(result.getString(1)));
                player.setName(result.getString(2));
                player.setFirstname(result.getString(3));
                player.setUsername(result.getString(4));
            }
        }catch (SQLException e){
            error = e.getMessage();
        }

        return player;
    }

    @Override
    public boolean add(Entity newEntity) {
        return false;
    }

    @Override
    public boolean edit(Entity newEntity) {
        Player newPlayer = (Player) newEntity;
        boolean isUpdate = true;

        try{
            PreparedStatement insertGame = myConnection.prepareStatement("UPDATE members SET NAME = ?, FIRSTNAME = ?, USERNAME = ?, WHERE ID_MEMBERS = ?");
            insertGame.setString(1, newPlayer.getName());
            insertGame.setString(2, newPlayer.getFirstname());
            insertGame.setString(3, newPlayer.getUsername().toString());
            insertGame.setString(4, String.valueOf(newPlayer.getId()));
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
