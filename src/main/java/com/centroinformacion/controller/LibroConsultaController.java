package com.centroinformacion.controller;


import com.centroinformacion.entity.Libro;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url/consultaLibro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroConsultaController {


    @Autowired
    private LibroService libroService;


    @GetMapping("/consultaLibroPorParametros")
    @ResponseBody
    public List<Libro> buscarLibros(
            @RequestParam(name = "titulo", required = false) String titulo,
            @RequestParam(name = "anio", required = false) String anio,
            @RequestParam(name = "serie", required = false) String serie,
            @RequestParam(name = "estado", required = false, defaultValue = "1") String estado) {

        List<Libro> listaLibro = libroService.buscarLibros("%" + titulo + "%", anio, "%" + serie + "%", estado);

        return listaLibro;
    }


}
