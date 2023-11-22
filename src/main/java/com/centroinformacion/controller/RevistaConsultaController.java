package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.service.RevistaService;

@RestController
@RequestMapping("/url/consultaRevista")
@CrossOrigin(origins = "http://localhost:4200")
public class RevistaConsultaController {

	@Autowired
	private RevistaService service;
	
	@GetMapping()
	@ResponseBody
	public List<Revista> listaConsultaSala( 
			@RequestParam(name = "nombre" , required = false, defaultValue = "") String nombre,
			@RequestParam(name = "frecuencia" , required = false, defaultValue = "") String frecuencia,
			@RequestParam(name = "idTipoRevista" , required = false, defaultValue = "-1") int idTipoRevista,
			@RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
			@RequestParam(name = "idPais" , required = false, defaultValue = "-1") int idPais) {

		List<Revista> lstRevista = service.listaConsultaDinamica("%" + nombre + "%", "%" + frecuencia + "%",
				idTipoRevista, estado, idPais);
		
		return lstRevista;
	}
	
}
