package com.sjl.reclamation.service.api;

import java.util.List;

import com.sjl.reclamation.model.entity.Agent;
import com.sjl.reclamation.model.entity.Camion;

public interface ReclamationService {
	
	public List<Agent> getAgentList();
	public List<Camion> getCamionList();

}
