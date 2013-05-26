/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class CampoVacioException extends Exception {
    private String tipo;

    public CampoVacioException() { super(); }
    
    public CampoVacioException(String tipo) { 
        super("Es necesario colocar informacion en este campo " + tipo); 
        this.tipo = tipo;
    }

    public CampoVacioException(String message, Throwable cause) { super(message, cause); }
    public CampoVacioException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }      
    
}
