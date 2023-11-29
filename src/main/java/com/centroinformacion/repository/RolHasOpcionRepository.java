package com.centroinformacion.repository;

import com.centroinformacion.entity.RolHasOpcion;
import com.centroinformacion.entity.RolHasOpcionPK;
import com.centroinformacion.entity.UsuarioHasRol;
import com.centroinformacion.entity.UsuarioHasRolPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolHasOpcionRepository extends JpaRepository<RolHasOpcion, RolHasOpcionPK> {

    public abstract List<RolHasOpcion> findRolHasOpcionByRol_IdRol(int idRol);
}
