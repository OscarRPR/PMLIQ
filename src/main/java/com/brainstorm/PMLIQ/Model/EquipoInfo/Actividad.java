/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Model.Enum.TimeStamp;
import com.brainstorm.PMLIQ.Model.Enum.TipoActividad;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Actividad {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public List<Item> getPartesAsociadas() {
        return partesAsociadas;
    }

    public void setPartesAsociadas(List<Item> partesAsociadas) {
        this.partesAsociadas = partesAsociadas;
    }

    public int getFrecuenciaTarea() {
        return frecuenciaTarea;
    }

    public void setFrecuenciaTarea(int frecuenciaTarea) {
        this.frecuenciaTarea = frecuenciaTarea;
    }

    public int getVerificarInventario() {
        return verificarInventario;
    }

    public void setVerificarInventario(int verificarInventario) {
        this.verificarInventario = verificarInventario;
    }

    public TimeStamp getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(TimeStamp frecuencia) {
        this.frecuencia = frecuencia;
    }

    public TimeStamp getVerificar() {
        return verificar;
    }

    public void setVerificar(TimeStamp verificar) {
        this.verificar = verificar;
    }

    private String nombre, proceso;
    private TipoActividad tipoActividad;
    private List<Item> partesAsociadas;
    private int frecuenciaTarea, verificarInventario;
    private TimeStamp frecuencia, verificar;
}
