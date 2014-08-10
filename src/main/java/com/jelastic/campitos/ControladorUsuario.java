/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.inject.Inject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")
public class ControladorUsuario {
   @Autowired ServicioUsuario servicioUsuario;
    @RequestMapping(value="/usuario", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String  buscarTodos()throws Exception{
 /*
       Hay que refactorizar lo siguiente
       */
       
       Map<String, ArrayList<Usuario>> singletonMap=Collections.singletonMap("usuarios",(ArrayList<Usuario>) servicioUsuario.obtenerTodos());
       ObjectMapper maper=new ObjectMapper();
      return  maper.writeValueAsString(singletonMap);
    }
       @RequestMapping(value="/usuario/{nombre}/{edad}", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String insertarUsuario(@PathVariable String nombre, @PathVariable int edad)throws Exception{
       servicioUsuario.agregarUsuario(new Usuario(nombre, edad)); 
 return "Usuario guardado con exito";
    }
 
    
}
