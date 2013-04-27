/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation.Exceptions;

/**
 *
 * @author Silex RPR
 */
public class LongitudStringException extends Exception {
    
    private String tipo;
    private int minimo, maximo;
    
    public LongitudStringException() { super(); }
    
    public LongitudStringException(String tipo, int minimo, int maximo) { 
        super("Longitud de string no permitida"); 
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public LongitudStringException(String message, Throwable cause) { super(message, cause); }
    public LongitudStringException(Throwable cause) { super(cause); }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
    
}
