package com.centroinformacion.repository;

import com.centroinformacion.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    @Query("select x from Autor x where x.nombres like ?1")
    public List<Autor> listaPorNombreLike(String nombre);
}
