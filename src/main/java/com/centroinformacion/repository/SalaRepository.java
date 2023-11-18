package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

	@Query("select s from Sala s where s.numero like ?1 ")
	public List<Sala> listaPorNumeroLike(String numero);

	/*@Query("select x from Sala x where (x.numero like ?1) and (?2 = 0 or x.piso = ?2) and "
			+ "(?3 = '' or x.recursos like ?3) and (x.estado = ?4) and "
			+ "(?5 = -1 or x.tipoSala.idDataCatalogo = ?5)")
	public List<Sala> listaConsultaDinamica(String numero, int piso, String recursos, int estado, int idTipoSala);
*/
	
	@Query("select x from Sala x where (x.numero like ?1) and "
									+ "(?2 = 0 or x.piso = ?2) and "
									+ "(x.recursos like ?3) and "
									+ "(x.estado = ?4) and "
									+ "(?5 = -1 or x.tipoSala.idDataCatalogo = ?5) and"
									+ "(?6 = -1 or x.sede.idDataCatalogo = ?6)")
	public List<Sala> listaConsultaDinamica(String numero, int piso, String recursos, int estado, int idTipoSala,int idSede);

	
}
