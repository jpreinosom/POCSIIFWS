package cl.util;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import cl.gob.sii.vo.LogVO;

import com.example.switchyard.sw.GuardaLogService;


@Service(Log.class)
public class LogBean implements Log {
	@Context
	private HttpServletRequest request;
	private LogVO logVo;
	@Inject
	@Reference
	private GuardaLogService service;

	@Override
	@POST
	public String getItem(String msg) {
		logVo = new LogVO();
		 System.out.println("++++++ getItem Log +++++++ " + this.request.getQueryString());
			String queryString = (String) this.request.getQueryString();
			 String [] arrAtributos = queryString.split("&");
			 for (String line : arrAtributos){
				 String [] atributoLinea = line.split("=");
				 logVo.setLog(atributoLinea[1].replace("%", " "));
			 }
			 logVo = service.guardaLog(logVo); 
		 System.out.println("respuesta " +  logVo.getRespuesta());
		 return logVo.getRespuesta();
	}
}