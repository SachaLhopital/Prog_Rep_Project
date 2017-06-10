package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.ActionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sacha on 16/05/2017.
 */
public class ServiceAction extends Service {

    public List<ActionEntity> getAll(){
        List<ActionEntity> actionList = new ArrayList();
        try{
            Session session = ServiceHibernate.currentSession();
            List<ActionEntity> all = session.createQuery("SELECT a FROM ActionEntity a order by id").list();

            for (Iterator iterator1 = all.iterator(); iterator1.hasNext();){
                ActionEntity action = (ActionEntity) iterator1.next();
                actionList.add(action);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return actionList;
    }

    public ActionEntity get(int id){
        ActionEntity action = null;
        try{
            action = (ActionEntity) ServiceHibernate.currentSession()
                    .createQuery("SELECT a FROM ActionEntity a where id= :id order by id")
                    .setParameter("id",id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return action;
    }

    public List<ActionEntity> getAll(int idApprenant){
        List<ActionEntity> all = new ArrayList<>();
        try{
            Session session = ServiceHibernate.currentSession();
            all = session.createQuery("SELECT a FROM ActionEntity a, ObtientEntity o where a.numaction=o.numaction AND o.numapprenant= :idApprenant order by id")
                    .setParameter("idApprenant",idApprenant).list();

            for (Iterator iterator1 = all.iterator(); iterator1.hasNext();){
                ActionEntity action = (ActionEntity) iterator1.next();
                all.add(action);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    /***
     * Last id inserted + 1
     * @return
     */
    public int getNextIdToInsert() {
        return ((Integer) ServiceHibernate.currentSession().createQuery("SELECT max( a.numaction ) FROM ActionEntity a").uniqueResult()) + 1;
    }

    //TOdo : refactor
    public void delete(ActionEntity action){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.delete(action);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
