package com.centroinformacion.service;

import java.util.List;
import com.centroinformacion.entity.Proveedor;

public interface ProveedorService {
	
	public abstract Proveedor insertaActualizaProveedor(Proveedor obj);
	public abstract Proveedor actualizaProveedor(Proveedor obj);
	public abstract List<Proveedor> listaProveedor();
	public abstract List<Proveedor> listaPorRazonLike(String razonsocial);
	public abstract void eliminaProveedor(int idProveedor);
	public List<Proveedor> listaConsultaDinamica(String razonsocial, String ruc, int estado, int idPais, int idTipoProveedor);

}
