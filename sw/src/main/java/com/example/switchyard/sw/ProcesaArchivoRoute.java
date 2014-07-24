package com.example.switchyard.sw;

import org.apache.camel.builder.RouteBuilder;

public class ProcesaArchivoRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://ProcesaArchivo")
		 .split(body(String.class).tokenize("\n"))
            .to("switchyard://ClienteRest")
				;
	}

}
