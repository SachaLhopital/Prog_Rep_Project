package com.epul.dao;

import com.epul.conf.ServiceHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Sachouw on 26/05/2017.
 */
public class Service {

    public void save(Object entityObject){
        try{
            Session session = ServiceHibernate.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(entityObject);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
