package com.simulateurPermis.dao;

import com.simulateurPermis.entities.ActionEntity;

import java.util.List;

/**
 * Created by Sachouw on 25/04/2017.
 */
public interface ActionDAO {

    void add(ActionEntity action);
    List<ActionEntity> getAll();
    void delete(int actionId);
}
