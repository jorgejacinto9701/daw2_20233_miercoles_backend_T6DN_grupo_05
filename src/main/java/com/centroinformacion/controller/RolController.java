package com.centroinformacion.controller;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.RolHasOpcion;
import com.centroinformacion.service.RolHasOpcionServiceImp;
import com.centroinformacion.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/url/rolOpcion")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RolController {

    @Autowired
    private RolHasOpcionServiceImp rolHasOpcionServiceImp;

    @ResponseBody
    @PostMapping("/registrarOpcionRol")
    public HashMap<String, Object> registrarOpcion(@RequestBody RolHasOpcion obj){
        HashMap<String, Object> mapSalida = new HashMap<String, Object>();

        List<RolHasOpcion> validarOpcion = rolHasOpcionServiceImp.listaTodo();
        if(validarOpcion.stream().anyMatch(u->u.getRol()== obj.getRol() && u.getOpcion() == obj.getOpcion())){
            mapSalida.put("mensaje", "El rol ya tiene asiganda la opcion " + obj.getOpcion().getNombre());
        }else{
            RolHasOpcion salida = rolHasOpcionServiceImp.registrarRolHasOpcion(obj);
            if(salida != null){
                mapSalida.put("mensaje", "Se registro la opcion al rol" + salida.getRol().getIdRol());
                mapSalida.put("data", salida);
            }else{
                mapSalida.put("mensaje", "Hubo un error al registrar");
            }
        }
        return  mapSalida;
    }

    @DeleteMapping("/eliminar/{idOpcion}/{idRol}")
    public ResponseEntity<Map<String, String>> eliminarOpcionRol(@PathVariable("idOpcion") int idOpcion, @PathVariable("idRol") int idRol){
        HashMap<String, String> respuesta = new HashMap<>();
        rolHasOpcionServiceImp.eliminarRolHasOpcion(idRol, idOpcion);
        respuesta.put("mensaje","Opcion de rol eliminado");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/listarRoles")
    public List<Rol> listarRoles(){
        return rolHasOpcionServiceImp.listarRoles();
    }

    @GetMapping("/listarOpciones")
    public List<Opcion> listarOpciones(){
        return rolHasOpcionServiceImp.listarOpciones();
    }


    @GetMapping("/listarRolHasOpcionForRol/{idRol}")
    public List<RolHasOpcion> listarRolHasOpcionForRol(@PathVariable("idRol") int idRol){
        return rolHasOpcionServiceImp.listarRolHasOpcionPorIdRol(idRol);
    }
}
