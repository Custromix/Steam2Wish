package com.utils;

import java.sql.*;

public final class ConnectionManager{
    private static ConnectionManager instance;
    private static Connection mysqlConnection;
    private static String erreur;

    private ConnectionManager() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/steam2wish", "root", "");
        }catch (Exception e){
            erreur = e.getMessage();
        }
    }

    public static Connection getConnection() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return mysqlConnection;
    }

}
