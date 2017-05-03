package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.ActionEntity;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by lafay on 03/05/2017.
 */
public class ServiceAction {
    public List<ActionEntity> getAll(){
        List<ActionEntity> mesActions = null;
        try{
            Session session = ServiceHibernate.currentSession();

            mesActions = session.createQuery("SELECT a FROM ActionEntity a order by id").getResultList();

            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mesActions;

    }
}
