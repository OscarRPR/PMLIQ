/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesDatosTecnicos;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class DatosTecnicosEquipo {

    private ConstantesDatosTecnicos vars = new ConstantesDatosTecnicos();
    
    public DatosTecnicosEquipo(List<String> datosTecnicos) {
        
        datosElectricos = new DatosElectricosEquipo(datosTecnicos.get(vars.VOLTAJE),
                                                    datosTecnicos.get(vars.POTENCIA),
                                                    datosTecnicos.get(vars.CORRIENTE),
                                                    datosTecnicos.get(vars.FASES),
                                                    datosTecnicos.get(vars.TIPO));
        dimensiones = new DimensionesEquipo(datosTecnicos.get(vars.ALTO),
                                            datosTecnicos.get(vars.ANCHO),
                                            datosTecnicos.get(vars.PROFUNDO),
                                            datosTecnicos.get(vars.PESO),
                                            datosTecnicos.get(vars.USO));
        
        this.temperaturaAmbiente = Double.parseDouble(datosTecnicos.get(vars.AMBIENTE));
        this.HR = Double.parseDouble(datosTecnicos.get(vars.HR));
        this.otraOpcion = datosTecnicos.get(vars.OTRO);
        this.requerimientosAdicionales = datosTecnicos.get(vars.REQUERIMIENTOS);
        this.especificacionMedicion = datosTecnicos.get(vars.ESPECIFICACION);
    }
    
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
