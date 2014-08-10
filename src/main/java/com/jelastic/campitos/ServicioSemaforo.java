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
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 *
 * @author campitos
 */
@Configuration
public class ServicioSemaforo {
    
    
    @Inject private MongoTemplate mongoTemplate;
	
	
	public void agregarSemaforo(Semaforo sema){
		if(!mongoTemplate.collectionExists(Semaforo.class)){
			mongoTemplate.createCollection(Semaforo.class);
		}
		mongoTemplate.insert(sema);
             
                System.out.println("Se inserto bien el sema");
	} 
	
	public  ArrayList<Semaforo> obtenerTodos(){
		ArrayList<Semaforo> semas=new ArrayList<Semaforo>();

	 semas=(ArrayList<Semaforo>)mongoTemplate.findAll(Semaforo.class);
	return semas;
	}
        
   
       
      
}
