package com.centroinformacion.service;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.RolHasOpcion;
import com.centroinformacion.entity.RolHasOpcionPK;
import com.centroinformacion.repository.OpcionRepository;
import com.centroinformacion.repository.RolHasOpcionRepository;
import com.centroinformacion.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolHasOpcionServiceImp implements RolHasOpcionService{

    @Autowired
    private OpcionRepository opcionRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolHasOpcionRepository rolHasOpcionRepository;

    @Override
    public List<RolHasOpcion> listaTodo() {
        return rolHasOpcionRepository.findAll();
    }

    @Override
    public List<Opcion> listarOpciones() {
        return opcionRepository.findAll();
    }

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Override
    public RolHasOpcion registrarRolHasOpcion(RolHasOpcion rolO) {
        return rolHasOpcionRepository.save(rolO);
    }

    @Override
    public List<RolHasOpcion> listarRolHasOpcionPorIdRol(int idRol) {
        return rolHasOpcionRepository.findRolHasOpcionByRol_IdRol(idRol);
    }

    @Override
    public void eliminarRolHasOpcion(int idRol, int idOpcion) {
        RolHasOpcionPK id = new RolHasOpcionPK();
        id.setIdRol(idRol);
        id.setIdOpcion(idOpcion);
        rolHasOpcionRepository.deleteById(id);
    }
}
