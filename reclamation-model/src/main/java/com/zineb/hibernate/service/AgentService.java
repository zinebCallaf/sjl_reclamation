package com.zineb.hibernate.service;

import java.util.List;

import com.zineb.hibernate.dao.AgentDao;
import com.zineb.hibernate.entity.Agent;

public class AgentService {

	
	private static AgentDao agentDao;
	
	public AgentService(){
		agentDao = new AgentDao();
	}
	
	public void persist(Agent entity){
		agentDao.openCurrentSessionwithTransaction();
		agentDao.persist(entity);
		agentDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Agent entity){
		agentDao.openCurrentSessionwithTransaction();
		agentDao.update(entity);
		agentDao.closeCurrentSessionwithTransaction();
	}
	public Agent findById(Integer id){
		agentDao.openCurrentSession();
		Agent agent = agentDao.findbyId(id);
		agentDao.closeCurrentSession();
		return agent;
		
	}
	public void delete(Integer id){
		agentDao.openCurrentSessionwithTransaction();
		Agent agent = agentDao.findbyId(id);
		agentDao.delete(agent);
		agentDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Agent> findAll(){
		agentDao.openCurrentSession();
		List<Agent> agents = agentDao.findAll();
		agentDao.closeCurrentSession();
		return agents;
	}
	
	public void deleteAll(){
		agentDao.openCurrentSessionwithTransaction();
		agentDao.deleteAll();
		agentDao.closeCurrentSessionwithTransaction();
	}
	
	
}
