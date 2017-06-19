package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.ObtientEntity;
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

    /***
     * Récupère la toutes les parties enregistrées
     * @return
     */
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

    /***
     * Récupère toutes les parties d'un Apprenant
     * @param idApprenant
     * @return
     */
    public List<ObtientEntity> getAllForApprenant(int idApprenant){
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

    /***
     * Récupère la partie d'un apprenant sur un jeu en particulier
     * @param idApprenant
     * @param idAction
     * @return
     */
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

    /***
     * Récupère le score moyen de toutes les parties
     * @return
     */
    public Double getScoreAverage() {
        return (Double) ServiceHibernate.currentSession()
                .createQuery("SELECT avg(o.valeurfin) FROM ObtientEntity o")
                .list()
                .get(0);
    }
}
