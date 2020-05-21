package com.utn.main.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ninio")
public class Niño extends Persona {
	
	@Column(name = "Colegio_Ninio")
	private String colegio;

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
}
