/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Enum;

/**
 *
 * @author Silex RPR
 */
public enum TimeStamp {
    HORAS("Horas"),
    DIAS("Dias"),
    SEMANAS("Semanas"),
    MESES("Meses"),
    AÑOS("Años");
    
    private final String stringValue;
    private TimeStamp(final String s) { stringValue = s; }
    @Override
    public String toString() { return stringValue; }    
}
