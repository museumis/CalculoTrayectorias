package com.museumis.calculo.trayectorias.servicio;

import com.museumis.calculo.trayectorias.model.input.Telemetria;
import com.museumis.calculo.trayectorias.utils.Constantes;

/*
 * Servicio para calcular la velocidad variable con la segunda ley de Newton 
 */

public class NewtonService {



	public double getVelocidadEscape(double tiempo, double expulsion_gases_u, Telemetria telemetria,double gravedad) {
		
		double masaInicial = getMasaInicialCohete(telemetria);
		double masaFinal = masaInicial - telemetria.getCohete().getMasa_combustible_etapa_uno_kg()- telemetria.getCohete().getMasa_combustible_etapa_dos_kg();
		
		
		double velocidadMaxima = (Constantes.V_INICIAL - (gravedad * tiempo))
								                           +
								  expulsion_gases_u * Math.log((masaInicial/masaFinal));
		
		//2302 
		return velocidadMaxima;
	}
		
	
	public double getMasaInicialCohete(Telemetria telemetria) {
		return telemetria.getCohete().getMasa_cohete_etapa_uno_kg() 
			 + telemetria.getCohete().getMasa_combustible_etapa_uno_kg() 
			 + telemetria.getCohete().getMasa_cohete_etapa_dos_kg() 
			 + telemetria.getCohete().getMasa_combustible_etapa_dos_kg() 
			 + telemetria.getCohete().getMasa_cargaUtil_kg();
	}




	

	
	
	
	
}
