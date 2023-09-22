package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Sala;
import com.centroinformacion.repository.SalaRepository;

@Service
public class SalaServiceImp implements SalaService {

	@Autowired	
	private SalaRepository repository;

	@Override
	public Sala insertaActualizaSala(Sala obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<Sala> listaSala() {
		return repository.findAll();
	}
	
}
