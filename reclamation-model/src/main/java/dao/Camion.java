package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Camion implements Serializable{
	
	@Id @GeneratedValue
	@Column (name="id")
	private Long id;
	

	@Column (name="Matricule")
	private String Matricule;
	
	
	public Long getCamionId() {
		return id;
	}

	public void setCamionId(Long id) {
		this.id = id;
	}

	public String getCamionMatricule() {
		return Matricule;
	}

	public void setCamionMatricule(String matricule) {
		Matricule = matricule;
	}
	
	public Camion(){
		
	}


}
