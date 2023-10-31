package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerRepository extends RepositoryTemplate{

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> allPlayer = new ArrayList<>();
        return allPlayer;
    }

    @Override
    public Player get(int id) {
        try{
            PreparedStatement selectPlayer = myConnection.prepareStatement("SELECT * FROM players WHERE ID_PLAYERS = ?");
            selectPlayer.setString(1, String.valueOf(id));
            ResultSet result = selectPlayer.executeQuery();
            while(result.next()) {
                //hashedPassword = result.getString(1);
            }
        }catch (SQLException e){
            error = e.getMessage();
        }

        return new Player();
    }

    @Override
    public boolean add() {
        return false;
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
