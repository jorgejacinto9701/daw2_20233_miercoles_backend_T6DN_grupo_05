package com.centroinformacion.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Tesis;

public interface TesisService {

	public abstract Tesis registrarTesis(Tesis obj);
	public abstract List<Tesis> listarTesis();
	
	public abstract Tesis actualizaTesis(Tesis obj);
	public abstract void eliminaTesis(int idTesis);
	public abstract List<Tesis> listaTesisPorTituloLike(String titulo);
	
	public List<Tesis> listaConsultaDinamicatesis
	( String titulo ,String tema , int estado ,int alumno);




	
}
