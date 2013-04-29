/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum TipoActividad {
    LIMPIEZA("Limpieza"),
    SEGURIDAD("Seguridad");
    
    private final String stringValue;
    private TipoActividad(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
