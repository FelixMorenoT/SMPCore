package com.smp.core.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Signos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String singoId;
	private String signoName;
	private String signoValueMax;
	private String signoValueMin;
	
	public Signos() {
		
	}

	public Signos(String singoId, String signoName, String signoValueMax, String signoValueMin) {
		this.singoId = singoId;
		this.signoName = signoName;
		this.signoValueMax = signoValueMax;
		this.signoValueMin = signoValueMin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSingoId() {
		return singoId;
	}

	public void setSingoId(String singoId) {
		this.singoId = singoId;
	}

	public String getSignoName() {
		return signoName;
	}

	public void setSignoName(String signoName) {
		this.signoName = signoName;
	}

	public String getSignoValueMax() {
		return signoValueMax;
	}

	public void setSignoValueMax(String signoValueMax) {
		this.signoValueMax = signoValueMax;
	}

	public String getSignoValueMin() {
		return signoValueMin;
	}

	public void setSignoValueMin(String signoValueMin) {
		this.signoValueMin = signoValueMin;
	}
	
}
