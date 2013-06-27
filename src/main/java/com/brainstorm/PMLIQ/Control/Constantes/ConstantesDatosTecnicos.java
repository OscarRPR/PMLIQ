/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control.Constantes;

/**
 *
 * @author Silex RPR
 */
public class ConstantesDatosTecnicos {
    public final String voltaje = "Voltaje";
    public final int minVoltaje = 1, maxVoltaje = 9;
    public final int VOLTAJE = 0;
    
    public final String potencia = "Potencia";
    public final int minPotencia = 1, maxPotencia = 9;
    public final int POTENCIA = 1;
      
    public final String corriente = "Corriente";
    public final int minCorriente = 1, maxCorriente = 9;
    public final int CORRIENTE = 2;
    
    public final String fases = "Fases";
    public final int minFases = 1, maxFases = 9;
    public final int FASES = 3;
    
    public final int TIPO = 4;
    
    public final String alto = "Alto";
    public final int minAlto = 1, maxAlto = 9;
    public final int ALTO = 5;   

    public final String ancho = "Ancho";
    public final int minAncho = 1, maxAncho = 9;
    public final int ANCHO = 6; 
       
    public final String profundo = "Profundo";
    public final int minProfundo = 1, maxProfundo = 9;
    public final int PROFUNDO = 7; 
  
    public final String peso = "Peso";
    public final int minPeso = 1, maxPeso = 9;
    public final int PESO = 8; 
    
    public final int USO = 9;

    public final String ambiente = "Temperatura Ambiente";
    public final int minAmbiente = 1, maxAmbiente = 6;
    public final int AMBIENTE = 10;

    public final String hr = "HR";
    public final int minHr = 1, maxHr = 6;
    public final int HR = 11;
    
    public final int OTRO = 12;
    
    public final int REQUERIMIENTOS = 13;
    
    public final int ESPECIFICACION = 14;
    
    public ConstantesDatosTecnicos()
    {
    }    
}
