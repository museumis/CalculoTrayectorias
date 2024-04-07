package com.museumis.calculo.trayectorias.servicio;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.museumis.calculo.trayectorias.model.input.Telemetria;
import com.museumis.calculo.trayectorias.model.output.TrayectoriaCalculada;


/**
 * 
 * @author Museumis
 *
 *
 *
 *
 *
 *JSON entrada
 *
 *
 *{
   
        "cohete": {
            "nombre": "Victorino 1",
            "masa_inicial": 1,
            "v_expulsion_gases_u": 1000,
            "tiempo_quemado": 60000
        },
        "clima": {
            "temperatura_ambiente": 23
        }
    
}

 */

@Service
public class Calculeitor {
	
	


	public ResponseEntity<List<TrayectoriaCalculada>> getTrayectoria(Telemetria telemetria) {
		
		//Preparación
		List<TrayectoriaCalculada> trayectoriasCalculadas = new ArrayList<>();
		TrayectoriaCalculada trayectoriaActual;		
			
		//Ejecucion de los calculos iniciales
		trayectoriaActual = new TrayectoriaCalculada();

		
		double tiempoActual = 0;
		trayectoriaActual.setTiempo_seg(tiempoActual);
		
		//GRAVEDAD 
		GravedadService gravedadService = new GravedadService();
		double gravedadActual = gravedadService.getGravedadActual(telemetria.getCohete().getAltitud_cohete_km());
		trayectoriaActual.setGravedad_ms2(gravedadActual);			
		
		
		TsiolkovskiService tsiolkovService = new TsiolkovskiService();		
		//Velodudad de expulsion de gases calculado
		trayectoriaActual.setVelocidad_de_escape_ms(tsiolkovService.getVelocidadDeGasesCalculado(telemetria, gravedadActual));
		double velocidadEscapeGases = trayectoriaActual.getVelocidad_de_escape_ms();
						
		
		//Aceleracion de escape
		double aceleracionEscapeEtapa1= tsiolkovService.getAceleracionEscapeEtapaUno(telemetria,velocidadEscapeGases);
		double aceleracionEscapeEtapa2= tsiolkovService.getAceleracionEscapeEtapaDos(telemetria,velocidadEscapeGases);
		
		double aceleracionTotalDeEscape = aceleracionEscapeEtapa1 + aceleracionEscapeEtapa2;
		trayectoriaActual.setAceleracion_de_escape_etapa_uno_ms(aceleracionEscapeEtapa1);
		trayectoriaActual.setAceleracion_de_escape_etapa_dos_ms(aceleracionEscapeEtapa2);				
		trayectoriaActual.setAceleracion_de_escape_total_ms(aceleracionTotalDeEscape);
		
		
		//Porcentajes de propelente respecto de la masa
		double fraccionDePropelenteEtapa1 =tsiolkovService.getProporcionDeMasaRespectoDelPropepente(telemetria.getCohete().getMasa_cohete_etapa_uno_kg(),telemetria.getCohete().getMasa_combustible_etapa_uno_kg(),telemetria.getCohete().getMasa_cargaUtil_kg(),telemetria);
		double fraccionDePropelenteEtapa2 =tsiolkovService.getProporcionDeMasaRespectoDelPropepente(telemetria.getCohete().getMasa_cohete_etapa_dos_kg(),telemetria.getCohete().getMasa_combustible_etapa_dos_kg(),telemetria.getCohete().getMasa_cargaUtil_kg(),telemetria);
		double fraccionDePropelenteCargatil = tsiolkovService.getProporcionDeMasaRespectoDeCargaUtil(telemetria.getCohete().getMasa_cohete_etapa_uno_kg(),telemetria.getCohete().getMasa_combustible_etapa_uno_kg(),telemetria.getCohete().getMasa_cargaUtil_kg(),telemetria);

		trayectoriaActual.setFraccionDePropelenteEtapaUno_porcentaje(fraccionDePropelenteEtapa1);
		trayectoriaActual.setFraccionDePropelenteEtapaDos_porcentaje(fraccionDePropelenteEtapa2);
		trayectoriaActual.setFraccionDeCargaUtil_porcentaje(fraccionDePropelenteCargatil);

		
		
		//VELOCIDAD de escape OK!
		NewtonService newtonService = new NewtonService();
		trayectoriaActual.setVelocidad_de_escape_ms(newtonService.getVelocidadEscape(tiempoActual,velocidadEscapeGases ,telemetria, gravedadActual));
		
		
		trayectoriasCalculadas.add(trayectoriaActual);				
			
	
		
		ResponseEntity<List<TrayectoriaCalculada>> respuesta = new ResponseEntity<>(trayectoriasCalculadas,HttpStatus.OK);		
		return respuesta;
	}
	
	
	
}
