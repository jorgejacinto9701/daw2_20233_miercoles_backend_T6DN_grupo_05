package com.centroinformacion.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.entity.UsuarioHasRol;
import com.centroinformacion.service.UsuarioHasRolService;
import com.centroinformacion.service.UsuarioService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/usuarioRol")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioHasRolService usuRolService;

	@ResponseBody
	@PostMapping("/registrarRolAUsuario")
	public HashMap<String, Object> registraRol(@RequestBody UsuarioHasRol obj) {
		HashMap<String, Object> mapSalida = new HashMap<String, Object>();

		// VALIDAR QUE NO SE REPITA EL ROL
		List<UsuarioHasRol> validaRoles = usuRolService.listaTodos();
		if (validaRoles.stream().anyMatch(u -> u.getUsuario().getIdUsuario() == obj.getUsuario().getIdUsuario()
				&& u.getRol().getIdRol() == obj.getRol().getIdRol())) {
			mapSalida.put("mensaje", "El usuario ya tiene asignado el rol " + obj.getRol().getNombre());
		} else {
			UsuarioHasRol salida = usuRolService.registrarRolAUsuario(obj);
			if (salida != null) {
				mapSalida.put("mensaje", "Se registró el rol al Usuario " + salida.getUsuario().getIdUsuario());
				mapSalida.put("data", salida);
			} else {
				mapSalida.put("mensaje", "Hubo un error al registrar");
			}
		}

		return mapSalida;
	}

	@DeleteMapping("/eliminar/{idRol}/{idUsuario}")
	public ResponseEntity<Map<String, String>> eliminarRolAUsuario(@PathVariable("idRol") int idRol,
			@PathVariable("idUsuario") int idUsuario) {
		HashMap<String, String> respuesta = new HashMap<>();
		usuRolService.eliminarRolAUsuario(idRol, idUsuario);
		respuesta.put("eliminar", "Rol del usuario eliminado");

		return ResponseEntity.ok(respuesta);

	}

	@GetMapping("/buscarRolDeUsuarios")
	@ResponseBody
	public ResponseEntity<List<UsuarioHasRol>> buscarRolUsuarios() {
		List<UsuarioHasRol> lista = usuRolService.listaTodos();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/buscarUsuarios")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		List<Usuario> lista = usuarioService.listarUsuarios();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/buscarRoles")
	@ResponseBody
	public ResponseEntity<List<Rol>> buscarRoles() {
		List<Rol> lista = usuRolService.listarRoles();
		return ResponseEntity.ok(lista);
	}

}
