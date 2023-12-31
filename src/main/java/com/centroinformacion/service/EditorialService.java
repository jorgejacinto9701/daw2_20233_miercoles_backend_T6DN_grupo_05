package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Editorial;

public interface EditorialService {

	public abstract Editorial insertaEditorial(Editorial obj);
	public abstract List<Editorial> listaEditorial();
	public abstract Editorial actualizaEditorial(Editorial obj);
	public abstract void eliminaEditorial(int idEditorial);
	public abstract List<Editorial> listaEditorialPorRazonLike(String razon);
	public abstract List<Editorial> listaDinamica(String razonSocial, String direccion, String ruc, int estado);
}
