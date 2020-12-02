package com.smp.core.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alarma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "medida")
	private String medida;
	
	@Column(name = "descripcion_medida")
	private String descripcionMedida;
	
	@Column(name = "paciente")
	private String paciente;
	
	@Column(name = "valor")
	private String valor;
	
	@Column(name = "timestamp")
	private String timestamp;
	
	
	
	public Alarma() {
		
	}

	public Alarma(String medida, String paciente, String valor, String timestamp) {
		this.medida = medida;
		this.paciente = paciente;
		this.valor = valor;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDescripcionMedida() {
		return descripcionMedida;
	}

	public void setDescripcionMedida(String descripcionMedida) {
		this.descripcionMedida = descripcionMedida;
	}

	@Override
	public String toString() {
		return "Signos [id=" + id + ", medida=" + medida + ", descripcionMedida=" + descripcionMedida + ", paciente="
				+ paciente + ", valor=" + valor + ", timestamp=" + timestamp + "]";
	}
}
