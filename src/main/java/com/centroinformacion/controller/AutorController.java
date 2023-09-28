package com.centroinformacion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.service.AutorServiceImp;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/autor")
public class AutorController {

    @Autowired
    private AutorServiceImp serAutor;

    @GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<?> lista(){
        List<Autor> salida = serAutor.listAll();
        return ResponseEntity.ok(salida);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> registrar(@RequestBody Autor a){
        Map<String, String> salida = new HashMap<>();

        a.setFechaActualizacion(new Date());
        a.setFechaRegistro(new Date());
        a.setEstado(AppSettings.ACTIVO);

        // Intenta convertir las cadenas de fecha en objetos Date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            a.setFechaActualizacion(dateFormat.parse(dateFormat.format(a.getFechaActualizacion())));
            a.setFechaRegistro(dateFormat.parse(dateFormat.format(a.getFechaRegistro())));
        } catch (ParseException e) {
            // Manejo de errores en caso de que la conversión falle
            salida.put("mensaje", "Error en el formato de fecha");
            return ResponseEntity.badRequest().body(salida);
        }

        Autor aut = serAutor.registrar(a);

        if(aut == null){
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Se registró el autor con el id => " + aut.getIdAutor());
        }

        return ResponseEntity.ok(salida);
    }



}
