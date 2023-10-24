package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaTodos();
    public abstract Alumno registrarOActualizarAlumnos(Alumno a);
    public abstract void eliminar(Alumno obj);
    public abstract Alumno buscarPorId(int id);

}
