package com.utn.main.services;

import org.springframework.stereotype.Service;

import com.utn.main.dtos.DTOAdulto;
import com.utn.main.entities.Adulto;
import com.utn.main.repositories.AdultoRepository;

@Service
public class AdultoService extends BaseService<Adulto, DTOAdulto> {
	
	private AdultoRepository adultoRepository;
	
	public AdultoService(AdultoRepository adultoRepository) {
		super(adultoRepository,DTOAdulto.class, Adulto.class);
		this.adultoRepository = adultoRepository;
	}

	public AdultoRepository getAdultoRepository() {
		return adultoRepository;
	}

	public void setAdultoRepository(AdultoRepository adultoRepository) {
		this.adultoRepository = adultoRepository;
	}
	
}
