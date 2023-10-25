package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Revista;

public interface RevistaService {
	
	public Revista registrar(Revista r);
	
	public List<Revista> listarTodo();
	
	public Revista actualizar(Revista r);
	
	public void eliminar(int idRevista);
	
	public List<Revista> listarPorNombreLike(String nombre);

}
