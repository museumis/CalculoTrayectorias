package com.museumis.calculo.trayectorias.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.museumis.calculo.trayectorias.model.input.Telemetria;
import com.museumis.calculo.trayectorias.model.output.TrayectoriaCalculada;
import com.museumis.calculo.trayectorias.servicio.Calculeitor;


/**
 * 
 * @author Museumis
 *
 */


@RestController
public class Controller {
	
	@Autowired 
	private Calculeitor servicio;
	
	@RequestMapping(value = "/getTrayectoria", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "*", maxAge = 3600)
	@ResponseBody
	public ResponseEntity<List<TrayectoriaCalculada>> getTrayectoria(@RequestBody   Telemetria telemetria)throws JsonMappingException, JsonProcessingException {
		
		System.out.println("Telemetria recibida: " + telemetria.toString());
		ResponseEntity<List<TrayectoriaCalculada>> trayectoriaCalculada = servicio.getTrayectoria(telemetria);
		System.out.println("Trayectori calculada: " + trayectoriaCalculada.toString());

		return trayectoriaCalculada;
	}
	

}
