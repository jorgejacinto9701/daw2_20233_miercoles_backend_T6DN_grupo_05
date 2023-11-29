package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.UsuarioHasRol;

public interface UsuarioHasRolService {
	public abstract List<UsuarioHasRol> listaTodos();
	public abstract List<Rol> listarRoles();
	public abstract UsuarioHasRol registrarRolAUsuario(UsuarioHasRol usuR);
	public abstract void eliminarRolAUsuario(int idRol, int idUsuario);

}
