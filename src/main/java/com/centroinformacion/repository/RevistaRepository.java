package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Integer> {
	
	@Query("SELECT r FROM Revista r WHERE r.nombre like ?1")
	public List<Revista> listarPorNombreLike(String nombre);
	
}
