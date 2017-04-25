package com.simulateurPermis.dao;

import com.simulateurPermis.entities.ActionEntity;

import java.util.List;

/**
 * Created by Sachouw on 25/04/2017.
 */
public interface ActionDAO {

    public void add(ActionEntity action);
    public List<ActionEntity> getAll();
    public void delete(int actionId);
}
