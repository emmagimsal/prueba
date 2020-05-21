package com.utn.main.dtos;

import java.util.ArrayList;
import java.util.List;

import com.utn.main.entities.Auto;

public class DTOAdulto extends DTOPersona {

	private String profesion;

	private List<Auto> autos = new ArrayList<Auto>();

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	
}
