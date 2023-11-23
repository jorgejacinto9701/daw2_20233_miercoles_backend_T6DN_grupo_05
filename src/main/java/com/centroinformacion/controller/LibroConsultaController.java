package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Libro;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/consultaLibro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroConsultaController {

	@Autowired
	private LibroService libroService;

	@GetMapping("/consultaLibroPorParametros")
	@ResponseBody
	public List<Libro> buscarLibros(@RequestParam(name = "titulo", required = false) String titulo,
			@RequestParam(name = "anio", required = false) String anio,
			@RequestParam(name = "serie", required = false) String serie,
			@RequestParam(name = "estado", required = false, defaultValue = "1") String estado) {

		List<Libro> listaLibro = libroService.buscarLibros("%" + titulo + "%", anio, "%" + serie + "%", estado);

		return listaLibro;
	}

}
