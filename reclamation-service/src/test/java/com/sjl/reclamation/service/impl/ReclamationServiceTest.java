package com.sjl.reclamation.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.Test;

import com.sjl.reclamation.model.dao.impl.AgentDao;
import com.sjl.reclamation.model.dao.impl.CamionDao;
import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.model.entity.Camion;
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
	@Test
	public void shoulListAllCamions() {
		//Given
		camionDao.persist(new Camion());
		//When
		List<Camion> camionList = reclamation.getCamionList();
		//Then
		assertThat(camionList).hasSize(1);
 }
	
	@Test
	public void shouldPrintReclamation() {
		//Given
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		//When
		reclamation.creerReclamation();
		String expectedOutput ="reclamation";
		//Then
		assertEquals(expectedOutput,outContent.toString());
		
	}
	
	
	

}
