package com.steam2wish.model.repository;

import com.steam2wish.model.entity.Entity;

import java.util.ArrayList;

public interface RepositoryTemplate {
    public abstract ArrayList<Entity> getAll();
    public abstract Entity get(int id);
    public abstract boolean add(Entity newEntity);
    public abstract boolean edit();
    public abstract boolean remove();
}
