package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Tesis;


public interface TesisRepository extends JpaRepository<Tesis, Integer>{
	@Query("select t from Tesis t where t.titulo like?1")
	public List<Tesis> listaPorTituloLike(String titulo);
	
	
	@Query("select x from Tesis x where "
			+ "(x.titulo like ?1) and "
			+ "(x.tema like ?2) and "
			+ "(x.estado = ?3) and "
			+ "(?4 = -1 or x.alumno.idAlumno = ?4)")
	public List<Tesis> listaConsultaDinamica(String titulo, String tema, int estado, int idAlumno);



 
}
