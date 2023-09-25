package com.centroinformacion.service;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.entity.Ejemplo;
import com.centroinformacion.entity.Libro;
import org.springframework.stereotype.Service;

import java.util.List;



public interface LibroService {

    public abstract Libro insertaLibro(Libro libro);
    public abstract Libro actualiza(Libro libro);
    public abstract List<Libro> listaLibro();

}
