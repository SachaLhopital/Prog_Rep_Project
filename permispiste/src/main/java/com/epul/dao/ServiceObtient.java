package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.ActionEntity;
import com.epul.metier.ObtientEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.toIntExact;

/**
 * Created by Sachouw on 12/06/2017.
 */
public class ServiceObtient extends Service{

    /***
     * Compte le nombre de lignes
     * @return
     */
    public int getCount() {
        return toIntExact((Long) ServiceHibernate.currentSession()
                .createQuery("SELECT count(o) FROM ObtientEntity o")
                .uniqueResult());
    }

    public List<ObtientEntity> getAll(){
        List<ObtientEntity> all = new ArrayList<>();
        try{
            Session session = ServiceHibernate.currentSession();
            List<Object> list = session.createQuery("SELECT o FROM ObtientEntity o")
                    .list();

            for (Iterator iterator1 = list.iterator(); iterator1.hasNext();){
                ObtientEntity obtientEntity = (ObtientEntity) iterator1.next();
                all.add(obtientEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public List<ObtientEntity> getAllFromApprenant(int idApprenant){
        List<ObtientEntity> all = new ArrayList<>();
        try{
            Session session = ServiceHibernate.currentSession();
            List<Object> list = session.createQuery("SELECT o FROM ObtientEntity o WHERE o.numapprenant=:idApprenant")
                    .setParameter("idApprenant", idApprenant)
                    .list();

            for (Iterator iterator1 = list.iterator(); iterator1.hasNext();){
                ObtientEntity obtientEntity = (ObtientEntity) iterator1.next();
                all.add(obtientEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public List<ObtientEntity> getAllFromAction(int idAction){
        List<ObtientEntity> all = new ArrayList<>();
        try{
            Session session = ServiceHibernate.currentSession();
            List<Object> list = session.createQuery("SELECT o FROM ObtientEntity o WHERE o.numaction = :idAction")
                    .setParameter("idAction", idAction)
                    .list();

            for (Iterator iterator1 = list.iterator(); iterator1.hasNext();){
                ObtientEntity obtientEntity = (ObtientEntity) iterator1.next();
                all.add(obtientEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public ObtientEntity get(int idApprenant, int idAction){
        ObtientEntity obtientEntity = null;
        try{
            obtientEntity = (ObtientEntity) ServiceHibernate.currentSession()
                    .createQuery("SELECT o FROM ObtientEntity o where numapprenant= :idApprenant and numaction= :idAction")
                    .setParameter("idApprenant",idApprenant).setParameter("idAction",idAction).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obtientEntity;
    }
}
