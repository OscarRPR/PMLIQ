/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Equipo;

import com.brainstorm.PMLIQ.Model.Enum.TipoElectrico;

/**
 *
 * @author Silex RPR
 */
public class DatosElectricosEquipo {

    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCorriente() {
        return corriente;
    }

    public void setCorriente(int corriente) {
        this.corriente = corriente;
    }

    public int getFases() {
        return fases;
    }

    public void setFases(int fases) {
        this.fases = fases;
    }

    public TipoElectrico getTipoElectrico() {
        return tipoElectrico;
    }

    public void setTipoElectrico(TipoElectrico tipoElectrico) {
        this.tipoElectrico = tipoElectrico;
    }
 
    int voltaje, potencia, corriente, fases;
    TipoElectrico tipoElectrico;
}
