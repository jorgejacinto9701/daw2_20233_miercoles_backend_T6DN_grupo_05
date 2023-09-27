package com.centroinformacion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.service.RevistaService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/revista")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RevistaController {

	@Autowired
	private RevistaService service;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> registar(@RequestBody Revista revista) {
		HashMap<String, Object> map = new HashMap<>();
		
		Date fechaActual = new Date();
		revista.setFechaRegistro(fechaActual);
		revista.setFechaActualizacion(fechaActual);
		revista.setEstado(AppSettings.ACTIVO);
		
		Revista nueva = service.registrar(revista);
		
		if (nueva == null) {
			map.put("mensaje","Error en el registro");
			return ResponseEntity.badRequest().body(map);
		}
		
		map.put("mensaje", "Se registró la revista con el ID -> " + nueva.getIdRevista());
		
		return ResponseEntity.ok(map);
	}
	
}
