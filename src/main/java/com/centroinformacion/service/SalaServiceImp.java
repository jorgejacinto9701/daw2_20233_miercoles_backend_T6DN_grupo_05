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
	
	@Override
	public void eliminaSala(int idSala) {
		repository.deleteById(idSala);
	}
	
	@Override
	public List<Sala> listaSalaPorNumeroLike(String numero) {
		return repository.listaPorNumeroLike(numero);
	}
	
	
	@Override
	public List<Sala> listaConsultaDinamica(String numero, int piso, int estado, int idTipoSala) {
		return repository.listaConsultaDinamica(numero, piso, estado, idTipoSala);
	}

}
