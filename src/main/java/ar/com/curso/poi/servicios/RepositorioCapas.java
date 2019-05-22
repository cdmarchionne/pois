package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.Capa;
import ar.com.curso.poi.modelo.POI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCapas {

    private Map<String, Capa> capas = new HashMap<String, Capa>();

    private static RepositorioCapas instance = new RepositorioCapas();

    private RepositorioCapas() {

        Capa pizzerias = new Capa("pizzerias");
        pizzerias.setPOIs(crearCapaPizzerias());

        Capa realidadAumentada = new Capa("realidadAumentada");
        realidadAumentada.setPOIs(crearCapaCafeterias());

        capas.put(pizzerias.getNombre(), pizzerias);
        capas.put(realidadAumentada.getNombre(), realidadAumentada);
    }

    public static RepositorioCapas getInstance() {
        return instance;
    }

    public List<POI> getPOIs(String nombre) {

        return capas.get(nombre).getPOIs();
    }

    public Capa getCapa(String nombre) {

        return capas.get(nombre);
    }

    private List<POI> crearCapaPizzerias() {

        List<POI> pois = new ArrayList<POI>();
        pois.add(new POI(
            -34.603705,
            -58.379058,
            "Las cuartetas",
            "La mejor pizza a la piedra"));
        pois.add(new POI(
            -34.59762,
            -58.385527,
            "El cuartito",
            "Pizza con Faina increible"));
        pois.add(new POI(
            -34.60393,
            -58.38605,
            "Guerrin",
            "Pizeria al paso"));
        return pois;
    }

    public List<POI> crearCapaCafeterias() {

        List<POI> pois = new ArrayList<POI>();
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
        return pois;
    }

}
