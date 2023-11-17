package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.service.EditorialService;

@RestController
@RequestMapping("/url/consultaEditorial")
@CrossOrigin(origins = "http://localhost:4200")
public class EditorialConsultaController {

	
	@Autowired
	private EditorialService service;
	
	
	@GetMapping("/porParametros")
	@ResponseBody
	public List<Editorial> listaDinamica(
										 @RequestParam(name = "razonSocial", required = false, defaultValue = "") String razonSocial,
										 @RequestParam(name = "direccion", required = false, defaultValue = "") String direccion,
										 @RequestParam(name = "ruc", required = false, defaultValue = "") String ruc,
										 @RequestParam(name = "estado", required = true, defaultValue = "1") int estado){
		List<Editorial> lista = service.listaDinamica("%"+razonSocial.toLowerCase() + "%", direccion, ruc, estado);
		
		return lista;
	}
}
