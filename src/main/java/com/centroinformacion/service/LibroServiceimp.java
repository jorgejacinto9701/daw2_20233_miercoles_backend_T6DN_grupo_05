package com.centroinformacion.service;


import com.centroinformacion.entity.Libro;
import com.centroinformacion.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceimp  implements  LibroService{

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro insertaLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualiza(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> listaLibro() {
        return libroRepository.findAll();
    }
    @Override
    public List<Libro> listaLibroPorNombreLike(String nombre) {
        return libroRepository.listaPorNombreLike(nombre);
    }

    @Override
    public void eliminaLibro(int idLibro) {
            libroRepository.deleteById(idLibro);
    }
}
