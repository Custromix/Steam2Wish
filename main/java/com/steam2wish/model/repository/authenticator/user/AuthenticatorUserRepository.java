package com.steam2wish.model.repository.authenticator.user;

import com.steam2wish.model.entity.Player;
import com.steam2wish.model.repository.RepositoryGlobal;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class AuthenticatorUserRepository extends RepositoryGlobal {

    public AuthenticatorUserRepository(){}

    public String[] getPotentialUser(Player newPlayer){
        String[] playerData = {"",""};

        try{
            PreparedStatement selectPlayer = myConnection.prepareStatement("SELECT ID_MEMBERS, PASSWORD FROM members WHERE USERNAME = ?");
            selectPlayer.setString(1, newPlayer.getUsername());
            ResultSet result = selectPlayer.executeQuery();
            while(result.next()) {
                playerData[0] = result.getString(1);
                playerData[1] = result.getString(2);
            }

        }catch (Exception e){
            error = e.getMessage();
            playerData[0] = "-1";
            playerData[1] = "-1";
        }

        return playerData;
    }

    public boolean addUser(Player newPlayer){
        boolean queryState = true;

        try{
            PreparedStatement insertPlayer = myConnection.prepareStatement("INSERT INTO members(NAME, FIRSTNAME, USERNAME, PASSWORD) VALUES (?,?,?,?)");
            insertPlayer.setString(1, newPlayer.getName());
            insertPlayer.setString(2, newPlayer.getFirstname());
            insertPlayer.setString(3, newPlayer.getUsername());
            insertPlayer.setString(4, newPlayer.getPassword());
            insertPlayer.executeUpdate();
        }catch (Exception e){
            error = e.getMessage();
            queryState = false;
        }

        return queryState;
    }
}
