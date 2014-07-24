package cl.util;

import java.util.Map;

import org.apache.camel.component.test.TestComponent;
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



public class RestClient {
	private static final String BASE_URL = "http://localhost:8080/log/log/manejoLog";
	private static final String DEPLOYMENT_ID = "cii.sii.domain:Nomina_contribuyentes:1.0";
	//private static final String PROCESS_DEF_ID = "Nomina_contribuyentes.Asignacion_casos";
	private static final String PROCESS_DEF_ID = "Nomina_contribuyentes.PruebaRemoto";
	 public static void main(String[] args) throws Exception {
		 testConnection();
	 }
	private static void testConnection() {
		String newInstanceUrl = BASE_URL;// + "runtime/" + DEPLOYMENT_ID 	+ "/process/" + PROCESS_DEF_ID + "/start";
		try {
			String dataFromService = getDataFromService(newInstanceUrl, "POST",	null, true);
			System.out.println(dataFromService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static String getDataFromService(String urlpath, String method,
			Map<String, String> params, boolean multipart) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost theMethod = null;
		StringBuffer sb = new StringBuffer();
		//String username = "javier";
		//String password = "Redhat2014.";
		String jo = "&";
		//urlpath +="/inventory/order"; 
		theMethod = new HttpPost(urlpath);
		 BasicScheme basicAuth = new BasicScheme();
	      
	        Header auth=null;
	     /*   try {
	            auth = basicAuth.authenticate(new
	                      UsernamePasswordCredentials("javier", "Redhat2014."), theMethod);
	        } catch (AuthenticationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        System.out.println(auth.getName());
	            System.out.println(auth.getValue());
	            theMethod.setHeader(auth);*/
		
		
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
