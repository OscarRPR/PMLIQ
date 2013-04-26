/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum UsoEquipo {
    DOCENCIA("Docencia"),
    INVESTIGACION("Investigacion"),
    EXTENSION("Extension");
    
    private final String stringValue;
    private UsoEquipo(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
