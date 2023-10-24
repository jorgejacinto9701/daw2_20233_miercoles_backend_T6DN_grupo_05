package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Sala;

public interface SalaService {

	public abstract Sala insertaActualizaSala(Sala obj);
	public abstract List<Sala> listaSala();
	public abstract List<Sala> listaSalaPorNumeroLike(String numero);
	
	public abstract void eliminaSala(int idSala);
}
