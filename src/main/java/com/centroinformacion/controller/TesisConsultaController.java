package com.centroinformacion.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Tesis;
import com.centroinformacion.service.TesisService;




@RestController
@RequestMapping("/url/consultaTesis")
@CrossOrigin(origins = "http://localhost:4200")
public class TesisConsultaController {

	@Autowired
	private TesisService service;
	//consulta
	@GetMapping("/consultaTesisPorParametros")
	@ResponseBody 
	  public List<Tesis> listaConsultaDocente(
	    @RequestParam(value = "titulo", required = false , defaultValue = "") String titulo,
	    @RequestParam(value = "tema", required = false , defaultValue = "") String tema ,
	    @RequestParam(value = "estado", required = false , defaultValue = "") int estado ,
	    @RequestParam(value = "alumno", required = false , defaultValue = "-1") int alumno ) {
	        
		List<Tesis> lstSalida = service.listaConsultaDinamicatesis("%"+ titulo + "%" , tema , estado , alumno ) ;
		
	        return lstSalida;       
	}
	
}
