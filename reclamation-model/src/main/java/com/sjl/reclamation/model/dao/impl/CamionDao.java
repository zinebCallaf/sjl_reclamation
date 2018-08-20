package com.sjl.reclamation.model.dao.impl;

import com.sjl.reclamation.model.dao.api.DaoInterface;
import com.sjl.reclamation.model.dao.helpers.HibernateConfiguration;
import com.sjl.reclamation.model.entity.Camion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class CamionDao implements DaoInterface<Camion, Integer> {

    private SessionFactory sessionFactory;
   

    public CamionDao() {
    	sessionFactory = HibernateConfiguration.sessionFactory();
    }

    public CamionDao(SessionFactory sessionFactory) {
        sessionFactory=this.sessionFactory;
    }

   

  

    @Override
    public void persist(Camion entity) {
    	final Session session = sessionFactory.openSession();
    	session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void update(Camion entity) {
    	final Session session = sessionFactory.openSession();
    	session.getTransaction().begin();
    	session.update(entity);
    	session.getTransaction().commit();
    	session.close();
       
    }

    @Override
    public Camion findbyId(Integer id) {
    	final Session session = sessionFactory.openSession();
    	Camion camion = (Camion) session.get(Camion.class,id);
    	session.close();
    	return camion;
    	
       
    }

    @Override
    public void delete(Camion entity) {
       final Session session = sessionFactory.openSession();
       session.getTransaction().begin();
       session.delete(entity);
       session.getTransaction().commit();
       session.close();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Camion> findAll() {
    	final Session session = sessionFactory.openSession();
    	List<Camion> camions = (List<Camion>) session.createQuery("from Camion").list();
    	session.close();
        return camions;
    }

    @Override
    public void deleteAll() {
        List<Camion> entityList = findAll();
        for (Camion entity : entityList) {
            delete(entity);
        }

    }

}
