package com.zineb.hibernate.dao;

import java.util.List;






import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.zineb.hibernate.entity.Agent;

public class AgentDao implements DaoInterface<Agent,Integer> {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public AgentDao(){}
	
	public Session openCurrentSession(){
		currentSession=getSessionFactory().openSession();
		return currentSession;
		
	}
	
	public Session openCurrentSessionwithTransaction(){
		currentSession=getSessionFactory().openSession();
		currentTransaction=currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession(){
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction(){
		currentTransaction.commit();
		currentSession.close();
	}
	
	 public Session getCurrentSession() {
		 return currentSession;
    }
		 
     public void setCurrentSession(Session currentSession) {
		 this.currentSession = currentSession;
	 }
		 
	 public Transaction getCurrentTransaction() {
	      return currentTransaction;
	 }
		 
	 public void setCurrentTransaction(Transaction currentTransaction) {
		  this.currentTransaction = currentTransaction;
	 }
		 
		  

	
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

	@Override
	public void persist(Agent entity) {
	   getCurrentSession().save(entity);
	}

	@Override
	public void update(Agent entity) {
		getCurrentSession().update(entity);
		
	}
	
	@Override
	public Agent findbyId(Integer id) {
		Agent agent = (Agent)getCurrentSession().get(Agent.class,id);
		return agent;
	}

	@Override
	public void delete(Agent entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> findAll() {
		List<Agent> agents = (List<Agent>) getCurrentSession().createQuery("from Agent").list();
		return agents;
	}

	@Override
	public void deleteAll() {
		List<Agent> entityList= findAll();
		for(Agent entity : entityList){
			delete(entity);
		}
		
	}
	
	/*// Method 1 : This Method is used to create a new Agent In the Database Table 
	
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
		  
	}*/
	

	
		
		
		    

		
}
