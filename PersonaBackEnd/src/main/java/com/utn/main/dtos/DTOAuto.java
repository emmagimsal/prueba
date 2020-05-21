package com.utn.main.dtos;


import com.utn.main.entities.Adulto;

public class DTOAuto extends DTOBase {

		private String marca;
		
		private String modelo;
		
		private int año;
		
		private Adulto propietario;

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public int getAño() {
			return año;
		}

		public void setAño(int año) {
			this.año = año;
		}

		public Adulto getPropietario() {
			return propietario;
		}

		public void setPropietario(Adulto propietario) {
			this.propietario = propietario;
		}
		


}
