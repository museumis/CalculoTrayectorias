package com.museumis.calculo.trayectorias.model;

import java.io.Serializable;

public class Cohete implements Serializable {

	private static final long serialVersionUID = 1L;

	double masa_cohete_etapa_uno_kg;
	double masa_cohete_etapa_dos_kg;
	double masa_combustible_etapa_uno_kg;
	double masa_combustible_etapa_dos_kg;
	double masa_cargaUtil_kg;
	double impulso_especifico_seg;
	

	double altitud_cohete_km;

	
	
	
	
	
	public Cohete() {
	}
	public double getMasa_cohete_etapa_uno_kg() {
		return masa_cohete_etapa_uno_kg;
	}
	public void setMasa_cohete_etapa_uno_kg(double masa_cohete_etapa_uno_kg) {
		this.masa_cohete_etapa_uno_kg = masa_cohete_etapa_uno_kg;
	}
	public double getMasa_cohete_etapa_dos_kg() {
		return masa_cohete_etapa_dos_kg;
	}
	public void setMasa_cohete_etapa_dos_kg(double masa_cohete_etapa_dos_kg) {
		this.masa_cohete_etapa_dos_kg = masa_cohete_etapa_dos_kg;
	}
	public double getMasa_combustible_etapa_uno_kg() {
		return masa_combustible_etapa_uno_kg;
	}
	public void setMasa_combustible_etapa_uno_kg(double masa_combustible_etapa_uno_kg) {
		this.masa_combustible_etapa_uno_kg = masa_combustible_etapa_uno_kg;
	}
	public double getMasa_combustible_etapa_dos_kg() {
		return masa_combustible_etapa_dos_kg;
	}
	public void setMasa_combustible_etapa_dos_kg(double masa_combustible_etapa_dos_kg) {
		this.masa_combustible_etapa_dos_kg = masa_combustible_etapa_dos_kg;
	}
	public double getMasa_cargaUtil_kg() {
		return masa_cargaUtil_kg;
	}
	public void setMasa_cargaUtil_kg(double masa_cargaUtil_kg) {
		this.masa_cargaUtil_kg = masa_cargaUtil_kg;
	}
	public double getImpulso_especifico_seg() {
		return impulso_especifico_seg;
	}
	public void setImpulso_especifico_seg(double impulso_especifico_seg) {
		this.impulso_especifico_seg = impulso_especifico_seg;
	}

	public double getAltitud_cohete_km() {
		return altitud_cohete_km;
	}
	public void setAltitud_cohete_km(double altitud_cohete_km) {
		this.altitud_cohete_km = altitud_cohete_km;
	}
	




}
