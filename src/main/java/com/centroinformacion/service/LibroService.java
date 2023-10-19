package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Libro;



public interface LibroService {

    public abstract Libro insertaLibro(Libro libro);
    public abstract Libro actualiza(Libro libro);
    public abstract List<Libro> listaLibro();

}
