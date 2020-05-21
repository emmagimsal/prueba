package com.utn.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.main.dtos.DTOAuto;
import com.utn.main.services.AutoService;

@Controller
@RestController
@RequestMapping(path = "api/v1/auto")
public class AutoController extends BaseController<DTOAuto>{

	private AutoService autoService;

	public AutoController(AutoService autoService) {
		super(autoService);
		this.autoService = autoService;
	}

	public AutoService getAutoService() {
		return autoService;
	}

	public void setAutoService(AutoService autoService) {
		this.autoService = autoService;
	}
	
	
	
}
