package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {
	@Autowired
    private AlumnoRepository repository;

    @Override
    public List<Alumno> listaTodos() {
        return repository.findByOrderByApellidosAsc();
    }

    @Override
    public Alumno registrarOActualizarAlumnos(Alumno a) {
         return    repository.save(a);
    }

    @Override
    public void eliminar(Alumno obj) {
        repository.delete(obj);
    }

    @Override
    public Alumno buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

	
}
