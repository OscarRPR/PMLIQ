/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Model.Datatypes.Fecha;

/**
 *
 * @author Silex RPR
 */
public class FormaAdquisicion {

    public boolean isCompra() {
        return compra;
    }

    public void setCompra(boolean compra) {
        this.compra = compra;
    }

    public boolean isDonacion() {
        return donacion;
    }

    public void setDonacion(boolean donacion) {
        this.donacion = donacion;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public Fecha getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Fecha fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Fecha getPuestaEnServicio() {
        return puestaEnServicio;
    }

    public void setPuestaEnServicio(Fecha puestaEnServicio) {
        this.puestaEnServicio = puestaEnServicio;
    }
    
    boolean compra, donacion;
    String valorCompra;
    int tiempoUso, vidaUtil;
    Fecha fechaAdquisicion, puestaEnServicio;
}
