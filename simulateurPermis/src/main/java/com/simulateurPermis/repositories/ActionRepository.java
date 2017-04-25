package com.simulateurPermis.repositories;


import com.simulateurPermis.dao.ActionDAO;
import com.simulateurPermis.entities.ActionEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sachouw on 13/04/2017.
 */
@Repository
public class ActionRepository implements ActionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(ActionEntity action) {
        this.sessionFactory.getCurrentSession().save(action);
    }

    public List<ActionEntity> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from ActionEntity ").list();
    }

    public void delete(int actionId) {
        ActionEntity action = (ActionEntity) sessionFactory.getCurrentSession().load(
                ActionEntity.class, actionId);
        if (null != action) {
            this.sessionFactory.getCurrentSession().delete(action);
        }
    }
}
