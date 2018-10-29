package com.proyecto.prueba.servicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.prueba.contolador.pdfServicio;
import com.proyecto.prueba.entidades.LecturaService;

@RestController
@RequestMapping("/convertidor")
public class PersonaController {

	@Autowired
	private pdfServicio servicio;


	@PostMapping("/leer")
	public LecturaService nombreArchivo(@RequestParam("archivo") MultipartFile file) throws IOException
	{
		
		String ruta = new File("").getAbsolutePath();
		ruta = ruta + "\\src\\main\\resources\\archivosSubidos\\";
		byte[] archivos = file.getBytes();
		Path ruteo = Paths.get(ruta + file.getOriginalFilename());
		Files.write(ruteo, archivos);
		File valorRetorno = new File(ruta + file.getOriginalFilename());
		
		
		String parsedText = "*";
		PDFParser parser = null;
		try {
			parser = new PDFParser(new RandomAccessFile((File) valorRetorno, "r"));
			parser.parse();
			
			COSDocument cosDoc = parser.getDocument();
			PDFTextStripper pdfStripper = new PDFTextStripper();
			PDDocument pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return servicio.getPersonas(parsedText).get(0);
	}

}
