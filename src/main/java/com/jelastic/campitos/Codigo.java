/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import java.util.Date;

/**
 *
 * @author campitos
 */
public class Codigo {
    private Integer identificador;
    private Integer valor;
    private Date date;

    public Codigo() {
    }

    
    public Codigo(Integer identificador, Integer valor, Date date) {
        this.identificador = identificador;
        this.valor = valor;
        this.date = date;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return identificador;
    }

    public void setId(Integer identificador) {
        this.identificador = identificador;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
