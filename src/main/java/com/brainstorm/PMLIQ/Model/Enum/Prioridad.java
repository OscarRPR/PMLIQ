/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum Prioridad {
    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja");
    
    private final String stringValue;
    private Prioridad(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
