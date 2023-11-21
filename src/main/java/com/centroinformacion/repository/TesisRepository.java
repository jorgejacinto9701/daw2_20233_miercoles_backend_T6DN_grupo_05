package com.centroinformacion.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Tesis;


public interface TesisRepository extends JpaRepository<Tesis, Integer>{
	@Query("select t from Tesis t where t.titulo like?1")
	public List<Tesis> listaPorTituloLike(String titulo);
	
	
	@Query("SELECT x FROM Tesis x WHERE (x.titulo like?1) AND (x.tema like?2) and (x.estado = ?3 and ?4 = -1 or x.alumno.idAlumno = ?4)")
	public List<Tesis> listaConsultaDinamicatesis
				( String titulo ,String tema , int estado, int alumno);



}
