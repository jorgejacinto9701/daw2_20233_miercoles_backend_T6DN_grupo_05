package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Tesis;

public interface TesisRepository extends JpaRepository<Tesis, Integer>{
	@Query("select t from Tesis t where t.titulo like?1")
	public List<Tesis> listaPorTituloLike(String titulo);
}
