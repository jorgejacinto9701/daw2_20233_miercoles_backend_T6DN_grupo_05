package com.centroinformacion.repository;

import com.centroinformacion.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
