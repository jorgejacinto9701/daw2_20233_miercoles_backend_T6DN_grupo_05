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
}
