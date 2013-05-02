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

    private ConstantesActividadChecklist vars = new ConstantesActividadChecklist();
    
    public Actividad(List<String> datos, List<Item> partes) {
        this.nombre = datos.get(vars.NOMBRE);
        this.tipoActividad = TipoActividad.valueOf(datos.get(vars.TIPO).toUpperCase());
        this.partesAsociadas = partes;
        this.proceso = datos.get(vars.PROCESO);
        this.frecuenciaTarea = Integer.parseInt(datos.get(vars.FRECUENCIA));
        this.frecuencia = TimeStamp.valueOf(datos.get(vars.FRECUENCIATIEMPO).toUpperCase());
        this.verificarInventario = Integer.parseInt(datos.get(vars.VERIFICAR));
        this.verificar = TimeStamp.valueOf(datos.get(vars.VERIFICARTIEMPO).toUpperCase());
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
