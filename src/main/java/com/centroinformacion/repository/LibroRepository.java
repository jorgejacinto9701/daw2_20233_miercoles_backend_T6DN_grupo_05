package com.centroinformacion.repository;

import com.centroinformacion.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    @Query("select x from Libro x where x.titulo like ?1")
    public List<Libro> listaPorNombreLike(String titulo);


@Query("SELECT l FROM Libro l " +
        "WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')) " +
        "AND CAST(l.anio AS string) LIKE :anio " +
        "AND LOWER(l.serie) LIKE LOWER(CONCAT('%', :serie, '%')) " +
        "AND CAST(l.estado AS string) LIKE :estado")
List<Libro> buscarLibros(
        @Param("titulo") String titulo,
        @Param("anio") String anio,
        @Param("serie") String serie,
        @Param("estado") String estado);




}
