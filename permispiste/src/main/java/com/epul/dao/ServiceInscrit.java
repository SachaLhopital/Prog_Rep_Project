package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.InscritEntity;
import com.epul.entities.ObtientEntity;
import com.epul.exception.CustomException;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.toIntExact;

/**
 * Created by Sachouw on 14/06/2017.
 */
public class ServiceInscrit extends Service {

    /***
     * Récupère la toutes les inscriptions
     * @return
     */
    public List<InscritEntity> getAll() throws CustomException {
        try{
            return ServiceHibernate.currentSession()
                    .createQuery("SELECT i FROM InscritEntity i ORDER BY i.datejour DESC")
                    .list();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("ERROR", "Impossible de récupérer les inscriptions");
        }
    }

    /***
     * Retourne ne nombre de parties programmées/effectuées aujourd'hui
     * @return
     */
    public int getCountToday() {
        return toIntExact((Long) ServiceHibernate.currentSession()
                .createQuery("SELECT count(i) " +
                        "FROM InscritEntity i " +
                        "WHERE i.datejour = current_date")
                .uniqueResult());
    }

    public InscritEntity getInscription(int idApprenant, int numjeu) throws CustomException {
        try{
            return (InscritEntity) ServiceHibernate.currentSession()
                    .createQuery("SELECT i FROM InscritEntity i WHERE i.numapprenant = :idApprenant and i.numjeu = :numjeu ORDER BY i.datejour DESC")
                    .setParameter("idApprenant",idApprenant)
                    .setParameter("numjeu",numjeu)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("ERROR", "Impossible de récupérer les inscriptions");
        }
    }
}
