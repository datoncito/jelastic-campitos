/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import java.util.ArrayList;
import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author campitos
 */
@Configuration
public class ServicioCodigo {
    
    
    @Inject private MongoTemplate mongoTemplate;
	
	
	public void agregarCodigo(Codigo codigo){
		if(!mongoTemplate.collectionExists(Codigo.class)){
			mongoTemplate.createCollection(Codigo.class);
		}
		mongoTemplate.insert(codigo);
             
                System.out.println("Se inserto bien el codigo");
	} 
	
	public  ArrayList<Codigo> obtenerTodos(){
		ArrayList<Codigo> codigos=new ArrayList<Codigo>();

	 codigos=(ArrayList<Codigo>)mongoTemplate.findAll(Codigo.class);
	return codigos;
	}
        
   
       
      
}
