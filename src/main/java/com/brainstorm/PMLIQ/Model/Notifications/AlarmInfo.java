/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Notifications;

/**
 *
 * @author Silex RPR
 */
public class AlarmInfo {
    
    private Long tiempoActual;
    private Long tiempoMaximo;

    public AlarmInfo() {
        this.tiempoActual = null;
        this.tiempoMaximo = null;
    }
    
    public AlarmInfo(Long tiempoActual, Long tiempoMaximo) {
        this.tiempoActual = tiempoActual;
        this.tiempoMaximo = tiempoMaximo;
    }

    public Long getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(Long tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public Long getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(Long tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    } 
}
