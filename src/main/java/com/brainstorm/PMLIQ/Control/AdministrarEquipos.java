/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control;

import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Validacion;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionDatosTecnicos;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionEquipo;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class AdministrarEquipos {
        
    private ConstantesEquipos vars = new ConstantesEquipos();
    private Validacion validacion = new ValidacionEquipo();
    
    public List<String> crearEquipo(List<String> infoEquipo, List<String> datosTecnicos)
    {
        List<String> validaciones = new ArrayList<String>();
        validaciones.add(validacionDatosEquipo(infoEquipo));
        validaciones.add(validacionDatosTecnicos(datosTecnicos));
        
        if ( verificarResultadoValidaciones(validaciones) ) 
        {
            Equipo nuevoEquipo = new Equipo(infoEquipo.get(vars.NOMBRE),
                                     infoEquipo.get(vars.PLACAINVENTARIO),
                                     infoEquipo.get(vars.CLASEEQUIPO),
                                     infoEquipo.get(vars.TIPO),
                                     infoEquipo.get(vars.MARCA),
                                     infoEquipo.get(vars.MODELO),
                                     infoEquipo.get(vars.SERIE),
                                     infoEquipo.get(vars.MANUALES),
                                     infoEquipo.get(vars.CODIGO),
                                     infoEquipo.get(vars.UBICACION),
                                     infoEquipo.get(vars.USO),
                                     infoEquipo.get(vars.TAREAS)
                    );
            //nuevoEquipo.agregarDatosTecnicos();  
            PMLIApp.getInstance().getSistema().agregarEquipo(nuevoEquipo);
        }          
        return validaciones;
    }
    
    private boolean verificarResultadoValidaciones(List<String> strings) 
    {
        for ( String s : strings )
        {
            if ( s.equals("") ) 
            {
                return false;
            }
        }
        return true;
    }
    
    public String validacionDatosEquipo(List<String> strings)
    {
        String resultadoValidacion = null;
        validacion = new ValidacionEquipo();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    public String validacionDatosTecnicos(List<String> strings)
    {
        String resultadoValidacion = null;
        validacion = new ValidacionDatosTecnicos();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
}
