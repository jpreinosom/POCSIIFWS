package com.example.switchyard.sw;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import cl.gob.sii.vo.GiroVO;

@Service(GiroService.class)
public class GiroServiceBean implements GiroService {
	@Context
	private HttpServletRequest request;
	private GiroVO giroVo;
	@Inject
	@Reference
	private EmiteGiroService service;
	@Override
	@GET
	public String emiteGiro(String msg) {
		 giroVo = new GiroVO();
		 System.out.println("++++++ getItem Giro +++++++ " + this.request.getQueryString());
		 String queryString = (String) this.request.getQueryString();
		 String [] arrAtributos = queryString.split("&");
		 for (String line : arrAtributos){
			 String [] atributoLinea = line.split("=");
			 giroVo.setRut(new Integer(atributoLinea[1]));
		 }
		 giroVo = service.emiteGiro(giroVo);
	     return giroVo.getRespuesta();
	}

}
