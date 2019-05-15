package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;

public class CalculadorDeDistancia {

    public static Double calcularDistancia(POI poi, POI ubicacionActual) {

        Double distancia = Math.sqrt((Math.pow((poi.getLatitud() - ubicacionActual.getLatitud()), 2)
            + Math.pow((poi.getLongitud() - ubicacionActual.getLongitud()), 2)));

        return distancia;
    }

}
