package com.sjl.reclamation.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

import com.sjl.reclamation.model.dao.impl.AgentDao;
import com.sjl.reclamation.model.dao.impl.CamionDao;
import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.service.api.ReclamationService;

public class ReclamationServiceTest {
	
	private AgentDao agentDao = new AgentDao();
	private CamionDao camionDao = new CamionDao();
	private ReclamationService reclamation = new ReclamationServiceImpl(agentDao,camionDao);
	
	@Test
	public void shouldListAllAgents(){
		//Given
		agentDao.persist(new Agent());
		agentDao.persist(new Agent());
		agentDao.persist(new Agent());
		//When
		List<Agent> agentList = reclamation.getAgentList();
		//Then
		assertThat(agentList).hasSize(3);
		
}

}
