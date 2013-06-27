/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesActividadChecklist;
import com.brainstorm.PMLIQ.Model.Enum.TimeStamp;
import com.brainstorm.PMLIQ.Model.Enum.TipoActividad;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Actividad {

    private String nombre, proceso;
    private TipoActividad tipoActividad;
    private List<Item> partesAsociadas;
    private List<Integer> cantidades;
    private int tiempoTarea;
    private TimeStamp tiempo;
    
    private ConstantesActividadChecklist vars = new ConstantesActividadChecklist();
    
    public Actividad() {
    }
    
    public Actividad(List<String> datos, List<Item> partes, List<Integer> cantidades) {
        this.nombre = datos.get(vars.NOMBRE);
        this.tipoActividad = TipoActividad.valueOf(datos.get(vars.TIPO).toUpperCase());
        this.partesAsociadas = partes;
        this.cantidades = cantidades;
        this.proceso = datos.get(vars.PROCESO);
        this.tiempoTarea = Integer.parseInt(datos.get(vars.TIEMPOTAREA));
        this.tiempo = TimeStamp.valueOf(datos.get(vars.TIEMPO).toUpperCase());
    }

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

    public int getTiempoTarea() {
        return tiempoTarea;
    }

    public void setTiempoTarea(int tiempoTarea) {
        this.tiempoTarea = tiempoTarea;
    }

    public TimeStamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(TimeStamp tiempo) {
        this.tiempo = tiempo;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }
}
