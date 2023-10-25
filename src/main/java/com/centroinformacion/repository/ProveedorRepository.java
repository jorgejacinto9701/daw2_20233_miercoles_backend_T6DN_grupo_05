package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	@Query("select p from Proveedor p where p.razonsocial like?1")
	public List<Proveedor> listaPorRazonLike(String razonsocial);
}
