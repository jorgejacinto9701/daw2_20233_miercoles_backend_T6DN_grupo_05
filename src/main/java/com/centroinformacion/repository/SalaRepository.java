package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{
	
	
	@Query("select x from Sala x where x.numero like ?1")
	public List<Sala> listaPorNumeroLike(String numero);
}
