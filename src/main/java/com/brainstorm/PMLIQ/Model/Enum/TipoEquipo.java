/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum TipoEquipo {
    BASICO("Basico"), 
    ESPECIALIZADO("Especializado"), 
    COMPUTO("Computo");
        
    private final String stringValue;
    private TipoEquipo(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }
}
