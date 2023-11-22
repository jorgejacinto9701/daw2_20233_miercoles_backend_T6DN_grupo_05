package com.centroinformacion.service;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImp implements AutorService{

    @Autowired
    private AutorRepository serAutor;

    @Override
    public List<Autor> listAll() {
        return serAutor.findAll();
    }

    @Override
    public Autor registrar(Autor a) {
        return serAutor.save(a);
    }

    @Override
    public Autor actualizar(Autor a) {
        return serAutor.save(a);
    }

    @Override
    public List<Autor> buscarNombreLike(String nombre) {
        return serAutor.listaPorNombreLike(nombre) ;
    }

    @Override
    public void eliminar(int id) {
        Autor a = new Autor();
        a= serAutor.findById(id).orElse(null);
        if(a!=null){
            serAutor.delete(a);
        }
    }

    @Override
    public Autor buscarPorId(int id) {
        return serAutor.findById(id).orElse(null);
    }

    @Override
    public List<Autor> buscarAutores(String nombre, String apellido, String pais, String estado) {
        return serAutor.buscarAutor(nombre, apellido, pais, estado);
    }
}
