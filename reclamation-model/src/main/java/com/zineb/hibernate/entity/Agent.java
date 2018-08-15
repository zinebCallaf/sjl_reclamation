package com.zineb.hibernate.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity

public class Agent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="id")
	private Integer agentId;
	
	@Column(name="nom")
    private String agentNom;
	
	@Column(name="prenom")
    private String agentPrenom;
	
    
    
    public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgentNom() {
		return agentNom;
	}
	public void setAgentNom(String agentNom) {
		this.agentNom = agentNom;
	}
	public String getAgentPrenom() {
		return agentPrenom;
	}
	public void setAgentPrenom(String agentPrenom) {
		this.agentPrenom = agentPrenom;
	}
	
	public Agent(){
		
	}
	
	public Agent(Integer agentId , String agentNom , String agentPrenom){
		this.agentId=agentId;
		this.agentNom=agentNom;
		this.agentPrenom=agentPrenom;
	}
	
	public Agent(String agentNom,String agentPrenom){
		this.agentNom=agentNom;
		this.agentPrenom=agentPrenom;
	}
	
	public String toString() {
		
		        return "Agent= Id: " + this.agentId + ", Nom: " + this.agentNom + ", Prenom: " + this.agentNom;
	
		    }

	
	
	
	
	

}
