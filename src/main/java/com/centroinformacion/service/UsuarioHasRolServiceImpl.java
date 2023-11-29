package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.entity.UsuarioHasRol;
import com.centroinformacion.entity.UsuarioHasRolPK;
import com.centroinformacion.repository.RolRepository;
import com.centroinformacion.repository.UsuarioHasRolRepository;

@Service
public class UsuarioHasRolServiceImpl implements UsuarioHasRolService {
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired UsuarioHasRolRepository usuRolRepository;

	@Override
	public List<UsuarioHasRol> listaTodos() {
		return usuRolRepository.findAll();
	}

	@Override
	public List<Rol> listarRoles() {
		return rolRepository.findAll();
	}

	@Override
	public UsuarioHasRol registrarRolAUsuario(UsuarioHasRol usuR) {
		return usuRolRepository.save(usuR);
	}

	@Override
	public void eliminarRolAUsuario(int idRol, int idUsuario) {

		UsuarioHasRolPK id = new UsuarioHasRolPK();
		id.setIdRol(idRol);
		id.setIdUsuario(idUsuario);
	    usuRolRepository.deleteById(id);
	}

}
