package dao;

import java.io.Serializable;

import javax.persistence.*;

@Entity

public class Agent implements Serializable{
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nom")
    private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
    
    
    public Long getAgentId() {
		return id;
	}
	public void setAgentId(Long id) {
		this.id = id;
	}
	public String getAgentNom() {
		return nom;
	}
	public void setAgentNom(String nom) {
		this.nom = nom;
	}
	public String getAgentPrenom() {
		return prenom;
	}
	public void setAgentPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Agent(){
		
	}
	
	
	
	
	

}
