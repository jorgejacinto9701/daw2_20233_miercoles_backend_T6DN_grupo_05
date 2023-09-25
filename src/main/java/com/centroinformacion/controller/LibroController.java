package com.centroinformacion.controller;

import com.centroinformacion.entity.DataCatalogo;
import com.centroinformacion.entity.Libro;
import com.centroinformacion.service.LibroService;
import com.centroinformacion.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/url/libro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Libro>> listaLibro() {
        List<Libro> lista = libroService.listaLibro();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> inserta(@RequestBody Libro libro) {
        HashMap<String, Object> salida = new HashMap<>();


        libro.setFechaActualizacion(new Date());
        libro.setFechaRegistro(new Date());
        libro.setEstado(AppSettings.ACTIVO);


        DataCatalogo tipoLibro = new DataCatalogo();
        tipoLibro.setIdDataCatalogo(15);
        libro.setTipoLibro(tipoLibro);


        DataCatalogo categoria = new DataCatalogo();
        categoria.setIdDataCatalogo(1);
        libro.setCategoriaLibro(categoria);

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
    }


}
