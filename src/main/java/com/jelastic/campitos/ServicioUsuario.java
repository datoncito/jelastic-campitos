/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author campitos
 */

@Configuration
public class ServicioUsuario {
    
    
    @Inject private MongoTemplate mongoTemplate;
	
	
	public void agregarUsuario(Usuario usuario){
		if(!mongoTemplate.collectionExists(Usuario.class)){
			mongoTemplate.createCollection(Usuario.class);
		}
		mongoTemplate.insert(usuario);
             
                System.out.println("Se inserto bien el usuario");
	} 
	
	public  ArrayList<Usuario> obtenerTodos(){
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();

	 usuarios=(ArrayList<Usuario>)mongoTemplate.findAll(Usuario.class);
	return usuarios;
	}
        
       public void obtenerUno(Usuario usuario){
      mongoTemplate.findOne(new Query(Criteria.where("nombre").is(usuario.getNombre())), Usuario.class);
				
			 }
       
       public void actualizarEdad(Usuario usuario){
            mongoTemplate.updateFirst(query(where("nombre").is(usuario.getNombre())), update("edad", usuario.getEdad()), Usuario.class);  
            System.out.println("Mongo dice que se actualizo bien");
	   // mongoTemplate.updateFirst(query(where("titulo").is(promo.getTitulo())), update("direccion", promo.getDireccion()), Promocion.class);    
       }
       
       public void actualizarNombre(Usuario usuario){
            mongoTemplate.updateFirst(query(where("edad").is(usuario.getEdad())), update("nombre", usuario.getNombre()), Usuario.class);  
            System.out.println("Mongo dice que se actualizo bien");
	   // mongoTemplate.updateFirst(query(where("titulo").is(promo.getTitulo())), update("direccion", promo.getDireccion()), Promocion.class);    
       }
}
