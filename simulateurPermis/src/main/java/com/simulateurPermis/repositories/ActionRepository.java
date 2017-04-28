package com.simulateurPermis.repositories;


import com.simulateurPermis.dao.ActionDAO;
import com.simulateurPermis.entities.ActionEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sachouw on 13/04/2017.
 */
@Repository
public class ActionRepository extends HibernateDaoSupport implements ActionDAO {

    public void add(ActionEntity action) {
        getHibernateTemplate().save(action);
    }

    public List<ActionEntity> getAll() {
        return (List<ActionEntity>) getHibernateTemplate().find("FROM ActionEntity");
    }

    public void delete(int actionId) {
        getHibernateTemplate().delete(actionId);
    }
}
