package com.sjl.reclamation.rest.api.Api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sjl.reclamation.rest.api.dto.AgentDto;
import com.sjl.reclamation.rest.api.dto.CamionDto;



@Path("/reclamation-management")
public interface Controller {
	
	 @Path("/agents")
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<AgentDto> getListAgentDto();
	 
	 
	
	 @Path("/camions")
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<CamionDto> getListCamionDto(); 
	
	
}
