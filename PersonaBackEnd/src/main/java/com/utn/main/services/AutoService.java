package com.utn.main.services;

import org.springframework.stereotype.Service;

import com.utn.main.dtos.DTOAuto;
import com.utn.main.entities.Auto;
import com.utn.main.repositories.AutoRepository;

@Service
public class AutoService extends BaseService<Auto, DTOAuto>{
	
	private AutoRepository autoRepository;

	public AutoService(AutoRepository autoRepository) {
		super(autoRepository,DTOAuto.class,Auto.class);
		this.autoRepository = autoRepository;
	}

	public AutoRepository getAutoRepository() {
		return autoRepository;
	}

	public void setAutoRepository(AutoRepository autoRepository) {
		this.autoRepository = autoRepository;
	}
	
}
