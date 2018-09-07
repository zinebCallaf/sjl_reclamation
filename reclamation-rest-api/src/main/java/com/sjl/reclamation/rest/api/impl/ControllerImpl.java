package com.sjl.reclamation.rest.api.impl;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sjl.reclamation.model.dao.impl.AgentDao;
import com.sjl.reclamation.model.dao.impl.CamionDao;
import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.model.entity.Camion;

import com.sjl.reclamation.rest.api.dto.AgentDto;
import com.sjl.reclamation.rest.api.dto.CamionDto;
import com.sjl.reclamation.rest.api.dto.Mapper;
import com.sjl.reclamation.service.impl.ReclamationServiceImpl;


@Path("/reclamation-management")
public class ControllerImpl  {
	
	public ControllerImpl(){}
	
	private AgentDao agentDao = new AgentDao();
	private CamionDao camionDao = new CamionDao();
	private ReclamationServiceImpl reclamation = new ReclamationServiceImpl(agentDao,camionDao);
	private Mapper mapper = new Mapper();

	
	@Path("/agents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AgentDto> getListAgentDto() {
	  List<AgentDto> listAgentsDto = new ArrayList<AgentDto>();
      List<Agent> agentEntity = reclamation.getAgentList();
	  for(Agent agent : agentEntity) {
		  AgentDto agentDto = new AgentDto();
		  agentDto=mapper.convertToAgentDto(agent);
		  listAgentsDto.add(agentDto);
	  }
	  return listAgentsDto;
	   
	}
	
	
	@Path("/camions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CamionDto> getListCamionDto() {
		List<CamionDto> listCamionsDto = new ArrayList<CamionDto>();
		List<Camion> camionEntity = reclamation.getCamionList();
		for(Camion camion : camionEntity) {
			CamionDto camionDto = new CamionDto();
			camionDto=mapper.convertToCamionDto(camion);
			listCamionsDto.add(camionDto);
		}
		return listCamionsDto;
		
	}
	 
	 
	

	
}
