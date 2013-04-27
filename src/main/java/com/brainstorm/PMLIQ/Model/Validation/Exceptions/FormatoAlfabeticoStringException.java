/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class FormatoAlfabeticoStringException extends Exception {
    private String tipo;

    public FormatoAlfabeticoStringException() { super(); }
    
    public FormatoAlfabeticoStringException(String tipo) { 
        super("Formato alfabetico no valido"); 
        this.tipo = tipo;
    }

    public FormatoAlfabeticoStringException(String message, Throwable cause) { super(message, cause); }
    public FormatoAlfabeticoStringException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    
    
}
