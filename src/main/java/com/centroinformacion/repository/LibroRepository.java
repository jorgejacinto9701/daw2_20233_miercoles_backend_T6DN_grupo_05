package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Libro;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    @Query("select x from Libro x where x.titulo like ?1")
    public List<Libro> listaPorNombreLike(String titulo);

}
