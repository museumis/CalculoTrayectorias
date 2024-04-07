package com.museumis.calculo.trayectorias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.museumis.calculo.trayectorias.servicio.GravedadService;

public class GravedadServiceTest {

	
	@Test
	public void getVelocidadMaximaTest() {
		
		GravedadService test = new GravedadService();
		
		 assertEquals(test.getGravedadActual(0),9.807);

		 
			 test = new GravedadService();
			
			 assertEquals(test.getGravedadActual(5000), 3.081579286501497);
	}
	
}
