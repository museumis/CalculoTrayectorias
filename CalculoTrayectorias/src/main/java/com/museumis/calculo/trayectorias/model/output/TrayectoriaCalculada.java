package com.museumis.calculo.trayectorias.model.output;

import java.io.Serializable;

public class TrayectoriaCalculada implements Serializable {
	

	private static final long serialVersionUID = 1L;
	double tiempo_seg,
	gravedad_ms2,
	velocidad_de_escape_ms,	

	aceleracion_de_escape_etapa_uno_ms,
	aceleracion_de_escape_etapa_dos_ms,
	aceleracion_de_escape_total_ms,
	fraccionDePropelenteEtapaUno_porcentaje,fraccionDePropelenteEtapaDos_porcentaje,fraccionDeCargaUtil_porcentaje;
	

	public double getTiempo_seg() {
		return tiempo_seg;
	}

	public void setTiempo_seg(double tiempo_seg) {
		this.tiempo_seg = tiempo_seg;
	}

	public double getGravedad_ms2() {
		return gravedad_ms2;
	}

	public void setGravedad_ms2(double gravedad_ms2) {
		this.gravedad_ms2 = gravedad_ms2;
	}

	public double getVelocidad_de_escape_ms() {
		return velocidad_de_escape_ms;
	}

	public void setVelocidad_de_escape_ms(double velocidad_de_escape_ms) {
		this.velocidad_de_escape_ms = velocidad_de_escape_ms;
	}

	public double getAceleracion_de_escape_etapa_uno_ms() {
		return aceleracion_de_escape_etapa_uno_ms;
	}

	public void setAceleracion_de_escape_etapa_uno_ms(double aceleracion_de_escape_etapa_uno_ms) {
		this.aceleracion_de_escape_etapa_uno_ms = aceleracion_de_escape_etapa_uno_ms;
	}

	public double getAceleracion_de_escape_etapa_dos_ms() {
		return aceleracion_de_escape_etapa_dos_ms;
	}

	public void setAceleracion_de_escape_etapa_dos_ms(double aceleracion_de_escape_etapa_dos_ms) {
		this.aceleracion_de_escape_etapa_dos_ms = aceleracion_de_escape_etapa_dos_ms;
	}

	public double getAceleracion_de_escape_total_ms() {
		return aceleracion_de_escape_total_ms;
	}

	public void setAceleracion_de_escape_total_ms(double aceleracion_de_escape_total_ms) {
		this.aceleracion_de_escape_total_ms = aceleracion_de_escape_total_ms;
	}

	public double getFraccionDePropelenteEtapaUno_porcentaje() {
		return fraccionDePropelenteEtapaUno_porcentaje;
	}

	public void setFraccionDePropelenteEtapaUno_porcentaje(double fraccionDePropelenteEtapaUno_porcentaje) {
		this.fraccionDePropelenteEtapaUno_porcentaje = fraccionDePropelenteEtapaUno_porcentaje;
	}

	public double getFraccionDePropelenteEtapaDos_porcentaje() {
		return fraccionDePropelenteEtapaDos_porcentaje;
	}

	public void setFraccionDePropelenteEtapaDos_porcentaje(double fraccionDePropelenteEtapaDos_porcentaje) {
		this.fraccionDePropelenteEtapaDos_porcentaje = fraccionDePropelenteEtapaDos_porcentaje;
	}

	public double getFraccionDeCargaUtil_porcentaje() {
		return fraccionDeCargaUtil_porcentaje;
	}

	public void setFraccionDeCargaUtil_porcentaje(double fraccionDeCargaUtil_porcentaje) {
		this.fraccionDeCargaUtil_porcentaje = fraccionDeCargaUtil_porcentaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
	

	
	
	


	
	


	
}
