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
					@RequestParam(name = "numero" , required = false, defaultValue = "") String numero,
					@RequestParam(name = "piso" , required = false, defaultValue = "0") int piso,
					@RequestParam(name = "recursos" , required = false, defaultValue = "") String recursos,
					@RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
					@RequestParam(name = "idTipoSala" , required = false, defaultValue = "-1") int idTipoSala,
					@RequestParam(name = "idSede" , required = false, defaultValue = "-1") int idSede){

		List<Sala> lstSalida = service.listaConsultaDinamica("%"+ numero + "%", piso, "%"+ recursos + "%",estado, idTipoSala, idSede);
		
		return lstSalida;
	}
	

}
