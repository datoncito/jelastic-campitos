/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;



/**
 *
 * @author campitos
 */
public class Usuario {
 
    private String id;
    private String nombre;
    private int edad;
public Usuario(){
    
}

    public Usuario( String nombre, int edad) {

        this.nombre = nombre;
        this.edad = edad;
    }
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

   
    
    
}
