package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.repository.EditorialRepository;

@Service
public class EditorialServiceImp implements EditorialService {

	@Autowired
	private EditorialRepository repositorio;
	
	
	@Override
	public Editorial insertaEditorial(Editorial obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Editorial> listaEditorial() {
		return repositorio.findAll();
	}

}
