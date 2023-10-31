package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Entity;
import com.steam2wish.model.entity.Game;
import com.steam2wish.model.entity.Player;

import java.util.ArrayList;

public class GameRepository extends RepositoryTemplate{

    @Override
    public ArrayList<Entity> getAll() {
        ArrayList<Entity> games = new ArrayList<>();
        return games;
    }

    @Override
    public Entity get(int id) {
        Game game= new Game();
        return game;
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
