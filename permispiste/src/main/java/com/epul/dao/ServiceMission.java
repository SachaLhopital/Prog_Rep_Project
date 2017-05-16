package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.metier.JeuEntity;
import com.epul.metier.MissionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sacha on 16/05/2017.
 */
public class ServiceMission {

    public List<MissionEntity> getAll(){
        List<MissionEntity> missionList = new ArrayList();
        try{
            List<MissionEntity> allMissions = ServiceHibernate.currentSession().createQuery("SELECT m FROM MissionEntity m order by id").list();

            for (Iterator iterator1 = allMissions.iterator(); iterator1.hasNext();){
                MissionEntity mission = (MissionEntity) iterator1.next();
                missionList.add(mission);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return missionList;
    }

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

    //Todo : refactor
    public void save(MissionEntity mission){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(mission);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //TOdo : refactor
    public void delete(MissionEntity mission){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.delete(mission);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
