package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.entity.ReservaSala;
import com.centroinformacion.entity.Sala;

public interface ReservaSalaService {

	public ReservaSala reservar(ReservaSala reserva);
	
	public List<Alumno> listarAlumno();
	
	public List<Sala> listarSala();
}
