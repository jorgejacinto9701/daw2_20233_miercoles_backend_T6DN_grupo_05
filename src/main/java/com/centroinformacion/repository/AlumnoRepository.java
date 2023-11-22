package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	public abstract List<Alumno> findByOrderByApellidosAsc();
	
	@Query("SELECT a FROM Alumno a WHERE (?1 = '' OR a.nombres LIKE %?1%) AND (?2 = '' OR a.dni = ?2) AND (?3 = '' OR a.correo LIKE %?3%) AND (?4 = 0 OR a.pais.idPais = ?4)")
    public abstract List<Alumno> filtrarAlumnos(String nombre, String dni, String correo, int idPais);
	
	
}
