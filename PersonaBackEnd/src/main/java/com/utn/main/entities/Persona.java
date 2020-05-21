package com.utn.main.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
@DiscriminatorColumn (name = "Tipo_persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Persona extends BaseEntity { 
	
	@Column (name = "Nombre_Persona")
	private String nombre;
	@Column (name = "Apellido_persona")
	private String apellido;
	@Column (name = "Edad_Persona")
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}