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

import com.centroinformacion.entity.Tesis;
import com.centroinformacion.service.TesisService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/crudTesis")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TesisCrudController {
	
	@Autowired
	private TesisService service;
	
	
	@GetMapping("/listaTesisporTitulo/{titulo}")
	@ResponseBody
	public ResponseEntity<List<Tesis>> listaTesisPorTituloLike(@PathVariable("titulo") String titulo){
		List<Tesis> listaTesis = null;
		try {
			if(titulo.equals("todos")) {
				listaTesis= service.listaTesisPorTituloLike("%");
			}else {
				listaTesis = service.listaTesisPorTituloLike("%" + titulo + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(listaTesis);
		
	}
	
	@PostMapping("/registraTesis")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarTesis(@RequestBody Tesis obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
			obj.setEstado(AppSettings.ACTIVO);
				
			Tesis objSalida = service.registrarTesis(obj);
			
			if(objSalida == null) {
				salida.put("mensaje", "Error en el registro");
			}else {
				salida.put("mensaje", "Tesis registrado con ID=>" + objSalida.getIdTesis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaTesis")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaTesis(@RequestBody Tesis obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
		
			Tesis objSalida = service.actualizaTesis(obj);
			
			if(objSalida == null) {
				salida.put("mensaje", "Error en la actualización");
			}else {
				salida.put("mensaje", "Se actualizó la Tesis con ID=>" + objSalida.getIdTesis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaTesis/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaTesis(@PathVariable("id")int idTesis){
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaTesis(idTesis);
			salida.put("mensaje","Tesis eliminada correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en la eliminación");
		}
		return ResponseEntity.ok(salida);
	}
	

}
