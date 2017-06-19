package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.ActionEntity;
import com.epul.entities.ObjectifEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Sachouw on 26/05/2017.
 */
public class Service {

    /***
     * Sauvegarde les objets en base
     * @param entityObject
     */
    public void save(Object entityObject){
        Session session = ServiceHibernate.currentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(entityObject);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    /***
     * Supprime un objet en base
     * @param entityObject
     */
    public void delete(Object entityObject){
        Session session = ServiceHibernate.currentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(entityObject);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
