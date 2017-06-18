package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.EstAssocieEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Louis on 17/06/2017.
 */
public class ServiceEstAssocie extends Service {
    /***
     * Récupère toutes les parties d'un Objectif
     * @param idObjectif
     * @return
     */
    public List<EstAssocieEntity> getAllFromObjectif(int idObjectif){
        List<EstAssocieEntity> all = new ArrayList<>();
        try{
            Session session = ServiceHibernate.currentSession();
            List<Object> list = session.createQuery("SELECT e FROM EstAssocieEntity e WHERE e.numobjectif=:idObjectif")
                    .setParameter("idObjectif", idObjectif)
                    .list();

            for (Iterator iterator1 = list.iterator(); iterator1.hasNext();){
                EstAssocieEntity obtientEntity = (EstAssocieEntity) iterator1.next();
                all.add(obtientEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }
}
