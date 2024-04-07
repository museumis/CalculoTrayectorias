package com.museumis.calculo.trayectorias.servicio;

import com.museumis.calculo.trayectorias.model.Cohete;
import com.museumis.calculo.trayectorias.model.input.Telemetria;

public class TsiolkovskiService {

	public double getAceleracionEscapeEtapaUno(Telemetria telemetria, double expulsion_gases_u) {
		
		Cohete cohete = telemetria.getCohete();
		
		double masaFinal = (cohete.getMasa_cohete_etapa_uno_kg()+ (cohete.getMasa_cohete_etapa_dos_kg()+cohete.getMasa_combustible_etapa_dos_kg() )  + cohete.getMasa_cargaUtil_kg());
		double masaInicial = cohete.getMasa_cohete_etapa_uno_kg()+ cohete.getMasa_cohete_etapa_dos_kg() + cohete.getMasa_combustible_etapa_uno_kg()+cohete.getMasa_combustible_etapa_dos_kg() + cohete.getMasa_cargaUtil_kg();
		
		double aceleracionMaxima =  (expulsion_gases_u * Math.log((masaInicial/masaFinal)));
		
		if(Double.isNaN(aceleracionMaxima)) {
			aceleracionMaxima=0;
		}
		
		return aceleracionMaxima;
	}
	
	public double getAceleracionEscapeEtapaDos(Telemetria telemetria, double expulsion_gases_u) {
		
		Cohete cohete = telemetria.getCohete();
		
		double masaFinal = (cohete.getMasa_cohete_etapa_dos_kg())  + cohete.getMasa_cargaUtil_kg();
		double masaInicial = cohete.getMasa_cohete_etapa_dos_kg()+ cohete.getMasa_combustible_etapa_dos_kg() + cohete.getMasa_cargaUtil_kg();
		
		double aceleracionMaxima =  (expulsion_gases_u * Math.log((masaInicial/masaFinal)));
		
		if(Double.isNaN(aceleracionMaxima)) {
			aceleracionMaxima=0;
		}
		
		return aceleracionMaxima;
	}
	
	
	/**
	 * 
	 * Saturno= 0.85 -> 85%de propelente
	 * 
	 * @param masaEtapa
	 * @param masaCombustible
	 * @param masa_cargaUtil
	 * @param telemetria
	 * @return
	 */
	public double getProporcionDeMasaRespectoDelPropepente(double masaEtapa,double masaCombustible,double masa_cargaUtil,Telemetria telemetria) {
		double retorno;
		double masaInicial = masaEtapa+ masaCombustible + masa_cargaUtil;
		
		retorno=(masaCombustible) / (masaInicial);
		
		return  retorno;				
	}
	
	public double getProporcionDeMasaRespectoDeCargaUtil(double masaEtapa,double masaCombustible,double masa_cargaUtil,Telemetria telemetria) {
		double retorno;
		double masaInicial = masaEtapa+ masaCombustible + masa_cargaUtil;
		
		retorno=(masa_cargaUtil) / (masaInicial);
		
		return  retorno;				
	}
	
	
	public double getVelocidadDeGasesCalculado(Telemetria telemetria,double gravedad) {

		return  gravedad * telemetria.getCohete().getImpulso_especifico_seg();				
	}
	
	

	

}
