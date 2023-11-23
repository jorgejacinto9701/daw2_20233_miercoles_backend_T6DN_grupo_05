package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
	@Query("select x from Autor x where x.nombres like ?1")
	public List<Autor> listaPorNombreLike(String nombre);

	@Query("SELECT a FROM Autor a " + "WHERE LOWER(a.nombres) LIKE LOWER(CONCAT('%', :nombre, '%')) "
			+ "AND LOWER(a.apellidos) LIKE LOWER(CONCAT('%', :apellido, '%')) "
			+ "AND CAST(a.pais.idPais AS string) LIKE :pais " + "AND CAST(a.estado AS string) LIKE :estado")
	List<Autor> buscarAutor(@Param("nombre") String nombre, @Param("apellido") String apellido,
			@Param("pais") String pais, @Param("estado") String estado);
}
