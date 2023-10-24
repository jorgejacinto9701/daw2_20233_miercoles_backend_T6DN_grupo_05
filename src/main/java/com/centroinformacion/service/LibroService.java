package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Libro;



public interface LibroService {

    public abstract Libro insertaLibro(Libro libro);
    public abstract Libro actualiza(Libro libro);
    public abstract List<Libro> listaLibro();

    public abstract List<Libro> listaLibroPorNombreLike(String nombre);
    public abstract  void eliminaLibro (int idLibro);
}
