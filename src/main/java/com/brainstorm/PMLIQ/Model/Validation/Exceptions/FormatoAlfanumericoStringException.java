/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class FormatoAlfanumericoStringException extends Exception {
    private String tipo;

    public FormatoAlfanumericoStringException() { super(); }
    
    public FormatoAlfanumericoStringException(String tipo) { 
        super("Formato alfanumerico no valido"); 
        this.tipo = tipo;
    }

    public FormatoAlfanumericoStringException(String message, Throwable cause) { super(message, cause); }
    public FormatoAlfanumericoStringException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    
}
