package com.utn.main.services;

import org.springframework.stereotype.Service;


import com.utn.main.dtos.DTONiño;
import com.utn.main.entities.Niño;
import com.utn.main.repositories.NiñoRepository;

@Service
public class NiñoService extends BaseService<Niño, DTONiño> {
	
	private NiñoRepository niñoRepository;
	
	public NiñoService(NiñoRepository niñoRepository) {
		super(niñoRepository,DTONiño.class, Niño.class);
		this.niñoRepository = niñoRepository;
	}

	public NiñoRepository getNiñoRepository() {
		return niñoRepository;
	}

	public void setNiñoRepository(NiñoRepository niñoRepository) {
		this.niñoRepository = niñoRepository;
	}
	
}
