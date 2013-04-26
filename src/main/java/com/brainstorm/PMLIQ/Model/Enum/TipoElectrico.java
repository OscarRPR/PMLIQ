/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum TipoElectrico {
    NEUTRO("Neutro"),
    TIERRA("Tierra");
        
    private final String stringValue;
    private TipoElectrico(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }
}

