package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Player;
import com.steam2wish.model.entity.Rent;

import java.util.ArrayList;

public class RentRepository extends RepositoryTemplate{

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> rents = new ArrayList<>();
        return rents;
    }

    @Override
    public Rent get(int id) {
        Rent rent = new Rent();
        return rent;
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
