package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.MissionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sacha on 16/05/2017.
 */
public class ServiceMission extends Service {

    /***
     * Récupère toutes les missions
     * @return
     */
    public List<MissionEntity> getAll(){
        List<MissionEntity> missionList = new ArrayList();
        try{
            Session session = ServiceHibernate.currentSession();
            List<MissionEntity> allMissions = session.createQuery("SELECT m FROM MissionEntity m order by id").list();

            for (Iterator iterator1 = allMissions.iterator(); iterator1.hasNext();){
                MissionEntity mission = (MissionEntity) iterator1.next();
                missionList.add(mission);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return missionList;
    }

    /***
     * Récupère les missions d'un jeu
     * @param idJeu
     * @return
     */
    public List<MissionEntity> getAllFromJeu(int idJeu){
        List<MissionEntity> missionList = new ArrayList();
        try{
            Session session = ServiceHibernate.currentSession();
            List<MissionEntity> allMissions = session.createQuery("SELECT m FROM MissionEntity m WHERE m.numjeu = :idJeu order by id")
                    .setParameter("idJeu",idJeu)
                    .list();

            for (Iterator iterator1 = allMissions.iterator(); iterator1.hasNext();){
                MissionEntity mission = (MissionEntity) iterator1.next();
                missionList.add(mission);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return missionList;
    }

    /***
     * Récupère les missions avec son id
     * @param id
     * @return
     */
    public MissionEntity get(int id){
        MissionEntity mission = null;
        try{
            mission = (MissionEntity) ServiceHibernate.currentSession()
                    .createQuery("SELECT m FROM MissionEntity m where id= :id order by id")
                    .setParameter("id",id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mission;
    }

    /***
     * Last id inserted + 1
     * @return
     */
    public int getNextIdToInsert() {
        return ((Integer) ServiceHibernate.currentSession().createQuery("SELECT max( m.nummission ) FROM MissionEntity m").uniqueResult()) + 1;
    }
}
