package com.example.switchyard.sw;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.switchyard.component.bean.Property;
import org.switchyard.component.bean.Service;

@Service(ClienteRest.class)
public class ClienteRestBean implements ClienteRest {

	@Property(name="BASE_URL")
	private static String BASE_URL;
	@Property(name="DEPLOYMENT_ID")
	private static String DEPLOYMENT_ID;
	@Property(name="PROCESS_DEF_ID")
	private static String PROCESS_DEF_ID;
	@Property(name="username")
	private static String username;
	@Property(name="password")
	private static String password;
	
	@Override
	public String llamadaRest(String mensaje) {
		String dataFromService =  new String();
		String newInstanceUrl = BASE_URL + "runtime/" + DEPLOYMENT_ID 	+ "/process/" + PROCESS_DEF_ID + "/";
		try {
			dataFromService = getDataFromService(newInstanceUrl, "POST",	mensaje, true);
			System.out.println(dataFromService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataFromService;
	}
	
	private static String getDataFromService(String urlpath, String method,
			String mensaje, boolean multipart) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		Thread.sleep(1000);
		HttpPost theMethod = null;
		String[] detalle = mensaje.split(",");
		String jo = "&";
		String queryString = "start?map_rutLong=" + detalle[0].trim() + jo+"map_periodoLong=" + detalle[1].trim() + jo+"map_diferenciaLong=" + detalle[2].trim();
		urlpath += queryString; 
		theMethod = new HttpPost(urlpath);
		 BasicScheme basicAuth = new BasicScheme();
	      
	        Header auth=null;
	        try {
	            auth = basicAuth.authenticate(new
	                      UsernamePasswordCredentials(username, password), theMethod);
	        } catch (AuthenticationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        System.out.println(auth.getName());
	            System.out.println(auth.getValue());
	            theMethod.setHeader(auth);
		
		
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
