/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum PosicionUsoEquipo {
    PISO("Equipo de piso"),
    MESA("Equipo de mesa"),
    CAMPO("Equipo de uso en campo");
    
    private final String stringValue;
    private PosicionUsoEquipo(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
