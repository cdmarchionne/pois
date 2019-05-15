package ar.com.curso.poi.rest;

import ar.com.curso.poi.modelo.POI;

public class PoiResponse {
	
	private POI poi;
	private String mensaje;
		
	public PoiResponse(POI poi) {
		this(poi,"OK");
	}
	
	public PoiResponse(POI poi, String mensaje) {
		super();
		this.poi = poi;
		this.mensaje = mensaje;
	}
	
	public POI getPoi() {
		return poi;
	}
	public void setPoi(POI poi) {
		this.poi = poi;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
