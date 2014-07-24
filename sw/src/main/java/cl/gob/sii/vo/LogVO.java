package cl.gob.sii.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "logVO")
public class LogVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1965647798874622615L;
	 @XmlElement(name = "log", required = true)	  
	private String log;
	@XmlElement(name = "respuesta", required = false)
	private String respuesta;

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	

}
