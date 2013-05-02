/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class ErrorDatosRepetidosStringException extends Exception {
    private String tipo;

    public ErrorDatosRepetidosStringException() { super(); }
    
    public ErrorDatosRepetidosStringException(String tipo) { 
        super("Dato repetido"); 
        this.tipo = tipo;
    }

    public ErrorDatosRepetidosStringException(String message, Throwable cause) { super(message, cause); }
    public ErrorDatosRepetidosStringException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }        
}
