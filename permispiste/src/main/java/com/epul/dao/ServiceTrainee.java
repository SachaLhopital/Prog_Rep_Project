package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.ApprenantEntity;
import com.epul.metier.JeuEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Louis on 04/06/2017.
 */
public class ServiceTrainee {
    public List<ApprenantEntity> getAll(){
        List<ApprenantEntity> learners = new ArrayList();
        try{
            Session session = ServiceHibernate.currentSession();

            List<ApprenantEntity> allTrainees = session.createQuery("SELECT a FROM ApprenantEntity a order by id").list();

            for (Iterator iterator1 = allTrainees.iterator(); iterator1.hasNext();){
                ApprenantEntity game = (ApprenantEntity) iterator1.next();
                learners.add(game);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return learners;
    }

    public ApprenantEntity get(int num_apprenant){
        ApprenantEntity apprenant = null;
        try{
            Session session = ServiceHibernate.currentSession();
            apprenant = (ApprenantEntity)session.createQuery("SELECT a FROM ApprenantEntity a where numapprenant= :num_apprenant order by numapprenant").setParameter("num_apprenant",num_apprenant).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return apprenant;
    }

    /***
     * Last id inserted + 1
     * @return
     */
    public int getNextIdToInsert() {
        return ((Integer) ServiceHibernate.currentSession().createQuery("SELECT max( a.numapprenant ) FROM ApprenantEntity a").uniqueResult()) + 1;
    }

    public void save(ApprenantEntity apprenantEntity){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(apprenantEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(ApprenantEntity apprenantEntity){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.delete(apprenantEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
