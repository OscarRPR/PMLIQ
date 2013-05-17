/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesPlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Enum.TipoPlan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class PlanMantenimiento {

    private ConstantesPlanMantenimiento vars = new ConstantesPlanMantenimiento();
    
    public PlanMantenimiento(List<String> datos, List<Actividad> actividades) {
        this.nombre = datos.get(vars.NOMBRE);
        this.codigo = datos.get(vars.CODIGO);
        this.tipoPlan = TipoPlan.valueOf(datos.get(vars.TIPOPLAN).toUpperCase());
        this.responsable = datos.get(vars.RESPONSABLE);
        this.maximoRegistros = Integer.parseInt(datos.get(vars.MAXREGISTROS));
        this.frecuenciaUso = Integer.parseInt(datos.get(vars.USOSEMANAL));
        
        this.checkList = actividades;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public TipoPlan getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(TipoPlan tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public int getMaximoRegistros() {
        return maximoRegistros;
    }

    public void setMaximoRegistros(int maximoRegistros) {
        this.maximoRegistros = maximoRegistros;
    }

    public int getFrecuenciaUso() {
        return frecuenciaUso;
    }

    public void setFrecuenciaUso(int frecuenciaUso) {
        this.frecuenciaUso = frecuenciaUso;
    }

    public List<Actividad> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Actividad> checkList) {
        this.checkList = checkList;
    }

    private String nombre, codigo, responsable;
    private TipoPlan tipoPlan;
    private int maximoRegistros, frecuenciaUso;
    private List<Actividad> checkList = new ArrayList<Actividad>();
}
