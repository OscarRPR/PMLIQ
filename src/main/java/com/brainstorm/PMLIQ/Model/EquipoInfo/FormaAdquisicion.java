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
    
    private boolean compra, donacion;
    private String valorCompra;
    private Integer tiempoUso, vidaUtil;
    private Fecha fechaAdquisicion, puestaEnServicio;
    
    private final String COMPRA = "Compra";
    private final String DONACION = "Donación";
    
    public FormaAdquisicion() {
    }
    
    public FormaAdquisicion(String tipo, String precio, String uso, String adquisicion,
                            String servicio, String vidaEstimada) {
        
        compra = true;
        donacion = false;
        
        if ( tipo.equals(DONACION) ){
            compra = false;
            donacion = true;
        }
        
        this.valorCompra = precio;
        this.tiempoUso = Integer.parseInt(uso);
        this.fechaAdquisicion = new Fecha(adquisicion);
        this.puestaEnServicio = new Fecha(servicio);
        this.vidaUtil = Integer.parseInt(vidaEstimada);
    }

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

    public Integer getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public Integer getVidaUtil() {
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
}
