package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.ObjectifEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Louis on 17/06/2017.
 */
public class ServiceObjectif extends Service {
    public List<ObjectifEntity> getAll(){
        List<ObjectifEntity> objectifEntities = new ArrayList<>();
        try{
            Session session = ServiceHibernate.currentSession();
            List<ObjectifEntity> allObjectifs = session.createQuery("SELECT o FROM ObjectifEntity o order by id").list();

            for (Iterator iterator1 = allObjectifs.iterator(); iterator1.hasNext();){
                ObjectifEntity mission = (ObjectifEntity) iterator1.next();
                objectifEntities.add(mission);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return objectifEntities;
    }

    public ObjectifEntity get(int id){
        ObjectifEntity objectif = null;
        try{
            objectif = (ObjectifEntity) ServiceHibernate.currentSession()
                    .createQuery("SELECT o FROM ObjectifEntity o where id= :id order by id")
                    .setParameter("id",id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return objectif;
    }

}
