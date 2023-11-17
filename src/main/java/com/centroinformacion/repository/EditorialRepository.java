package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
	
	@Query("select e from Editorial e where e.razonSocial like?1")
	public List<Editorial> listaPorRazonLike(String razon);
	
	@Query("SELECT e from Editorial e where (e.razonSocial like?1) and"
			+ "(?2 = '' or e.direccion =?2) and "
			+ "(?3 = '' or e.ruc =?3) and "
			+ "(e.estado =?4)" )
	public List<Editorial> listaConsultaDinamica(String razonSocial, String direccion, String ruc, int estado);
	
	
	@Query("SELECT e FROM Editorial e WHERE " +
	        "(LOWER(e.razonSocial) LIKE LOWER(CONCAT('%', COALESCE(?1, ''), '%'))) AND " +
	        "(LOWER(e.direccion) LIKE LOWER(COALESCE(?2, ''))) AND " +
	        "(LOWER(e.ruc) LIKE LOWER(COALESCE(?3, ''))) AND " +
	        "(e.estado = ?4)")
	public List<Editorial> listaConsultaDinamicaMejorada(String razonSocial, String direccion, String ruc, int estado);

}
