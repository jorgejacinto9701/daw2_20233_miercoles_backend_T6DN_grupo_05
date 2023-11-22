package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.service.ProveedorService;


@RestController
@RequestMapping("/url/consultaProveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorConsultaController {
	
	@Autowired
	private ProveedorService service;
	
	@GetMapping("/consultaProveedorPorParametros")
	@ResponseBody
	public List<Proveedor> listaConsultaProveedor(
			@RequestParam(name = "razonsocial" , required = false, defaultValue = "") String razonsocial,
			@RequestParam(name = "ruc" , required = false, defaultValue = "") String ruc,
			@RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
			@RequestParam(name = "idPais" , required = false, defaultValue = "-1") int idPais,
			@RequestParam(name = "idTipoProveedor" , required = false, defaultValue = "-1") int idTipoProveedor){

		List<Proveedor> lstProveedor = service.listaConsultaDinamica("%" + razonsocial + "%", "%" + ruc + "%",
				estado, idPais, idTipoProveedor);
		
		return lstProveedor;
	}
	
}
