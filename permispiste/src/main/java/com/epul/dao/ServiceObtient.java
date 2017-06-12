package com.epul.dao;

import com.epul.conf.ServiceHibernate;

import static java.lang.Math.toIntExact;

/**
 * Created by Sachouw on 12/06/2017.
 */
public class ServiceObtient {

    /***
     * Compte le nombre de lignes
     * @return
     */
    public int getCount() {
        return toIntExact((Long) ServiceHibernate.currentSession()
                .createQuery("SELECT count(distinct o) FROM ObtientEntity o")
                .uniqueResult());
    }
}
