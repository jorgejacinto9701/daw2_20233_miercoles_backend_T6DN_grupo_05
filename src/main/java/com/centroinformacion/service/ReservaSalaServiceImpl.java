package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.entity.ReservaSala;
import com.centroinformacion.entity.Sala;
import com.centroinformacion.repository.AlumnoRepository;
import com.centroinformacion.repository.ReservaSalaRepository;
import com.centroinformacion.repository.SalaRepository;

@Service
public class ReservaSalaServiceImpl implements ReservaSalaService {

	@Autowired
	private ReservaSalaRepository reservaRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Override
	public ReservaSala reservar(ReservaSala reserva) {
		return reservaRepository.save(reserva);
	}

	@Override
	public List<Alumno> listarAlumno() {
		return alumnoRepository.findAll().stream().filter(a -> a.getEstado() == 1).toList();
	}

	@Override
	public List<Sala> listarSala() {
		return salaRepository.findAll().stream().filter(s -> s.getEstado() == 1).toList();
	}

}
