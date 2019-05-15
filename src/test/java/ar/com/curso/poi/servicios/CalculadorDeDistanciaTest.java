package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

public class CalculadorDeDistanciaTest {
	
	@Test
	public void testDistanciaNula() {
		
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI ubicacionActual = new POI(30D, 40D, "Mi casa", "Casa");
		
		Double distancia = CalculadorDeDistancia.calcularDistancia(poi, ubicacionActual);
		assertThat(distancia).isEqualTo(0.0);

	}
	
	@Test
	public void testDistancia() {
		
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI ubicacionActual = new POI(10D, 10D, "Mi casa", "Casa");
		
		Double distancia = CalculadorDeDistancia.calcularDistancia(poi, ubicacionActual);
		assertThat(distancia).isEqualTo(36.055, offset(0.1));

	}

}
