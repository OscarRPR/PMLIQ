/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Sistema {
    private List<Equipo> equipos;
    
    public Sistema()
    {
    }
    
    public void inicializaEquipos()
    {
        equipos = new ArrayList<Equipo>();
    }
    
    public void agregarEquipo(Equipo equipo) 
    {
        equipos.add(equipo);
    }
}
