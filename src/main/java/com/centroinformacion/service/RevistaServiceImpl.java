package com.centroinformacion.service;

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
	
}
