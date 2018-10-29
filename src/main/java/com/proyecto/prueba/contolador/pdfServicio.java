package com.proyecto.prueba.contolador;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.proyecto.prueba.entidades.LecturaService;


@Service
public class pdfServicio {


	public List<LecturaService> getPersonas(String texto)
	{

		texto=clenTextAcents(texto);
		System.out.println(texto);

		String reesguardo=   		texto.substring(texto.indexOf("se registra el Resguardo Indigena"), texto.indexOf("en las bases de datos de esta Direccion")).replace("se registra el Resguardo Indigena","");;
		String nombreSenor_a=   	texto.substring(texto.indexOf("el Senor (a):"), texto.indexOf(", identificado (a)")).replace("el Senor (a): ","");
		String numeroDeDocumento=   texto.substring(texto.indexOf("identificado (a) con numero de documento:"), texto.indexOf(",",texto.indexOf("identificado (a) con numero de documento:"))).replace("identificado (a) con numero de documento: ","");
		String fechaDeCensos=   	texto.substring(texto.indexOf("en el(los) censo(s) del(los) ano(s)"), texto.indexOf(".",texto.indexOf("en el(los) censo(s) del(los) ano(s)"))).replace("en el(los) censo(s) del(los) ano(s) ","");
		String LugaryFechaExpide=   texto.substring(texto.indexOf("Se expide en"), texto.indexOf(".",texto.indexOf("a los dias"))).replace("Se expide en","");
		String UrlVerificacion=   	texto.substring(texto.indexOf("Url Verificacion"), texto.indexOf("Cualquier aclaracion adicional sobre el presente documento,")).replace("Url Verificacion ","");

		LecturaService data=new LecturaService(reesguardo,nombreSenor_a,numeroDeDocumento,fechaDeCensos,LugaryFechaExpide,UrlVerificacion);
		List<LecturaService> listadoPersonas = new ArrayList<>();
		listadoPersonas.add(data);
		return listadoPersonas;
	}

	public String clenTextAcents(String string)
	{
		String stringcleaned;
		stringcleaned=StringUtils.stripAccents(string );
		stringcleaned=stringcleaned.replace("\n", " ").replace("\r", "");;
		return stringcleaned;

	}

}
