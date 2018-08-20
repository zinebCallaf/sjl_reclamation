package com.sjl.reclamation.model.dao.impl;

import java.util.List;
import com.sjl.reclamation.model.entity.Camion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamionDaoTest {
	
	private CamionDao camionDao = new CamionDao();
	
	@Test 
    public void shouldgetAllCamions(){
		camionDao.persist(new Camion());
		final List<Camion> listCamion = camionDao.findAll();
		assertThat(listCamion).hasSize(1);
	}


}
