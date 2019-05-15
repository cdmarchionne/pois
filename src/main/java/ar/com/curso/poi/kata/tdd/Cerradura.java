package ar.com.curso.poi.kata.tdd;

import java.math.BigDecimal;

public class Cerradura {

	private int clave;
	private int cantFallos;
	private boolean estaCerrada = false;

	public Cerradura(int clave, int cantFallos) {
		this.clave = clave;
		this.cantFallos = cantFallos;
	}

	public int getClave() {
		return clave;
	}

	public int getCantidadDeFallos() {
		return cantFallos;
	}

	public boolean abrir(int clave) {
		boolean claveCorrecta = (this.clave == clave);
		if (claveCorrecta)
			estaCerrada = false;
		
		return claveCorrecta;
	}

	public void cerrar() {
		estaCerrada = true;
	}

	public boolean estaCerrada() {
		return estaCerrada;
	}

	public boolean estaAbierta() {
		return !estaCerrada;
	}

}
