package com.centroinformacion.service;
import java.util.List;

import com.centroinformacion.entity.Proveedor;
public interface ProveedorService {
	
	public abstract Proveedor insertaActualizaProveedor(Proveedor obj);
	public abstract List<Proveedor> listaProveedor();
	public abstract Proveedor actualizaProveedor(Proveedor obj);
	public abstract void eliminaProveedor(int idProveedor);
	public abstract List<Proveedor> listaPorRazonLike(String razonsocial);

}
