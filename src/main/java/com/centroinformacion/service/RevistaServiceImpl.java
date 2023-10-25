package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.repository.RevistaRepository;

@Service
public class RevistaServiceImpl implements RevistaService {

	@Autowired
	private RevistaRepository repository;
	
	@Override
	public Revista registrar(Revista r) {
		return repository.save(r);
	}

	@Override
	public List<Revista> listarTodo() {
		return repository.findAll();
	}

	@Override
	public Revista actualizar(Revista r) {
		return repository.save(r);
	}

	@Override
	public void eliminar(int idRevista) {
		repository.deleteById(idRevista);
	}

	@Override
	public List<Revista> listarPorNombreLike(String nombre) {
		return repository.listarPorNombreLike(nombre);
	}
	
}
