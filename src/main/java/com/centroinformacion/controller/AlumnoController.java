package com.centroinformacion.controller;

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
    public ResponseEntity<List<Alumno>> listaeEjemplo(){
        List<Alumno> lista = alumnoService.listaTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> registra(@RequestBody Alumno alumno){
        HashMap<String, Object> salida = new HashMap<>();

        alumno.setFechaActualizacion(new Date());
        alumno.setFechaRegistro(new Date());
        alumno.setEstado(AppSettings.ACTIVO);

        Alumno objSalida = alumnoService.registrarAlumno(alumno);
        if (objSalida == null) {
            salida.put("mensaje","Error en el registro");
        }else {
            salida.put("mensaje","Se registró el alumno con el ID ==> " + objSalida.getIdAlumno());
        }
        return ResponseEntity.ok(salida);
    }

}