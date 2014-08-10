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
public class Semaforo {
    private Integer identificador;
    private Integer valor;
    private Date date;

    public Semaforo(Integer identificador, Integer valor, Date date) {
        this.identificador = identificador;
        this.valor = valor;
        this.date = date;
    }

    public Semaforo() {
    }


    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

   

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
}
