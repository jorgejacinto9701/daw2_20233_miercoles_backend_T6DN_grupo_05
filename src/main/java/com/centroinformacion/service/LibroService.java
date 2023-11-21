package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Libro;
import org.springframework.data.repository.query.Param;


public interface LibroService {

    public abstract Libro insertaLibro(Libro libro);
    public abstract Libro actualiza(Libro libro);
    public abstract List<Libro> listaLibro();

    public abstract List<Libro> listaLibroPorNombreLike(String nombre);
    public abstract  void eliminaLibro (int idLibro);


    public List<Libro> buscarLibros(String titulo, String anio, String serie, String estado);
}
