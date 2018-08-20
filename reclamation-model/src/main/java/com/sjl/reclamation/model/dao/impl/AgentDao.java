package com.sjl.reclamation.model.dao.impl;

import com.sjl.reclamation.model.dao.api.DaoInterface;
import com.sjl.reclamation.model.dao.helpers.HibernateConfiguration;
import com.sjl.reclamation.model.entity.Agent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class AgentDao implements DaoInterface<Agent, Integer> {

    private SessionFactory sessionFactory;

    public AgentDao() {
        sessionFactory = HibernateConfiguration.sessionFactory();
    }

    public AgentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(Agent entity) {
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Agent entity) {
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Agent findbyId(Integer id) {
        final Session session = sessionFactory.openSession();
        Agent agent = (Agent) session.get(Agent.class, id);
        session.close();
        return agent;
    }

    @Override
    public void delete(Agent entity) {
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Agent> findAll() {
        final Session session = sessionFactory.openSession();
        List<Agent> agents = (List<Agent>) session.createQuery("from Agent").list();
        session.close();
        return agents;
    }

    @Override
    public void deleteAll() {
        List<Agent> entityList = findAll();
        for (Agent entity : entityList) {
            delete(entity);
        }
    }
}