package ar.com.curso.poi.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.com.curso.poi.modelo.POI;

public class RepositorioPOI {
	private static RepositorioPOI instance;

    private List<POI> pois;
    
    private RepositorioPOI() {
    	pois = new ArrayList<POI>();
    	inicializarPOIs();
    }
    
    private void inicializarPOIs() {
    	pois.add(new POI(
                -34.609573,
                -58.396187,
                "Los Angelitos",
                "Cafeteria con historia"));
    	
    	pois.add(new POI(
                -34.608801,
                -58.378084,
                "Cafe Tortoni",
                "Cafeteria con historia"));
    	
    	pois.add(new POI(
                -34.611245,
                -58.420911,
                "Las Violetas",
                "Cafeteria con historia"));
}
    
    public static RepositorioPOI getInstance() {
    	if (instance == null)
    		instance = new RepositorioPOI();
    	
    	return instance;
    }

	public List<POI> getAll() {
		return pois;
	}
}