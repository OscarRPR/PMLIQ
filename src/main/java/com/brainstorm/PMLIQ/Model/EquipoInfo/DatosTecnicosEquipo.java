/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

/**
 *
 * @author Silex RPR
 */
public class DatosTecnicosEquipo {

    public DatosElectricosEquipo getDatosElectricos() {
        return datosElectricos;
    }

    public void setDatosElectricos(DatosElectricosEquipo datosElectricos) {
        this.datosElectricos = datosElectricos;
    }

    public DimensionesEquipo getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(DimensionesEquipo dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Double getTemperaturaAmbiente() {
        return temperaturaAmbiente;
    }

    public void setTemperaturaAmbiente(Double temperaturaAmbiente) {
        this.temperaturaAmbiente = temperaturaAmbiente;
    }

    public Double getHR() {
        return HR;
    }

    public void setHR(Double HR) {
        this.HR = HR;
    }

    public String getOtraOpcion() {
        return otraOpcion;
    }

    public void setOtraOpcion(String otraOpcion) {
        this.otraOpcion = otraOpcion;
    }

    public String getRequerimientosAdicionales() {
        return requerimientosAdicionales;
    }

    public void setRequerimientosAdicionales(String requerimientosAdicionales) {
        this.requerimientosAdicionales = requerimientosAdicionales;
    }

    public String getEspecificacionMedicion() {
        return especificacionMedicion;
    }

    public void setEspecificacionMedicion(String especificacionMedicion) {
        this.especificacionMedicion = especificacionMedicion;
    }

    DatosElectricosEquipo datosElectricos;
    DimensionesEquipo dimensiones;
    Double temperaturaAmbiente, HR;
    String otraOpcion, requerimientosAdicionales, especificacionMedicion;
}
