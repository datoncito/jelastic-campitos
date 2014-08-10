/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")
public class ControladorArduino {
       @Autowired ServicioCodigo servicioCodigo;
       @Autowired ServicioSemaforo servicioSemaforo;
    @RequestMapping(value="/codigo", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String metodo1(@RequestParam(required = false) Integer id,@RequestParam(required = false) Integer  valor){
        servicioCodigo.agregarCodigo(new Codigo(id,valor, new Date()));
        
        return "El valor enviado es:"+valor;
    }
     @RequestMapping(value="/semaforo", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String metodo2(@RequestParam(required = false) Integer id,@RequestParam(required = false) Integer  valor){
        servicioSemaforo.agregarSemaforo(new Semaforo(id,valor, new Date()));
        
        return "El valor enviado es:"+valor;
    }
    
    @RequestMapping(value="/leer-codigo", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String  buscarTodosCodigos()throws Exception{
 /*
       Hay que refactorizar lo siguiente
       */
       
       Map<String, ArrayList<Codigo>> singletonMap=Collections.singletonMap("codigos",(ArrayList<Codigo>) servicioCodigo.obtenerTodos());
       ObjectMapper maper=new ObjectMapper();
      return  maper.writeValueAsString(singletonMap);
    }
    
    @RequestMapping(value="/leer-semaforo", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String  buscarTodosSemaforos()throws Exception{
 /*
       Hay que refactorizar lo siguiente
       */
       
       Map<String, ArrayList<Semaforo>> singletonMap=Collections.singletonMap("semaforos",(ArrayList<Semaforo>) servicioSemaforo.obtenerTodos());
       ObjectMapper maper=new ObjectMapper();
      return  maper.writeValueAsString(singletonMap);
    }
    
    
}
