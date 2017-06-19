package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.InscritEntity;
import com.epul.exception.CustomException;
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
}
