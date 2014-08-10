/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/vistas")
public class ControladorVistas {
    
    @RequestMapping("/hola-vista")
    public String hola(){
        return "hola";
    }
    
}
