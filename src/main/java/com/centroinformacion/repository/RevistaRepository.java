package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Integer> {
	
	@Query("SELECT r FROM Revista r WHERE r.nombre like ?1")
	public List<Revista> listarPorNombreLike(String nombre);
	
	@Query("SELECT r FROM Revista r WHERE (r.nombre LIKE ?1) AND "
			+ "(r.frecuencia LIKE ?2) AND "
			+ "(?3 = -1 OR r.tipoRevista.idDataCatalogo = ?3) AND "
			+ "(r.estado = ?4) AND "
			+ "(?5 = -1 OR r.pais.idPais = ?5)")
	public List<Revista> listaConsultaDinamica(String nombre, String frecuencia, int idTipoRevista,
			int estado, int idPais);
}
