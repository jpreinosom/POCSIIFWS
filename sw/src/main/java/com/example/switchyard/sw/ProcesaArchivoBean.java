package com.example.switchyard.sw;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(ProcesaArchivo.class)
public class ProcesaArchivoBean implements ProcesaArchivo {

	@Inject
	@Reference
	private ClienteRest service;
	
	@Override
	public void parseIniciaProceso(String contribuyente) {
		try {
			String [] lineas =  contribuyente.split("\n");
			String jo = "&";
			for (String line : lineas){
				if(line.trim().length() != 0){
					String[] detalle = line.split(",");
					
					String queryString = "start?map_rutLong=" + detalle[0].trim() + jo+"map_periodoLong=" + detalle[1].trim() + jo+"map_diferenciaLong=" + detalle[2].trim();
					System.out.println(queryString);
					service.llamadaRest(queryString);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
