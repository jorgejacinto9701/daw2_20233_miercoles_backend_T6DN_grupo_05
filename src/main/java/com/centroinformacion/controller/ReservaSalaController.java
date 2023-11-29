package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.entity.ReservaSala;
import com.centroinformacion.entity.Sala;
import com.centroinformacion.service.ReservaSalaService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/reservaSala")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ReservaSalaController {

	@Autowired
	private ReservaSalaService service;
	
	@PostMapping("/reservar")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> reservar(@RequestBody ReservaSala reserva) {
		System.out.println("inicio " + reserva.getHoraInicio());
		System.out.println("fin " + reserva.getHoraFin());
		System.out.println("fecha " + reserva.getFechaReserva());
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "Error en la reserva.");
		
		try {
			reserva.setFechaRegistro(new Date());
			reserva.setEstado(AppSettings.ACTIVO);
			
			reserva = service.reservar(reserva);
			
			if (reserva != null) {
				response.put("mensaje", "Reserva N° " + reserva.getIdReservaSala() + " registrada exitosamente.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/listarAlumno")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listarAlumno() {
		List<Alumno> listaAlumno = service.listarAlumno();
		
		return ResponseEntity.ok(listaAlumno);
	}
	
	@GetMapping("/listarSala")
	@ResponseBody
	public ResponseEntity<List<Sala>> listarSala() {
		List<Sala> listaSala = service.listarSala();
		
		return ResponseEntity.ok(listaSala);
	}
}
