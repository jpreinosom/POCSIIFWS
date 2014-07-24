package com.example.switchyard.sw;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.switchyard.component.bean.Service;

import cl.gob.sii.vo.GiroVO;

@Service(EmiteGiroService.class)
public class EmiteGiroServiceBean implements EmiteGiroService {

	@Override
	public GiroVO emiteGiro(GiroVO giroVo) {
		// TODO LOGICA SII
		String BASE_URL = "http://10.20.17.121:8080";
		
		
		int rut = giroVo.getRut();
		
		
		String dataFromService =  new String();
		String newInstanceUrl = BASE_URL;
		String mensaje = "?" + giroVo.getRut();
		try {		
			
			giroVo.setRespuesta(getDataFromService(newInstanceUrl, "GET",	mensaje, true));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return giroVo;
	}
	private static String getDataFromService(String urlpath, String method,
			String mensaje, boolean multipart) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet theMethod = null;
		urlpath += mensaje; 
		theMethod = new HttpGet(urlpath);
		 BasicScheme basicAuth = new BasicScheme();
	      
		
		try {
			HttpResponse response = httpclient.execute(theMethod);
			 HttpEntity r_entity = response.getEntity();
			System.out.println("Call " + theMethod.getURI() + " :: result = " + response);
			byte[] result = EntityUtils.toByteArray(r_entity);
			String resultado = new String(result);
			
			return resultado;

		} catch (Exception e) {
			throw e;
		} finally {
			theMethod.releaseConnection();
		}

	}

}
