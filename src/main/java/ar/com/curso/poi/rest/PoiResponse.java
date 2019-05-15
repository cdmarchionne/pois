package ar.com.curso.poi.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ar.com.curso.poi.modelo.POI;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PoiResponse implements Serializable {
	
	private static final long serialVersionUID = -1048158961811032556L;
	private POI poi;
	private String mensaje;
		
	public PoiResponse() {
	}
	
	public PoiResponse(POI poi) {
		this(poi,"OK");
	}
	
	public PoiResponse(POI poi, String mensaje) {
		super();
		this.poi = poi;
		this.mensaje = mensaje;
	}
	
	@XmlElement
	public POI getPoi() {
		return poi;
	}
	public void setPoi(POI poi) {
		this.poi = poi;
	}

	@XmlElement
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
