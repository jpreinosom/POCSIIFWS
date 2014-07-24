package cl.gob.sii.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "giroVO")
public class GiroVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1965647798874622615L;

	 @XmlElement(name = "rut", required = true)	  
	private int rut;
	@XmlElement(name = "respuesta", required = false)
	private String respuesta;


	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}
	
	

}
