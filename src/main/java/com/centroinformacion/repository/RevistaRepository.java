package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Integer> {
	
}
