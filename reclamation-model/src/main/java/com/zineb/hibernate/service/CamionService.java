package com.zineb.hibernate.service;

import java.util.List;

import com.zineb.hibernate.dao.CamionDao;
import com.zineb.hibernate.entity.Camion;

public class CamionService {
	
	private static CamionDao camionDao;
	
	public CamionService(){
		camionDao=new CamionDao();
	}
	
	public void persist(Camion entity){
		camionDao.openCurrentSessionwithTransaction();
		camionDao.persist(entity);
		camionDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Camion entity){
		camionDao.openCurrentSessionwithTransaction();
		camionDao.update(entity);
		camionDao.closeCurrentSessionwithTransaction();
	}
	
	public Camion findById(Integer id){
		camionDao.openCurrentSession();
		Camion camion = camionDao.findbyId(id);
		camionDao.closeCurrentSession();
		return camion;
	}
	
	public void delete(Integer id){
		camionDao.openCurrentSessionwithTransaction();
		Camion camion = camionDao.findbyId(id);
		camionDao.delete(camion);
		camionDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Camion> findAll(){
		camionDao.openCurrentSession();
		List<Camion> camions = camionDao.findAll();
		camionDao.closeCurrentSession();
		return camions;
	}
	
	public void deleteAll(){
		camionDao.openCurrentSessionwithTransaction();
        camionDao.deleteAll();
        camionDao.closeCurrentSessionwithTransaction();
		
	}
	
	

}
