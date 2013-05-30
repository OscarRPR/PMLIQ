/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum TipoPlan {
    PREVENTIVO("Preventivo"),
    CALIBRACION("Calibracion");
    
    private final String stringValue;
    private TipoPlan(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
