/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Equipo;

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

    public int getTemperaturaAmbiente() {
        return temperaturaAmbiente;
    }

    public void setTemperaturaAmbiente(int temperaturaAmbiente) {
        this.temperaturaAmbiente = temperaturaAmbiente;
    }

    public int getHR() {
        return HR;
    }

    public void setHR(int HR) {
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
    int temperaturaAmbiente, HR;
    String otraOpcion, requerimientosAdicionales, especificacionMedicion;
}
