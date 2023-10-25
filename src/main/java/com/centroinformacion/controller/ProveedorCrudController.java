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

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.service.ProveedorService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/CrudProveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorCrudController {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/listaProveedorPorRazon/{razonsocial}")
	@ResponseBody
	public ResponseEntity<List<Proveedor>> listaPorRazonLike(@PathVariable("razonsocial") String razonsocial){
		
		List<Proveedor> listaProveedor = null;
		try {
			if(razonsocial.equals("todos")) {
				listaProveedor= proveedorService.listaPorRazonLike("%");
			}else {
				listaProveedor = proveedorService.listaPorRazonLike("%"+ razonsocial + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(listaProveedor);
	}
	
	@PostMapping("/registraProveedor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProveedor(@RequestBody Proveedor obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
			obj.setEstado(AppSettings.ACTIVO);
				
			Proveedor objSalida = proveedorService.insertaActualizaProveedor(obj);
			
			if(objSalida == null) {
				salida.put("mensaje", "Error en el registro");
			}else {
				salida.put("mensaje", "Proveedor registrado con ID=>" + objSalida.getIdProveedor());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	@PutMapping("/actualizaProveedor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProveedor(@RequestBody Proveedor obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
		
			Proveedor objSalida = proveedorService.actualizaProveedor(obj);
			
			if(objSalida == null) {
				salida.put("mensaje", "Error en la actualización");
			}else {
				salida.put("mensaje", "Se actualizó el proveedor con ID=>" + objSalida.getIdProveedor());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaProveedor/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProveedor(@PathVariable("id")int idProveedor){
		Map<String, Object> salida = new HashMap<>();
		try {
			proveedorService.eliminaProveedor(idProveedor);
			salida.put("mensaje","Proveedor eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en la eliminación");
		}
		return ResponseEntity.ok(salida);
	}
	
}
