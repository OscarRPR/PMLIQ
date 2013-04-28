/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class FormatoNumericoStringException extends Exception {
    private String tipo;

    public FormatoNumericoStringException() { super(); }
    
    public FormatoNumericoStringException(String tipo) { 
        super("Formato numerico no valido"); 
        this.tipo = tipo;
    }

    public FormatoNumericoStringException(String message, Throwable cause) { super(message, cause); }
    public FormatoNumericoStringException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }
    
}
