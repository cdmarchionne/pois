package ar.com.curso.poi.servicios;

import java.util.List;

import org.junit.Test;

import ar.com.curso.poi.modelo.POI;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioPoiTest {
	
	@Test
	public void cuandoPidoUnaListaDePoisDevuelveUnaLista() {		
		List respuesta = RepositorioPOI.getInstance().getAll();
		
		assertThat(respuesta).isNotNull();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void cuandoPidoUnaListaDePoisDevuelveUnaListaNoVacia() {
		List<POI> respuesta = RepositorioPOI.getInstance().getAll();
		
		assertThat(respuesta).isNotEmpty();
	}

	@Test
	public void cuandoPidoUnaListaDePoisDevuelveUnaListaDePois() {
		List<POI> respuesta = RepositorioPOI.getInstance().getAll();		
		
		assertThat(respuesta.get(0)).isInstanceOf(POI.class);
	}

	@Test
	public void cuandoPidoUnaListaDePoisDevuelveUnaListaDePoisConLatLong() {
		List<POI> respuesta = RepositorioPOI.getInstance().getAll();		
		
		for(POI poi : respuesta) {
			
			assertThat(poi.getLatitud()).isNotNull();
			assertThat(poi.getLongitud()).isNotNull();
			assertThat(poi.getNombre()).isNotNull();
			assertThat(poi.getDescripcion()).isNotNull();
		}	
	}
}
