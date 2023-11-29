package com.centroinformacion.service;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.RolHasOpcion;

import java.util.List;

public interface RolHasOpcionService {
    public abstract List<RolHasOpcion> listaTodo();
    public abstract List<Opcion> listarOpciones();
    public abstract List<Rol> listarRoles();
    public abstract RolHasOpcion registrarRolHasOpcion(RolHasOpcion rolO);
    public abstract List<RolHasOpcion> listarRolHasOpcionPorIdRol(int idRol);
    public abstract void eliminarRolHasOpcion(int idRol, int idOpcion);
}
