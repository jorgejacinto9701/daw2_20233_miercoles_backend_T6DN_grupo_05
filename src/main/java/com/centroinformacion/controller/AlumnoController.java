package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.service.AlumnoService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/alumno")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaeEjemplo() {
		List<Alumno> lista = alumnoService.listaTodos();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{idAlumno}")
	@ResponseBody
	public ResponseEntity<Alumno> buscaPorId(@RequestParam int idAlumno) {
		Alumno objSalida = alumnoService.buscarPorId(idAlumno);
		return ResponseEntity.ok(objSalida);

	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Alumno alumno) {
		HashMap<String, Object> salida = new HashMap<>();

		if (alumnoService.listaTodos().stream().anyMatch(p -> p.getDni().equals(alumno.getDni()))) {
			salida.put("mensaje", "El DNI ya se encuentra registrado, ingrese otro DNI");
			salida.put("status", "error");
		} else if (alumnoService.listaTodos().stream().anyMatch(p -> p.getCorreo().equals(alumno.getCorreo()))) {
			salida.put("mensaje", "El correo ya se encuentra registrado, no se pudo registrar");
			salida.put("status", "error");

		} else {
			alumno.setFechaActualizacion(new Date());
			alumno.setFechaRegistro(new Date());
			alumno.setEstado(AppSettings.ACTIVO);
			Alumno objSalida = alumnoService.registrarOActualizarAlumnos(alumno);
			salida.put("mensaje", "Se registró el alumno correctamente");
			salida.put("status", "ok");
			salida.put("id", objSalida.getIdAlumno());
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<?> actualiza(@RequestBody Alumno alumno) {
		HashMap<String, Object> salida = new HashMap<>();
		// VALIDACIONES BACKEND
		if (alumnoService.listaTodos().stream().anyMatch(p -> p.getIdAlumno() == alumno.getIdAlumno()) == false) {
			salida.put("mensaje", "El ID no existe, no se pudo actualizar");
			salida.put("status", "error");
			return ResponseEntity.ok(salida);

		}

		if (alumnoService.listaTodos().stream()
				.anyMatch(p -> p.getDni().equals(alumno.getDni()) && p.getIdAlumno() != alumno.getIdAlumno())) {
			salida.put("mensaje", "El DNI ya se encuentra registrado, no se pudo actualizar");
			salida.put("status", "error");
			return ResponseEntity.ok(salida);

		}

		if (alumnoService.listaTodos().stream()
				.anyMatch(p -> p.getCorreo().equals(alumno.getCorreo()) && p.getIdAlumno() != alumno.getIdAlumno())) {
			salida.put("mensaje", "El correo ya se encuentra registrado, no se pudo actualizar");
			salida.put("status", "error");
			return ResponseEntity.ok(salida);

		}

		alumno.setFechaActualizacion(new Date());
		Alumno objSalida = alumnoService.registrarOActualizarAlumnos(alumno);

		salida.put("mensaje", "Se actualizó el alumno correctamente");
		salida.put("status", "ok");
		salida.put("id", objSalida.getIdAlumno());

		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/{idAlumno}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idAlumno) {
		HashMap<String, Object> salida = new HashMap<>();
		try {
			Alumno objSalida = alumnoService.buscarPorId(idAlumno);
			alumnoService.eliminar(objSalida);
			salida.put("mensaje", "Se elimino el alumno correctamente");
			salida.put("status", "ok");
		} catch (Exception e) {
			salida.put("mensaje", e.getMessage());
			salida.put("status", "error");
		}
		return ResponseEntity.ok(salida);
	}

}
