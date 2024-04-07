package com.museumis.calculo.trayectorias.servicio;

import com.museumis.calculo.trayectorias.utils.Constantes;


public class GravedadService {
	


	
	
	public double getGravedadActual(double altura) {		
		
		double sumaRadioTierraMasAltura = 1 + (altura /Constantes.RADIO_TIERRA);
		
		double gravedad = Constantes.GRAVEDAD_EN_TIERRA
									/                            +
				(Math.pow(sumaRadioTierraMasAltura,2));	
		
		
		return gravedad;
	}


	
	
	
	
	
	
}
