package com.sjl.reclamation.rest.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.rest.api.dto.AgentDto;
import com.sjl.reclamation.rest.api.dto.Mapper;

public class MapperTest {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void shouldConvertAgentEntitytoAgentDto() {
		//Given 
		Agent agent = new Agent();
		agent.setNom("callaf");
		agent.setPrenom("zineb");
		//When
		AgentDto agentDto = modelMapper.map(agent,AgentDto.class);
		//Then
		 assertEquals(agent.getNom(), agentDto.getNom());
		 assertEquals(agent.getPrenom(), agentDto.getPrenom());
				
		
		
	
	
	}

}
