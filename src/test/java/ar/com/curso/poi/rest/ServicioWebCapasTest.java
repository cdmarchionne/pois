package ar.com.curso.poi.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ServicioWebCapasTest {
	
	private ServicioWebCapas servicioWebCapas;
	
	@Before
	public void init() {
		servicioWebCapas = new ServicioWebCapas();
	}
	
	@Test
	public void alIngresarUnaCoordenadaValidaRetornaMensajeOK() {
		assertThat(servicioWebCapas.obtenerPOIMasCercano("realidadAumentada", "-34", "-58")).isInstanceOf(PoiResponse.class);
	}
	
	@Test
	public void alIngresarCoordenadasInvalidasNoDevuelveUnPoiYdaMensajeNoValido() {
		PoiResponse response = servicioWebCapas.obtenerPOIMasCercano("realidadAumentada", "-34", "45");
		
		assertThat(response.getMensaje()).isEqualTo(ServicioWebCapas.MENSAJE_ERROR_COORDENADA_INVALIDA);
	}

}
