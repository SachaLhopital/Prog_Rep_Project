package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.ApprenantEntity;
import com.epul.metier.JeuEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Sacha on 25/05/2017.
 */
public class ServiceApprenant extends Service {

    public List<ApprenantEntity> getAll(){
        try{
            return ServiceHibernate
                    .currentSession()
                    .createQuery("SELECT a FROM ApprenantEntity a order by id").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ApprenantEntity get(int id){
        try{
            return (ApprenantEntity) ServiceHibernate
                                .currentSession()
                                .createQuery("SELECT a FROM ApprenantEntity a where id= :id order by id")
                                .setParameter("id",id)
                                .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /***
     * Last id inserted + 1
     * @return
     */
    public int getNextIdToInsert() {
        return ((Integer) ServiceHibernate.currentSession().createQuery("SELECT max( a.numapprenant ) FROM ApprenantEntity a").uniqueResult()) + 1;
    }

    //todo refactor
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
