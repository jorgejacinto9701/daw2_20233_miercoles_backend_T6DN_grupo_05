package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.service.RevistaService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/crudRevista")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RevistaCrudController {

	@Autowired
	private RevistaService service;
	
	@GetMapping("/listarRevistaPorNombre/{nombre}")
	@ResponseBody
	public ResponseEntity<List<Revista>> listarPorNombreLike(@PathVariable("nombre") String nombre) {
		List<Revista> listaRevista = null;
		
		try {
			if (nombre.equals("todos")) {
				listaRevista = service.listarPorNombreLike("%");
			} else {
				listaRevista = service.listarPorNombreLike("%" + nombre + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(listaRevista);
	}
	
	@PostMapping("/registrarRevista")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registrar(@RequestBody Revista r) {
		Map<String, Object> salida = new HashMap<>();
		
		try {
			r.setFechaRegistro(new Date());
			r.setFechaActualizacion(new Date());
			r.setEstado(AppSettings.ACTIVO);
			
			Revista nueva = service.registrar(r);
			
			if (nueva == null) {
				salida.put("mensaje", "Error en el registro");
			} else {
				salida.put("mensaje", "Se registró la revista con ID => " + nueva.getIdRevista());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizarRevista")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Revista r) {
		Map<String, Object> salida = new HashMap<>();
		
		try {
			r.setFechaRegistro(new Date());
			r.setFechaActualizacion(new Date());
			
			Revista nueva = service.actualizar(r);
			
			if (nueva == null) {
				salida.put("mensaje", "Error en la actualización");
			} else {
				salida.put("mensaje", "Se actualizó la revista con ID => " + nueva.getIdRevista());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminarRevista/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminar(@PathVariable("id") int idRevista) {
		Map<String, Object> salida = new HashMap<>();
		
		try {
			service.eliminar(idRevista);
			salida.put("mensaje","Revista eliminada correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en la eliminación");
		}
		return ResponseEntity.ok(salida);
	}
}
