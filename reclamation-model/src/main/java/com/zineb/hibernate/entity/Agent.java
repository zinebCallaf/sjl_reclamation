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
	private Integer id;
	
	@Column(name="nom")
    private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
    
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Agent(){
		
	}
	
	public Agent(Integer id , String nom , String prenom){
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public Agent(String nom,String prenom){
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public String toString() {
		
		        return "Agent= Id: " + this.id + ", Nom: " + this.nom + ", Prenom: " + this.nom;
	
		    }

	
	
	
	
	

}
