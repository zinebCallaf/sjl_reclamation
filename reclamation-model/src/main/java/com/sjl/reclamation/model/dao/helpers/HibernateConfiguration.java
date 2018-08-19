package com.sjl.reclamation.model.dao.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    private static SessionFactory sessionFactory;

    // Method Used to create the hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    /**
     * Singleton factory
     * @return @{@link SessionFactory} instance
     */
    public synchronized  static SessionFactory sessionFactory(){
        if(sessionFactory==null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }



}
