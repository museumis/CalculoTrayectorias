package com.museumis.calculo.trayectorias;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.museumis.calculo.trayectorias.model.Cohete;
import com.museumis.calculo.trayectorias.model.input.Telemetria;
import com.museumis.calculo.trayectorias.servicio.TsiolkovskiService;

/*
 * Servicio para calcular la velocidad variable con la segunda ley de Newton 
 */

public class TsiolkovskiServiceTest {



	@Test
	public void getAceleracionTest() {	
		
		Cohete cohete = new Cohete();
		Telemetria telemetria = new Telemetria();
		TsiolkovskiService test = new TsiolkovskiService();	

		cohete.setMasa_cohete_etapa_uno_kg(4000);
		cohete.setMasa_combustible_etapa_uno_kg(1000);
		
		telemetria.setCohete(cohete);
		
		assertEquals(test.getAceleracionEscapeEtapaUno(telemetria,4.4), 0.981831625782523);

		
		cohete = new Cohete();
		cohete.setMasa_cohete_etapa_uno_kg(1000);
		cohete.setMasa_combustible_etapa_uno_kg(4000);
		cohete.setMasa_cohete_etapa_dos_kg(200);
		cohete.setMasa_combustible_etapa_dos_kg(800);
		telemetria = new Telemetria();
		telemetria.setCohete(cohete);
		
		test = new TsiolkovskiService();	
		double aceleracionEtapa1 = test.getAceleracionEscapeEtapaUno(telemetria,4.4);
		double aceleracionEtapa2 = test.getAceleracionEscapeEtapaDos(telemetria,4.4);
		double aceleracionTotal = aceleracionEtapa1 + aceleracionEtapa2;
		assertEquals(aceleracionEtapa1, 4.833894070139683);
		assertEquals(aceleracionEtapa2, 7.081526814710042);
		assertEquals(aceleracionTotal, 11.915420884849725);
		
		
		cohete = new Cohete();
		cohete.setMasa_cohete_etapa_uno_kg(10000);
		cohete.setMasa_combustible_etapa_uno_kg(100000);
		cohete.setMasa_cargaUtil_kg(5000);
		telemetria = new Telemetria();
		telemetria.setCohete(cohete);
		
		test = new TsiolkovskiService();	
		assertEquals(test.getAceleracionEscapeEtapaUno(telemetria,2000), 4073.7638545220802);

		cohete = new Cohete();
		cohete.setMasa_cohete_etapa_uno_kg(5000);
		cohete.setMasa_combustible_etapa_uno_kg(50000);
		cohete.setMasa_cohete_etapa_dos_kg(5000);
		cohete.setMasa_combustible_etapa_dos_kg(50000);
		cohete.setMasa_cargaUtil_kg(5000);
		telemetria = new Telemetria();
		telemetria.setCohete(cohete);
		
		test = new TsiolkovskiService();	
		 aceleracionEtapa1 = test.getAceleracionEscapeEtapaUno(telemetria,4414.5);
		 aceleracionEtapa2 = test.getAceleracionEscapeEtapaDos(telemetria,4414.5);
		 aceleracionTotal = aceleracionEtapa1 + aceleracionEtapa2;
		assertEquals(aceleracionEtapa1, 2518.6702777052774);
		assertEquals(aceleracionEtapa2, 7909.7221769072485);
		assertEquals(aceleracionTotal, 10428.392454612525);

	}	

	@Test
	public void getFraccionPropelenteTest() {	
		
		Cohete cohete = new Cohete();
		Telemetria telemetria = new Telemetria();		
		TsiolkovskiService test = new TsiolkovskiService();	
		
		cohete = new Cohete();
		cohete.setMasa_cohete_etapa_uno_kg(10000);
		cohete.setMasa_combustible_etapa_uno_kg(100000);
		cohete.setMasa_cargaUtil_kg(5000);
		telemetria = new Telemetria();
		telemetria.setCohete(cohete);
		
		test = new TsiolkovskiService();	
		assertEquals(test.getProporcionDeMasaRespectoDelPropepente(cohete.getMasa_cohete_etapa_uno_kg(),cohete.getMasa_combustible_etapa_uno_kg(),cohete.getMasa_cargaUtil_kg(),telemetria), 0.8695652173913043);
				
	}
	
	@Test
	public void getFraccionCargaUtilTest() {	
		
		Cohete cohete = new Cohete();
		Telemetria telemetria = new Telemetria();		
		TsiolkovskiService test = new TsiolkovskiService();	
		
		cohete = new Cohete();
		cohete.setMasa_cohete_etapa_uno_kg(10000);
		cohete.setMasa_combustible_etapa_uno_kg(100000);
		cohete.setMasa_cargaUtil_kg(5000);
		telemetria = new Telemetria();
		telemetria.setCohete(cohete);
		
		test = new TsiolkovskiService();	
		assertEquals(test.getProporcionDeMasaRespectoDeCargaUtil(cohete.getMasa_cohete_etapa_uno_kg(),cohete.getMasa_combustible_etapa_uno_kg(),cohete.getMasa_cargaUtil_kg(),telemetria), 0.043478260869565216);
		
	}
	
}
