package com.centroinformacion.service;

import com.centroinformacion.entity.Autor;

import java.util.List;

public interface AutorService {
    public List<Autor> listAll();
    public Autor registrar(Autor a);
    public Autor actualizar(Autor a);
    public List<Autor> buscarNombreLike(String nombre);
    public void eliminar(int id);
    public Autor buscarPorId(int id);
}
