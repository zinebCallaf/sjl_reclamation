package com.sjl.reclamation.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "camion")
public class Camion implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "matricule")
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

    public Camion() {

    }


}
