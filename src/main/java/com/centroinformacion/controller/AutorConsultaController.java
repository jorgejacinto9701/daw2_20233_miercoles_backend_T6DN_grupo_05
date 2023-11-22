package com.centroinformacion.controller;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.service.AutorService;
import com.centroinformacion.service.AutorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/url/autorConsulta")
public class AutorConsultaController {

    @Autowired
    private AutorServiceImp serAutor;

    @GetMapping("/filtrarAutor")
    public ResponseEntity<?> filtrarAutor(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "apellido", required = false) String apellido,
            @RequestParam(name = "pais", required = false) String pais,
            @RequestParam(name = "estado", required = false, defaultValue = "1") String estado
    ){
        List<Autor> salida = serAutor.buscarAutores(nombre, apellido,pais,estado);

        return ResponseEntity.ok(salida);
    }

}
