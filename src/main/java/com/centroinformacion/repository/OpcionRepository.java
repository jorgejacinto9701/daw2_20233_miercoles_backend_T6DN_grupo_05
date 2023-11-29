package com.centroinformacion.repository;

import com.centroinformacion.entity.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpcionRepository extends JpaRepository<Opcion, Integer> {

}
