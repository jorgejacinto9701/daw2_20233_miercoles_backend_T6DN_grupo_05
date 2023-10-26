package com.centroinformacion.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Libro;
import com.centroinformacion.service.LibroService;

@RestController
@RequestMapping("/url/libro")
public class LibroCrudController {

@Autowired
private LibroService libroService;


   /* @PostMapping()
    @ResponseBody
    public ResponseEntity<?> inserta(@RequestBody Libro libro) {
        HashMap<String, Object> salida = new HashMap<>();


        libro.setFechaActualizacion(new Date());
        libro.setFechaRegistro(new Date());
        libro.setEstado(AppSettings.ACTIVO);

        DataCatalogo estadoPrestamo = new DataCatalogo();
        estadoPrestamo.setIdDataCatalogo(27);
        libro.setEstadoPrestamo(estadoPrestamo);

        Libro objSalida = libroService.insertaLibro(libro);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Se registró el libro con el ID ==> " + objSalida.getIdLibro());
        }
        return ResponseEntity.ok(salida);
    }*/

	@PutMapping("/actualizaLibro")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizalibro(@RequestBody Libro libro) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Libro objSalida =  libroService.actualiza(libro);
            libro.setFechaActualizacion(new Date());
			if (objSalida == null) {
				salida.put("mensaje", "error al registro");
			} else {
				salida.put("mensaje","Actualizado con exito");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al actualizar");
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listaLibroPorNombreLike/{titulo}")
	@ResponseBody
	public ResponseEntity<List<Libro>> listaDocentePorNombreLike(@PathVariable("titulo") String titulo) {
		List<Libro> lista  = null;
		try {
			if (titulo.equals("todos")) {
				lista = libroService.listaLibroPorNombreLike("%");
			}else {
				lista = libroService.listaLibroPorNombreLike("%" + titulo + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listaLibro/")
	@ResponseBody
	public ResponseEntity<List<Libro>> listaLibro() {
		List<Libro> lista = libroService.listaLibro();
		return ResponseEntity.ok(lista);
	}



	@DeleteMapping("/eliminaLibro/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminalibro(@PathVariable("id") int idLibro) {
		Map<String, Object> salida = new HashMap<>();
		try {
			libroService.eliminaLibro(idLibro);
			salida.put("mensaje", "se elimino correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "error al eliminar");
		}
		return ResponseEntity.ok(salida);
	}

}
