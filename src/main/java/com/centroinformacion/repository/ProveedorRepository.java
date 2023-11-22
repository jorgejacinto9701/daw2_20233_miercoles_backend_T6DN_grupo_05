package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	
	@Query("select p from Proveedor p where p.razonsocial like?1")
	public List<Proveedor> listaPorRazonLike(String razonsocial);
	
	@Query("select p from Proveedor p where (p.razonsocial like ?1) and "
			+ "(p.ruc like ?2) and "
			+ "(p.estado = ?3) and "
			+ "(?4 = -1 or p.pais.idPais = ?4) and "
			+ "(?5 = -1 or p.tipoProveedor.idDataCatalogo = ?5)")
	public List<Proveedor> listaConsultaDinamica(String razonsocial, String ruc, int estado, int idPais, int idTipoProveedor);
	
}
