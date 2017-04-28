package com.simulateurPermis.services;

import com.simulateurPermis.entities.ActionEntity;
import com.simulateurPermis.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sachouw on 25/04/2017.
 */
@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Transactional
    public void add(ActionEntity action) {
        actionRepository.add(action);
    }

    @Transactional
    public List<ActionEntity> getAll() {
        return actionRepository.getAll();
    }

    @Transactional
    public void delete(Integer actionId) {
        actionRepository.delete(actionId);
    }

    public void setRepository(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }
}
