package com.museumis.calculo.trayectorias.model.input;

import java.io.Serializable;

import com.museumis.calculo.trayectorias.model.Cohete;

public class Telemetria implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cohete cohete;
	
	
	public Telemetria() {
	}

	public Cohete getCohete() {
		return cohete;
	}

	public void setCohete(Cohete cohete) {
		this.cohete = cohete;
	}


	
	
}
