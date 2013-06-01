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
    PISO("Piso"),
    MESA("Mesa"),
    CAMPO("Campo");
    
    private final String stringValue;
    private PosicionUsoEquipo(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
