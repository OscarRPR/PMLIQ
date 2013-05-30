/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum TipoManual {
    INSTALACION("Instalacion"),
    TECNICO("Tecnico"),
    USUARIO("De usuario"),
    LABORATORIO("Dcoumento por el lab.");
    
    private final String stringValue;
    private TipoManual(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
