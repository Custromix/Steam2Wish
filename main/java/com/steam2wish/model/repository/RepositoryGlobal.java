package com.steam2wish.model.repository;

import com.utils.ConnectionManager;

import java.sql.Connection;

public abstract class RepositoryGlobal{
    protected Connection myConnection;
    public String error;

    public RepositoryGlobal() {
        myConnection = ConnectionManager.getConnection();
    }
}