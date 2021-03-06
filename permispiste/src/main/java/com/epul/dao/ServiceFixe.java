package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.FixeEntity;

import java.util.List;

/**
 * Created by Louis on 17/06/2017.
 */
public class ServiceFixe extends Service {

    /***
     * Récupère toutes les lignes de la table Fixe
     * @return
     */
    public List<FixeEntity> getAll(){
        try{
            return ServiceHibernate
                    .currentSession()
                    .createQuery("SELECT f FROM FixeEntity f order by id").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /***
     * Récupère les lignes Fixe d'une mission
     * @param idMission
     * @return
     */
    public List<FixeEntity> getAllFromMission(int idMission){
        try{
            return ServiceHibernate
                    .currentSession()
                    .createQuery("SELECT f FROM FixeEntity f WHERE f.nummission = :idMission order by id")
                    .setParameter("idMission",idMission)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
