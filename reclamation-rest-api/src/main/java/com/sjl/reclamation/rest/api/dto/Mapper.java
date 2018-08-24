package com.sjl.reclamation.rest.api.dto;



import org.modelmapper.ModelMapper;

import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.model.entity.Camion;

public class Mapper {
	
	private ModelMapper modelMapper;
	
	public AgentDto convertToAgentDto(Agent agent) {
		AgentDto agentDto = modelMapper.map(agent,AgentDto.class);
		return agentDto;
	}
	
	public CamionDto convertToCamionDto(Camion camion) {
		CamionDto camionDto = modelMapper.map(camion, CamionDto.class);
		return camionDto;
	}

}
