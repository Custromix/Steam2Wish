package com.steam2wish.model.repository.authenticator.admin;

import com.steam2wish.model.entity.Admin;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.repository.RepositoryGlobal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthenticatorAdminRepository extends RepositoryGlobal{
    public AuthenticatorAdminRepository(){}

    public String[] getPotentialAdmin(Admin potentialAdmin){
        String[] adminData = {"",""};

        try{
            PreparedStatement selectAdmin = myConnection.prepareStatement("SELECT ID_PLAYERS, PASSWORD FROM players WHERE USERNAME = ?");
            selectAdmin.setString(1, potentialAdmin.getUsername());
            ResultSet result = selectAdmin.executeQuery();
            while(result.next()) {
                adminData[0] = result.getString(1);
                adminData[1] = result.getString(2);
            }

        }catch (Exception e){
            error = e.getMessage();
            adminData[0] = "-1";
            adminData[1] = "-1";
        }

        return adminData;
    }

}
