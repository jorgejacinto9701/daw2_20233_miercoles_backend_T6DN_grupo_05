package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;

public interface UsuarioService {

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
	
	public abstract List<Usuario> listarUsuarios();
	public abstract Usuario findById(int id);

}
