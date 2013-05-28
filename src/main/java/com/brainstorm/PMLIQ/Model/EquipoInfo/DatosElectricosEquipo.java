/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Model.Enum.TipoElectrico;

/**
 *
 * @author Silex RPR
 */
public class DatosElectricosEquipo {
 
    private Double voltaje, potencia, corriente, fases;
    private TipoElectrico tipoElectrico;
    
    public DatosElectricosEquipo() {
    }
    
    public DatosElectricosEquipo(String voltaje, String potencia, String corriente,
                           String fases, String tipo) {
        this.voltaje = Double.valueOf(voltaje);
        this.potencia = Double.valueOf(potencia);
        this.corriente = Double.valueOf(corriente);
        this.fases = Double.valueOf(fases);
        this.tipoElectrico = TipoElectrico.valueOf(tipo.toUpperCase());
    }
    
    public Double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(Double voltaje) {
        this.voltaje = voltaje;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Double getCorriente() {
        return corriente;
    }

    public void setCorriente(Double corriente) {
        this.corriente = corriente;
    }

    public Double getFases() {
        return fases;
    }

    public void setFases(Double fases) {
        this.fases = fases;
    }

    public TipoElectrico getTipoElectrico() {
        return tipoElectrico;
    }

    public void setTipoElectrico(TipoElectrico tipoElectrico) {
        this.tipoElectrico = tipoElectrico;
    }
}
