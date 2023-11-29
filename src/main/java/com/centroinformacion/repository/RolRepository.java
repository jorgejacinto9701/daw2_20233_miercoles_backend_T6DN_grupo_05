package com.centroinformacion.repository;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Integer> {


}
