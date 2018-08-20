package com.sjl.reclamation.service.impl;

import java.util.List;

import com.sjl.reclamation.model.dao.impl.AgentDao;
import com.sjl.reclamation.model.dao.impl.CamionDao;
import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.model.entity.Camion;
import com.sjl.reclamation.service.api.ReclamationService;

public class ReclamationServiceImpl implements ReclamationService{
	
	private AgentDao agentDao;
	private CamionDao camionDao;
	
	public ReclamationServiceImpl(AgentDao agentDao,CamionDao camionDao) {
		this.agentDao=agentDao;
		this.camionDao=camionDao;
	}
	
	public List<Agent> getAgentList() {
	     List<Agent> agents = agentDao.findAll();
	     return agents;
	}
	public List<Camion> getCamionList() {
		List<Camion> camions = camionDao.findAll();
		return camions;
	}

}
