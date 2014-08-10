package com.jelastic.campitos;


import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class ControladorGuardarImagen {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	GridFsTemplate gridFsTemplate;
	
	@RequestMapping(value="/cargar-imagen" ,method=RequestMethod.GET, headers={"Accept=Application/json"})
	public @ResponseBody String cargar()throws Exception{
            /*
		Animalito animal=new Animalito();
		animal.setEdad(2);
		animal.setNombre("Flokisito");
		mongoTemplate.save(animal);
		*/
		String mensaje="todo correctooooo";
		ArrayList<String> xxx=new ArrayList<String>();
		xxx.add("todo bien");
		xxx.add("por ahoraaaa");
		Map<String, ArrayList<String>> singletonMap=Collections.singletonMap("respuesta", xxx);
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(singletonMap);
		
		
	}
	
	//
	//CARGAMOS EL PROMO 1
	
	@RequestMapping(value="/cargar-mongo1", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file)throws Exception{
         String nombre=file.getOriginalFilename();
   long tamano= file.getSize();
    String fileName = null;
    InputStream inputStream = null;
    OutputStream outputStream = null;
    if (file.getSize() > 0) {
	            inputStream = file.getInputStream();
	          

                  String contenido=  file.getContentType();
               int punto=nombre.indexOf(".");
                String nombreSolo=nombre.substring(0, punto);
                 //   System.out.println("nombre de archivo:"+fileName);
                    // gridFsTemplate.store(inputStream,nombre);
                     gridFsTemplate.store(inputStream,nombre,file.getContentType());
              
    }
   System.out.println("El nombre de archivaldo es:"+nombre+" el tamaño del archivo esta:"+tamano);
 
      return  "guardado con exito";
          
        }
    
    /*
    Para leer la imagen
    */
    @RequestMapping(value="/leer-imagen/{nombre:.+}", method=RequestMethod.GET)
	public @ResponseBody byte[] culera2(HttpServletResponse response, @PathVariable String nombre)throws IOException{
		GridFSDBFile filesito=gridFsTemplate.findOne(new Query(Criteria.where("filename").is(nombre)));
		File imageFile=new File(nombre);
		  filesito.writeTo(imageFile);
	byte[] bytes=FileCopyUtils.copyToByteArray(imageFile);
	System.out.println("Recobrando correctamente con este metodo del todo nuevo");
	   response.setHeader("Content-Disposition", "attachment; filename=\"" + imageFile.getName() + "\"");
	   response.setContentLength(bytes.length);
	   response.setContentType("image/png");
		return bytes;
	}
    


	
	//
	//CARGAMOS LA PROMOCION 2
	
	@RequestMapping(value = "/cargar-mongo2", method = RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public  void cargarMongo2(@RequestParam("file") MultipartFile file, HttpServletResponse response)
			throws Exception{
		
		


    String nombre=file.getOriginalFilename();
   long tamano= file.getSize();
		  System.out.println("primordiosin casi quedara asi"+nombre+" el tamaño del archivo esta:"+tamano);
	String home=	  System.getProperty("user.home");
System.out.println(home);
		    System.out.println("El archivo ya ha sido procesado");
		    
		    String fileName = null;
		    InputStream inputStream = null;
	        OutputStream outputStream = null;
	        if (file.getSize() > 0) {
	            inputStream = file.getInputStream();
	          
	            fileName =  file.getOriginalFilename();
	        	

	        //  gridFsTemplate.store(inputStream, fileName);
	         //Ponemos mejor el nombre de la promocion que sera "promo1"
	            //Encontramos por el viejo
	  GridFSDBFile filesito=          gridFsTemplate.findOne(new Query(Criteria.where("filename").is("promo2")));
	    
	  //Borramos el viejo
	    gridFsTemplate.delete(new Query(Criteria.where("filename").is("promo2")));
	          //Agregamos el nuevo
	            gridFsTemplate.store(inputStream,"promo2");
	            outputStream = new FileOutputStream(fileName);
	   
	        
	            
	       
	            System.out.println("Archivo guardado correctamente en mongo db!");
	            outputStream.close();
	            inputStream.close();
	        }
		    
		    
		    
		    response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().write("{success:true, total:'1212', data:'cargado en:"+home+"'}");
	}
	
	//CARGAMOS EL PROMO 3
    //
	@RequestMapping(value = "/cargar-mongo3", method = RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public  void cargarMongo3(@RequestParam("file") MultipartFile file, HttpServletResponse response)
			throws Exception{
		
		


    String nombre=file.getOriginalFilename();
   long tamano= file.getSize();
		  System.out.println("primordiosin casi quedara asi"+nombre+" el tamaño del archivo esta:"+tamano);
	String home=	  System.getProperty("user.home");
System.out.println(home);
		    System.out.println("El archivo ya ha sido procesado");
		    
		    String fileName = null;
		    InputStream inputStream = null;
	        OutputStream outputStream = null;
	        if (file.getSize() > 0) {
	            inputStream = file.getInputStream();
	          
	            fileName =  file.getOriginalFilename();
	        	

	        //  gridFsTemplate.store(inputStream, fileName);
	         //Ponemos mejor el nombre de la promocion que sera "promo1"
	            //Encontramos por el viejo
	  GridFSDBFile filesito=          gridFsTemplate.findOne(new Query(Criteria.where("filename").is("promo3")));
	    
	  //Borramos el viejo
	    gridFsTemplate.delete(new Query(Criteria.where("filename").is("promo3")));
	          //Agregamos el nuevo
	            gridFsTemplate.store(inputStream,"promo3");
	            outputStream = new FileOutputStream(fileName);
	   
	        
	            
	       
	            System.out.println("Archivo guardado correctamente en mongo db!");
	            outputStream.close();
	            inputStream.close();
	        }
		    
		    
		    
		    response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().write("{success:true, total:'1212', data:'cargado en:"+home+"'}");
	}
	
	
	//
	//CARGAMOS LA PROMOCION 4
	@RequestMapping(value = "/cargar-mongo4", method = RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public  void cargarMongo4(@RequestParam("file") MultipartFile file, HttpServletResponse response)
			throws Exception{
		
		


    String nombre=file.getOriginalFilename();
   long tamano= file.getSize();
		  System.out.println("primordiosin casi quedara asi"+nombre+" el tamaño del archivo esta:"+tamano);
	String home=	  System.getProperty("user.home");
System.out.println(home);
		    System.out.println("El archivo ya ha sido procesado");
		    
		    String fileName = null;
		    InputStream inputStream = null;
	        OutputStream outputStream = null;
	        if (file.getSize() > 0) {
	            inputStream = file.getInputStream();
	          
	            fileName =  file.getOriginalFilename();
	        	

	        //  gridFsTemplate.store(inputStream, fileName);
	         //Ponemos mejor el nombre de la promocion que sera "promo1"
	            //Encontramos por el viejo
	  GridFSDBFile filesito=          gridFsTemplate.findOne(new Query(Criteria.where("filename").is("promo4")));
	    
	  //Borramos el viejo
	    gridFsTemplate.delete(new Query(Criteria.where("filename").is("promo4")));
	          //Agregamos el nuevo
	            gridFsTemplate.store(inputStream,"promo4");
	            outputStream = new FileOutputStream(fileName);
	   
	        
	            
	       
	            System.out.println("Archivo guardado correctamente en mongo db!");
	            outputStream.close();
	            inputStream.close();
	        }
		    
		    
		    
		    response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().write("{success:true, total:'1212', data:'cargado en:"+home+"'}");
	}
	
	
	/*
	@RequestMapping(value="/leer-imagen/{nombre:.+}", method=RequestMethod.GET)
    public @ResponseBody String leerImagen(@PathVariable String nombre) {
		Query query=new Query();
		
	GridFSDBFile filesito=	gridFsTemplate.findOne(new Query(Criteria.where("filename").is(nombre)));
	
	long tam=	filesito.getLength();
        return "Tamano de archivaldo:"+tam;
    }
*/	

	@RequestMapping(value="/leer-imagen-monguito/{nombre:.+}", method=RequestMethod.GET)
	public @ResponseBody byte[] culera(HttpServletResponse response, @PathVariable String nombre)throws IOException{
		GridFSDBFile filesito=gridFsTemplate.findOne(new Query(Criteria.where("filename").is(nombre)));
		File imageFile=new File(nombre);
		  filesito.writeTo(imageFile);
	byte[] bytes=FileCopyUtils.copyToByteArray(imageFile);
	System.out.println("Recobrando correctamente con este metodo del todo nuevo");
	   response.setHeader("Content-Disposition", "attachment; filename=\"" + imageFile.getName() + "\"");
	   response.setContentLength(bytes.length);
	   response.setContentType("image/png");
		return bytes;
	}
	
	

	
	
	@RequestMapping("/get-image.png")
	@ResponseBody
	public byte[] getImage(HttpServletResponse response) throws IOException {
		GridFSDBFile filesito=	gridFsTemplate.findOne(new Query(Criteria.where("filename").is("facebook.png")));
	InputStream in=	filesito.getInputStream();
	
	    File imageFile = new File("juan.png");
	    filesito.writeTo(imageFile);
	    byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(imageFile);

	    response.setHeader("Content-Disposition", "attachment; filename=\"" + imageFile.getName() + "\"");
	    response.setContentLength(bytes.length);
	    response.setContentType("image/png");

	    return bytes;
	}
	
	
	
	@RequestMapping(value = "/cargar", method = RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public  void plainText(@RequestParam("file") MultipartFile file, HttpServletResponse response)
			throws Exception{
    String nombre=file.getOriginalFilename();
   long tamano= file.getSize();
		  System.out.println("primordiosin casi quedara asi"+nombre+" el tamaño del archivo esta:"+tamano);
	String home=	  System.getProperty("user.home");
System.out.println(home);
		    System.out.println("El archivo ya ha sido procesado");
		    
		    String fileName = null;
		    InputStream inputStream = null;
	        OutputStream outputStream = null;
	        if (file.getSize() > 0) {
	            inputStream = file.getInputStream();
	          
	            fileName = home+"/public_html/" + file.getOriginalFilename();
	            outputStream = new FileOutputStream(fileName);
	            int readBytes = 0;
	            byte[] buffer = new byte[10000];
	            while ((readBytes = inputStream.read(buffer, 0 , 10000))!=-1){
	 
	                outputStream.write(buffer, 0, readBytes);
	            }
	            System.out.println("Archivo guardado en la carpeta de usuario");
	            outputStream.close();
	            inputStream.close();
	        }
		    
		    
		    
		    response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().write("{success:true, total:'1212', data:'cargado en:"+home+"'}");
	}
	
	
	@RequestMapping(value="/cargar", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "Tu archivo se cargara a esta misma url pero usando POST :).";
    }
	
	/*
	 * 
	 * SIGUE JSONP   ESTE PORYECTO RECIBE RESPUESTA EN NETBEANS PROJECTS WEB-SITES UBICADO EN GITHUB EN 
	 * CAMPITOSLEY DENTRO DEL ARCHIVO prueba_cross_domain.html
	 */
	@RequestMapping(value = "/jsonp", method = RequestMethod.GET)
	public ResponseEntity handleSimpleJsonp(@RequestParam("callback") String inCallback) {

		StringBuffer theStringBuffer = new StringBuffer();
	        HashMap theHashMap = new HashMap();

		theHashMap.put("promo1", "Barefoot");
		theHashMap.put("promo2", "Starbucks");
		theHashMap.put("promo3", "Este es muy bueno");

		// add the callback function name and open paren
		theStringBuffer.append(inCallback);
		theStringBuffer.append("(");

		// serialize the POJO to JSON
		String theResponseString = serializeToJson(theHashMap); 

		// add the JSON string and close parens
		theStringBuffer.append(theResponseString);
		theStringBuffer.append(")");

		return new ResponseEntity(theStringBuffer.toString(), new HttpHeaders(), HttpStatus.OK);
	}

	private String serializeToJson(Object theObject) {

		String theJsonString = null;

		try {
			ObjectMapper theObjectMapper = new ObjectMapper();
			ByteArrayOutputStream theJsonOutputStream = new ByteArrayOutputStream();
			theObjectMapper.writeValue(theJsonOutputStream, theObject);

			theJsonString = theJsonOutputStream.toString("UTF-8");
		} catch (Exception theException) {
		        theException.printStackTrace();
	        }

	     return theJsonString;

	}

    

}
