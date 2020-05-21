package com.utn.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.main.dtos.DTOAdulto;
import com.utn.main.services.AdultoService;

@Controller
@RestController
@RequestMapping(path = "api/v1/adulto")
public class Adulto extends BaseController<DTOAdulto> {

private AdultoService adultoService;

public Adulto(AdultoService adultoService) {
	super(adultoService);
	this.adultoService = adultoService;
}

public AdultoService getAdultoService() {
	return adultoService;
}

public void setAdultoService(AdultoService adultoService) {
	this.adultoService = adultoService;
}	
	


}
