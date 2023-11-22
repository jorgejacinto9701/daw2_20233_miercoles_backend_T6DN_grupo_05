package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp implements ProveedorService {
	
	@Autowired	
	private ProveedorRepository repository;

	@Override
	public Proveedor insertaActualizaProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public List<Proveedor> listaProveedor() {
		return repository.findAll();
	}
	
	@Override
	public Proveedor actualizaProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaProveedor(int idProveedor) {
		repository.deleteById(idProveedor);;
	}

	@Override
	public List<Proveedor> listaPorRazonLike(String razonsocial) {
		return repository.listaPorRazonLike(razonsocial);
	}

	@Override
	public List<Proveedor> listaConsultaDinamica(String razonsocial, String ruc, int estado, int idPais,
			int idTipoProveedor) {
		return repository.listaConsultaDinamica(razonsocial, ruc, estado, idPais, idTipoProveedor);
	}
	
}
