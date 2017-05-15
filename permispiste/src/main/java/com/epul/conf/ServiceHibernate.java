package com.epul.conf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by lafay on 03/05/2017.
 */
public class ServiceHibernate {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                //StandardServiceRegistryBuilder.destroy( registry );
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

    public static ThreadLocal session = new ThreadLocal();

    public static Session currentSession() {
        Session s = null;
        try{
            s = (Session) session.get();
            // Open a new Session, if this Thread has none yet
            if (s == null) {
                s = getSessionFactory().openSession();
                session.set(s);
            }
        }catch(HibernateException ex){
            ex.printStackTrace();
        }



        return s;
    }

    @SuppressWarnings("unchecked")
    public static void closeSession() throws HibernateException {

        Session s = (Session) session.get();
        session.set(null);
        if (s != null)
            s.close();

    }
}
