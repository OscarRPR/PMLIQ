/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class LongitudListaException extends Exception{
    private String tipo;

    public LongitudListaException() { super(); }
    
    public LongitudListaException(String tipo) { 
        super("Longitud de lista es cero"); 
        this.tipo = tipo;
    }

    public LongitudListaException(String message, Throwable cause) { super(message, cause); }
    public LongitudListaException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }    
}
