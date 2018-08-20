package com.sjl.reclamation.model.dao.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfiguration {

    private static SessionFactory sessionFactory;

    // Method Used to create the hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
            throw new RuntimeException("buildSessionFactory ERROR : " + e.getMessage(),e);
        }
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
