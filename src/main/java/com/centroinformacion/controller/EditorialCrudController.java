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

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.service.EditorialService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/crudEditorial")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EditorialCrudController {
	
	@Autowired
	private EditorialService service;
	

	@GetMapping("/listaEditorialPorRazon/{razon}")
	@ResponseBody
	public ResponseEntity<List<Editorial>> listaEditorialPorRazonLike(@PathVariable("razon") String razon){
		List<Editorial> listaEditorial = null;
		try {
			if(razon.equals("todos")) {
				listaEditorial = service.listaEditorialPorRazonLike("%");
			}else {
				listaEditorial = service.listaEditorialPorRazonLike("%" + razon + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(listaEditorial);
		
	}
	
	@PostMapping("/registraEditorial")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarEditorial(@RequestBody Editorial obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			//Seteando valores por defecto
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
			obj.setEstado(AppSettings.ACTIVO);
				
			Editorial objSalida = service.insertaEditorial(obj);
			
			if(objSalida == null) {
				salida.put("mensaje", "Error en el registro");
			}else {
				salida.put("mensaje", "Se registro el editorial con ID=>" + objSalida.getIdEditorial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaEditorial")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEditorial(@RequestBody Editorial obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
			//obj.setEstado(AppSettings.ACTIVO);
			Editorial objSalida = service.actualizaEditorial(obj);
			
			if(objSalida == null) {
				salida.put("mensaje", "Error en la actualización");
			}else {
				salida.put("mensaje", "Se actualizó el editorial con ID=>" + objSalida.getIdEditorial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaEditorial/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaDocente(@PathVariable("id")int idEditorial){
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaEditorial(idEditorial);
			salida.put("mensaje","Editorial eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en la eliminación");
		}
		return ResponseEntity.ok(salida);
	}
	

}
