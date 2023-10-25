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

import com.centroinformacion.entity.Sala;
import com.centroinformacion.service.SalaService;
import com.centroinformacion.util.AppSettings;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/url/crudSala")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SalaCrudController {

	@Autowired
	private SalaService service;
	
	@GetMapping("/listaSalaPorNumeroLike/{numero}")
	@ResponseBody
	public ResponseEntity<List<Sala>> listaSalaPorNumeroLike(@PathVariable("numero") String numero) {
		List<Sala> listanumero  = null;
		try {
			if (numero.equals("todos")) {
				listanumero = service.listaSalaPorNumeroLike("%");
			}else {
				listanumero = service.listaSalaPorNumeroLike("%" + numero + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(listanumero);
	}
	
	@PostMapping("/insertaSala")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaSala(@RequestBody Sala obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdSala(0);
			obj.setFechaRegistro(new Date());
			obj.setFechaActualizacion(new Date());
			obj.setEstado(AppSettings.ACTIVO);
			Sala objSalida =  service.insertaActualizaSala(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaSala")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaSala(@RequestBody Sala obj) {
		Map<String, Object> salida = new HashMap<>();
		try {

			obj.setFechaActualizacion(new Date());
			Sala objSalida =  service.insertaActualizaSala(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/eliminaSala/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaSala(@PathVariable("id") int idSala) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaSala(idSala);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
