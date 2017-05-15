package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.JeuEntity;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by lafay on 15/05/2017.
 */
public class ServiceGame {
    public List<JeuEntity> getAll(){
        List<JeuEntity> mesActions = null;
        try{
            Session session = ServiceHibernate.currentSession();

            mesActions = session.createQuery("SELECT j FROM JeuEntity j order by id").getResultList();

            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mesActions;
    }

    public void save(JeuEntity jeuEntity){
        try{
            Session session = ServiceHibernate.currentSession();

            session.save(jeuEntity);

            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(JeuEntity jeuEntity){
        try{
            Session session = ServiceHibernate.currentSession();

            session.delete(jeuEntity);

            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
