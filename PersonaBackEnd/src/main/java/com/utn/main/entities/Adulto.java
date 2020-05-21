package com.utn.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "adulto")
public class Adulto extends Persona {

	@Column(name = "Profesion_Adulto")
	private String profesion;

	
	@OneToMany(mappedBy ="propietario",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Auto> autos = new ArrayList<>();
	
	
	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
}
