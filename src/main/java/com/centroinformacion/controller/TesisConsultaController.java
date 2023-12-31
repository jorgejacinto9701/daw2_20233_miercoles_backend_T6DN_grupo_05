package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Tesis;
import com.centroinformacion.service.TesisService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/consultaTesis")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TesisConsultaController {

	@Autowired
	private TesisService service;
	
	
	//consulta
	@GetMapping("/consultaTesisPorParametros")
	@ResponseBody 
	  public List<Tesis> listaConsultaDocente(
	    @RequestParam(value = "titulo", required = false , defaultValue = "") String titulo,
	    @RequestParam(value = "tema", required = false , defaultValue = "") String tema ,
	    @RequestParam(value = "estado", required = false , defaultValue = "1") int estado ,
	    @RequestParam(value = "idAlumno", required = false , defaultValue = "-1") int alumno ) {
	        
		List<Tesis> lstSalida = service.listaConsultaDinamica("%"+ titulo + "%" , "%"+ tema + "%" , estado , alumno ) ;
		
	        return lstSalida;       
	} 
	 
} 
