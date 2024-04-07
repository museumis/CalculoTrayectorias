package com.museumis.calculo.trayectorias;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.museumis.calculo.trayectorias.model.Cohete;
import com.museumis.calculo.trayectorias.model.input.Telemetria;
import com.museumis.calculo.trayectorias.servicio.NewtonService;

/*
 * Servicio para calcular la velocidad variable con la segunda ley de Newton 
 */

public class NewtonServiceTest {
	@Test
	public void getVelocidadEscapeTest() {
		double  tiempo = 0.01,
		v_expulsion_gases_u=1000,
		gravedad_actual=9.8;
		
		Cohete cohete = new Cohete();
		cohete.setMasa_cohete_etapa_uno_kg(0.1);
		cohete.setMasa_combustible_etapa_uno_kg(0.9);
		Telemetria telemetria = new Telemetria();
		telemetria.setCohete(cohete);
		
		NewtonService test = new NewtonService();
	
		//2302 
		 assertEquals(test.getVelocidadEscape(tiempo,v_expulsion_gases_u,telemetria,gravedad_actual), 2302.4870929940457);

	}
	
	
	
}
