# language: es

Característica: Obtener el punto más cercano a mi ubicación
    Para tener que caminar poco
    Como usuario
    Quiero obtener el punto de interes de un servicio más cercano a mi ubicación acutal

Escenario: Obtener el punto más cercano a mi ubicación para el servicio de realidadAumentada
    Dado que estoy en -34.603765 y -58.381570
    Cuando pido el POI mas cercano del servicio realidadAumentada
    Entonces el servicio devuelve solo Cafe Tortoni

#Escenario: Latitud < 0 y Longitud < 0 => NO Muestra Error 

Escenario: Latitud < 0 y Longitud > 0 => Muestra Error 
	Dado que estoy en -34.603765 y 58.381570
	Cuando pido el POI mas cercano del servicio realidadAumentada
	Entonces el servicio devuelve el mensaje "el punto ingresado es invalido"

Escenario: Latitud > 0 y Longitud < 0 => Muestra Error
	Dado que estoy en 34.603765 y -58.381570
	Cuando pido el POI mas cercano del servicio realidadAumentada
	Entonces el servicio devuelve el mensaje "el punto ingresado es invalido"

Escenario: Latitud > 0 y Longitud > 0 => Muestra Error
	Dado que estoy en 34.603765 y 58.381570
	Cuando pido el POI mas cercano del servicio realidadAumentada
	Entonces el servicio devuelve el mensaje "el punto ingresado es invalido"
	
Escenario: Obtener el punto más cercano a mi ubicación para el servicio de pizzerias
    Dado que estoy en -34.603705 y -58.379058
    Cuando pido el POI mas cercano del servicio pizzerias
    Entonces el servicio devuelve solo Las cuartetas

Escenario: Obtener el punto más cercano a mi ubicación para el servicio de pizzerias
    Dado que estoy en -34.603705 y -58.379058
    Cuando pido el POI mas cercano del servicio pizzerias
    Entonces el servicio no devuelve ninguno de los siguientes puntos Cafe Tortoni, Los Angelitos y Las Violetas
