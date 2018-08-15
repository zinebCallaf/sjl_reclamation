package com.zineb.hibernate.methodes;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.zineb.hibernate.entity.Agent;

public class dbOperations {
	
	// Method Used to create the hibernate's SessionFactory Object
	public static SessionFactory getSessionFactory(){
		//Creating Configuration Instance and passing hibernate configuration file 
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
		
		//Creating Hibernate Session Factory Instance 
		SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		
		return factoryObj;
		
	}
	
	// Method 1 : This Method is used to create a new Agent In the Database Table 
	
	public static Integer addAgent ( Agent agent){
		
		Session session = getSessionFactory().openSession();
	    Transaction transObj = null ;

		
		
		try {
			// Creating Transaction Object 
	         transObj = session.beginTransaction();
	         session.save(agent);
	       //Transaction is Committed to Database
	         transObj.commit();
	      } catch (HibernateException e) {
	         if (transObj!=null)  transObj.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	//Closing The Session Object
	         session.close(); 
	      }
		
		return agent.getAgentId();
		
		
	}
	
	// Method 2 : This Method is used to delete an agent 
	
	public static void deleteAgent(Integer agentId){
		
		  Session session = getSessionFactory().openSession();
	      Transaction transObj = null;
	      
	      try {
	         transObj = session.beginTransaction();
	         Agent agent = session.get(Agent.class, agentId); 
	         session.delete(agent); 
	         transObj.commit();
	      } catch (HibernateException e) {
	         if (transObj!=null) transObj.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	
	// Method 3 : This Method is used to read all the agents 
	
	@SuppressWarnings("rawtypes")
	public static List listAgents(){
		  Session session = getSessionFactory().openSession();
		  
		  List agentList = session.createQuery("FROM Agent").list();
		  
		  //Closing the session object
		  session.close();
		  return agentList;
		  
	}
	

	
		
		
		    

		
}
