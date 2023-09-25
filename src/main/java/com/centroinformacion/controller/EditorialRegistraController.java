package com.centroinformacion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.EditorialService;
import com.centroinformacion.service.UsuarioService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/editorial")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EditorialRegistraController {
	
	@Autowired
	private EditorialService servicioEditorial;
	
	
	@Autowired
	private UsuarioService servicioUsuario;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Editorial>> listarEditorial(){
		List<Editorial> lista = servicioEditorial.listaEditorial();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertar(@RequestBody Editorial obj){
		HashMap<String, Object> salida = new HashMap<>();
		
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		obj.setEstado(AppSettings.ACTIVO);
		
		 // Intenta convertir las cadenas de fecha en objetos Date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            obj.setFechaActualizacion(dateFormat.parse(dateFormat.format(obj.getFechaActualizacion())));
            obj.setFechaRegistro(dateFormat.parse(dateFormat.format(obj.getFechaRegistro())));
        } catch (ParseException e) {
            // Manejo de errores en caso de que la conversión falle
            salida.put("mensaje", "Error en el formato de fecha");
            return ResponseEntity.badRequest().body(salida);
        }
		
		System.out.println(obj.getUsuarioRegistro());
		
		Usuario usuario = servicioUsuario.findById(obj.getUsuarioRegistro().getIdUsuario());
		
		System.out.println(usuario);
		
		obj.setUsuarioRegistro(usuario);
		obj.setUsuarioActualiza(usuario);

		Editorial objSalida = servicioEditorial.insertaEditorial(obj);
		
		
		if(objSalida==null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Se registró la Editorial con el ID => " + objSalida.getIdEditorial());
		}
		
		return ResponseEntity.ok(obj);
	}
	

}
