package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
	
	@Query("select e from Editorial e where e.razonSocial like?1")
	public List<Editorial> listaPorRazonLike(String razon);

}
