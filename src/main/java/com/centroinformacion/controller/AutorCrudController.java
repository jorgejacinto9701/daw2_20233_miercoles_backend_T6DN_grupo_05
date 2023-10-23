package com.centroinformacion.controller;

import com.centroinformacion.entity.Autor;
import com.centroinformacion.service.AutorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/autorCrud")
public class AutorCrudController {
    @Autowired
    private AutorServiceImp serAutor;

    @GetMapping("/listaAutorPorNombre/{nom}")
    @ResponseBody
    public ResponseEntity<?> lista(@PathVariable("nom") String nom){
        List<Autor> lista=null;
        try{
            System.out.println("el nombre es : " + nom);
            if(nom.trim().equals("todos")){
                lista=serAutor.buscarNombreLike("%");
            }
            else{
                lista=serAutor.buscarNombreLike("%"+ nom + "%");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscarPorId/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@PathVariable("id") int id){
        Autor a = new Autor();
        try{
            a=serAutor.buscarPorId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(a);
    }

    @PostMapping("/registrarAutor")
    @ResponseBody
    public ResponseEntity<Map<String, String>> registrarAutor(@RequestBody Autor autor){
        Map<String, String> salida = new HashMap<>();
        try{
            autor.setIdAutor(0);
            autor.setFechaRegistro(new Date());
            autor.setFechaActualizacion(new Date());
            autor.setEstado(1);

            Autor a = serAutor.registrar(autor);
            if(a==null){
                salida.put("mensaje", "ERROR EN EL REGISTRO DEL AUTOR");
            }else{
                salida.put("mensaje", "REGISTRO EXITOSO");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(salida);
    }
    @PutMapping("/actualizarAutor")
    @ResponseBody
    public ResponseEntity<Map<String, String>> actualizarAutor(@RequestBody Autor autor){
        Map<String, String> salida = new HashMap<>();
        try{
            autor.setFechaActualizacion(new Date());
            Autor a = serAutor.actualizar(autor);
            if(a==null){
                salida.put("mensaje", "ERROR EN LA ACTUALIZACION DEL AUTOR");
            }else{
                salida.put("mensaje", "ACTIALIZACION EXITOSA");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminarAutor/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> aliminarAutor(@PathVariable("id") int id){
        Map<String, String> salida = new HashMap<>();
        try{
            serAutor.eliminar(id);
            salida.put("mensaje", "AUTOR ELIMINADO");
        }catch(Exception e){
            e.printStackTrace();
            salida.put("mensaje", "ERROR AL MOMENTO DE ELIMINAR EL AUTOR");
        }

        return ResponseEntity.ok(salida);
    }


}
