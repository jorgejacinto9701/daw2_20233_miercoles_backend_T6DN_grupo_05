package com.centroinformacion.repository;

import com.centroinformacion.entity.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatalogoRepository  extends JpaRepository<Catalogo, Integer> {


    @Query("SELECT c FROM Catalogo c WHERE c.idCatalogo = ?1 ORDER BY c.descripcion ASC")
    List<Catalogo> findByCatalogoIdOrderedByDescripcion(int idCatalogo);


}
