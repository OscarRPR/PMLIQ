/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Model.Enum.PosicionUsoEquipo;

/**
 *
 * @author Silex RPR
 */
public class DimensionesEquipo {

    private Double alto, ancho, profundo, peso;
    private PosicionUsoEquipo posicionUsoEquipo;
    
    public DimensionesEquipo() {
    }
    
    public DimensionesEquipo(String alto, String ancho, String profundo, String peso,
                             String posicionUsoEquipo) {
        this.alto = Double.valueOf(alto);
        this.ancho = Double.valueOf(ancho);
        this.profundo = Double.valueOf(profundo);
        this.peso = Double.valueOf(peso);
        this.posicionUsoEquipo = PosicionUsoEquipo.valueOf(posicionUsoEquipo.toUpperCase());
    }
    
    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getProfundo() {
        return profundo;
    }

    public void setProfundo(Double profundo) {
        this.profundo = profundo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public PosicionUsoEquipo getPosicionUsoEquipo() {
        return posicionUsoEquipo;
    }

    public void setPosicionUsoEquipo(PosicionUsoEquipo posicionUsoEquipo) {
        this.posicionUsoEquipo = posicionUsoEquipo;
    }
}
