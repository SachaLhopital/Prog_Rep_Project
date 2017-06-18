package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import com.epul.entities.ActionEntity;
import com.epul.entities.CalendrierEntity;
import org.hibernate.Session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lafay on 18/06/2017.
 */
public class ServiceCalendrier extends Service {

    public List<CalendrierEntity> getAll(){
        List<CalendrierEntity> calendrierEntityList = new ArrayList();
        try{
            Session session = ServiceHibernate.currentSession();
            List<CalendrierEntity> all = session.createQuery("SELECT c FROM CalendrierEntity c").list();

            for (Iterator iterator1 = all.iterator(); iterator1.hasNext();){
                CalendrierEntity calendrierEntity = (CalendrierEntity) iterator1.next();
                calendrierEntityList.add(calendrierEntity);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return calendrierEntityList;
    }

    @Override
    public void save(Object entityObject) {
        for(CalendrierEntity calendrierEntity:getAll()){
            if(calendrierEntity.getDatejour().equals(((CalendrierEntity)entityObject).getDatejour())){
                return;
            }
        }

        super.save(entityObject);
    }
}
