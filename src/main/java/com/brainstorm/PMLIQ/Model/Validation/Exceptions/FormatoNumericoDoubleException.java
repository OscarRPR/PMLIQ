/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class FormatoNumericoDoubleException extends Exception {
    private String tipo;

    public FormatoNumericoDoubleException() { super(); }
    
    public FormatoNumericoDoubleException(String tipo) { 
        super("Formato numerico no valido"); 
        this.tipo = tipo;
    }

    public FormatoNumericoDoubleException(String message, Throwable cause) { super(message, cause); }
    public FormatoNumericoDoubleException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }
    
}
