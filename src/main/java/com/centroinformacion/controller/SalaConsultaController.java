package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Sala;
import com.centroinformacion.service.SalaService;

@RestController
@RequestMapping("/url/consultaSala")
@CrossOrigin(origins = "http://localhost:4200")
public class SalaConsultaController {
	
	@Autowired
	private SalaService service;
	
	@GetMapping("/consultaSalaPorParametros")
	@ResponseBody
	public List<Sala> listaConsultaSala( 
					@RequestParam(name = "nombre" , required = false, defaultValue = "") String nombre,
					@RequestParam(name = "piso" , required = false, defaultValue = "1") int piso,
					@RequestParam(name = "recursos" , required = false, defaultValue = "") String recursos,
					@RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
					@RequestParam(name = "idDataCatalogo" , required = false, defaultValue = "-1") int idDataCatalogo){

		List<Sala> lstSalida = service.listaConsultaDinamica("%"+ nombre + "%", piso, "%"+ recursos + "%", estado, idDataCatalogo);
		
		return lstSalida;
	}
	

}
