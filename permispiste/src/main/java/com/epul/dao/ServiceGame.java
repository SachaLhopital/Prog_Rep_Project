package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.JeuEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lafay on 15/05/2017.
 */
public class ServiceGame extends Service {

    /***
     * Récupère tous les jeux
     * @return
     */
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

    /***
     * Récupère les jeu avec son id
     * @param id_jeu
     * @return
     */
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

    /***
     * Last id inserted + 1
     * @return
     */
    public int getNextIdToInsert() {
        return ((Integer) ServiceHibernate.currentSession().createQuery("SELECT max( j.numjeu ) FROM JeuEntity j").uniqueResult()) + 1;
    }
}
