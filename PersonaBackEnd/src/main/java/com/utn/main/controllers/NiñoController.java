package com.utn.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.main.dtos.DTONiño;
import com.utn.main.services.NiñoService;

@Controller
@RestController
@RequestMapping(path = "api/v1/ninio")
public class NiñoController extends BaseController<DTONiño> {

	private NiñoService niñoService;
	
	public NiñoController(NiñoService niñoService) {
		super(niñoService);
		this.niñoService = niñoService;
	}

	public NiñoService getNiñoService() {
		return niñoService;
	}

	public void setNiñoService(NiñoService niñoService) {
		this.niñoService = niñoService;
	}

	
}
