package com.centroinformacion.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Tesis;
import com.centroinformacion.service.TesisService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/tesis")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TesisRegistraController {
	
	@Autowired
	private TesisService tesisService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Tesis>> listarTesis(){
		List<Tesis> listaTesis = tesisService.listarTesis();
		return ResponseEntity.ok(listaTesis);
	}
	
	 @PostMapping
	    @ResponseBody
	    public ResponseEntity<?> registrar(@RequestBody Tesis tesis){
	        HashMap<String, Object> salida = new HashMap<>();
 
	        tesis.setFechaActualizacion(new Date());
	        tesis.setFechaRegistro(new Date());
	        tesis.setEstado(AppSettings.ACTIVO);

	        Tesis objSalida = tesisService.registrarTesis(tesis);
	        if (objSalida == null) {
	            salida.put("mensaje","Error en el registro");
	        }else {
	            salida.put("mensaje","Se registró la tesis con el ID ==> " + objSalida.getIdTesis());
	        }
	        return ResponseEntity.ok(salida);
	    }	
}
