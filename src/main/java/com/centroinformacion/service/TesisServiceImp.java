package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Tesis;
import com.centroinformacion.repository.TesisRepository;

@Service
public class TesisServiceImp implements TesisService{

	@Autowired
	private TesisRepository repository;

	@Override
	public List<Tesis> listarTesis() {
		return repository.findAll();
	}

	@Override
	public Tesis registrarTesis(Tesis Tesis) {
		return repository.save(Tesis);
		
	}
}
