package ar.com.curso.poi.kata.tdd;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class CerraduraTest {

	@Test
	public void crearCerraduraConClaveYCantidadDeFallos() {
		Cerradura c = new Cerradura(1234,3);
		assertThat(c).isNotNull();
		assertThat(c.getClave()).isEqualTo(1234);
		assertThat(c.getCantidadDeFallos()).isEqualTo(3);
	}

	@Test
	public void crearOtraCerraduraConClaveYCantidadDeFallos() {
		Cerradura c = new Cerradura(123456,10);
		assertThat(c).isNotNull();
		assertThat(c.getClave()).isEqualTo(123456);
		assertThat(c.getCantidadDeFallos()).isEqualTo(10);
	}
	
	@Test
	public void abrirConClaveCorrecta() {
		Cerradura c = new Cerradura(1234,3);
		assertThat(c.abrir(1234)).isTrue();
	}
	
	@Test
	public void abrirConClaveIncorrecta() {
		Cerradura c = new Cerradura(1234,3);
		assertThat(c.abrir(12345)).isFalse();
	}
	
	@Test
	public void cerrarCerradura_Cierra() {
		Cerradura c = new Cerradura(12345,5);
		c.cerrar();
		
		assertThat(c.estaCerrada()).isTrue();
	}
	
	@Test
	public void noCerrarCerradura_NoCierra() {
		Cerradura c = new Cerradura(12345,5);
		c.abrir(12345);
		
		assertThat(c.estaCerrada()).isFalse();
	}
	
	@Test
	public void alCerrar_NoQuedaAbierta() {
		Cerradura c = new Cerradura(12345,5);
		c.cerrar();
		
		assertThat(c.estaAbierta()).isFalse();
	}
	
	@Test
	public void alAbrir_QuedaAbierta() {
		Cerradura c = new Cerradura(12345,5);
		c.abrir(12345);
		
		assertThat(c.estaAbierta()).isTrue();
	}
	
	@Test
	public void alAbrir_NoQuedaCerrada() {
		Cerradura c = new Cerradura(12345,5);
		c.abrir(12345);
		
		assertThat(c.estaCerrada()).isFalse();
	}
	
	@Test
	public void alAbrirDpsDeCerrar_NoQuedaCerrada() {
		Cerradura c = new Cerradura(12345,5);
		c.abrir(12345);
		c.cerrar();
		c.abrir(12345);
		
		assertThat(c.estaAbierta()).isTrue();
	}
}
