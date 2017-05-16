package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.JeuEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lafay on 15/05/2017.
 */
public class ServiceGame {

    public List<JeuEntity> getAll(){
        List<JeuEntity> mesJeux = new ArrayList();
        try{
            Session session = ServiceHibernate.currentSession();

            List<JeuEntity> allGames = session.createQuery("SELECT j FROM JeuEntity j order by id").list();

            for (Iterator iterator1 = allGames.iterator(); iterator1.hasNext();){
                JeuEntity game = (JeuEntity) iterator1.next();
                mesJeux.add(game);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mesJeux;
    }

    public JeuEntity get(int id_jeu){
        JeuEntity jeu = null;
        try{
            Session session = ServiceHibernate.currentSession();
            jeu = (JeuEntity)session.createQuery("SELECT j FROM JeuEntity j where id= :id order by id").setParameter("id",id_jeu).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return jeu;

    }

    public void save(JeuEntity jeuEntity){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(jeuEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(JeuEntity jeuEntity){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.delete(jeuEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
