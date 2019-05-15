package ar.com.curso.poi.accept;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicoAceptacionIT {

	private String port;
	private String urlBase;
	private WebDriver seleniumDriver;

	@Before
	public void setUp() throws Exception {
		port = System.getProperty("servlet.port", "8080");
		urlBase = "http://localhost:" + port + "/pois-app";

		seleniumDriver = new PhantomJSDriver();
		seleniumDriver.manage().window().maximize();
		seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		seleniumDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}

	@Test
	public void smoke() throws Exception {
		URL url = new URL(urlBase + "/test");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		assertThat(connection.getResponseCode()).isEqualTo(200);
	}

//	@Test
	public void pizzeriaMasCercanaAlObelisco() throws Exception {

		String latitudObelisco = "-34.603765";
		String longitudObelisco = "-58.381570";

		String url = urlBase +"/poiMasCercano/pizzerias/"+latitudObelisco+"/"+longitudObelisco;

		String respuesta = this.obtenerContenidoRespuesta(url);
		assertThat(respuesta).contains("cuartetas");
	}

	private String obtenerContenidoRespuesta(String url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.connect();
		return new BufferedReader(
				new InputStreamReader(
					connection.getInputStream())).readLine();
	}

//	@Test
	public void pizzeriaMasCercanaAlObeliscoConSelenium(){

		String latitudOblelisco = "-34.603765";
		String longitudObleisco = "-58.381570";

		String url = urlBase +"/poiMasCercano/pizzerias/"+latitudOblelisco+"/"+longitudObleisco;

		seleniumDriver.get(url);
		assertThat(seleniumDriver.getPageSource()).contains("cuartetas");
	}
	
	@Test
	public void cafeteriaMasCercanaAUbicacionActual() throws Exception {
		String latitudUbicacionActual = "-34.609573";
		String longitudUbicacionActual = "-58.396187";

		String url = urlBase +"/poiMasCercano/realidadAumentada/"+latitudUbicacionActual+"/"+longitudUbicacionActual;

		String respuesta = this.obtenerContenidoRespuesta(url);
		assertThat(respuesta).contains("Los Angelitos");		
	}

	@Test
	public void cafeteriaMasCercanaAlObelisco() throws Exception {
		String latitudObelisco = "-34.603765";
		String longitudObelisco = "-58.381570";

		String url = urlBase +"/poiMasCercano/realidadAumentada/"+latitudObelisco+"/"+longitudObelisco;

		String respuesta = this.obtenerContenidoRespuesta(url);
		assertThat(respuesta).contains("Cafe Tortoni");		
	}

}
