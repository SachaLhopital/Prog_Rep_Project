package com.simulateurPermis.services;

import com.simulateurPermis.dao.ActionDAO;
import com.simulateurPermis.entities.ActionEntity;
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
    private ActionDAO actionDAO;

    @Transactional
    public void add(ActionEntity action) {
        actionDAO.add(action);
    }

    @Transactional
    public List<ActionEntity> getAll() {
        return actionDAO.getAll();
    }

    @Transactional
    public void delete(Integer actionId) {
        actionDAO.delete(actionId);
    }

    public void setActionDAO(ActionDAO actionDAO) {
        this.actionDAO = actionDAO;
    }
}
