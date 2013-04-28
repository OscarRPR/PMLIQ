/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control;

import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Accesorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.EquipoAsociado;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Validacion;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionAccesorioEquipo;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionAdquisicionEquipo;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionDatosTecnicos;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionEquipo;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionEquipoAsociado;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class AdministrarEquipos {
        
    private Validacion validacion = new ValidacionEquipo();
    
    public List<String> crearEquipo(List<String> infoEquipo, List<String> datosTecnicos,
                                    List<String> adquisicion)
    {
        List<String> validaciones = new ArrayList<String>();
        validaciones.add(validacionDatosEquipo(infoEquipo));
        validaciones.add(validacionDatosTecnicos(datosTecnicos));
        validaciones.add(validacionAdquisicionEquipo(adquisicion));
        
        if ( datosFueronValidados(validaciones) ) 
        {
            Equipo nuevoEquipo = new Equipo(infoEquipo);       
            nuevoEquipo.agregarDatosTecnicos(datosTecnicos);
            nuevoEquipo.agregarDatosAdquisicion(adquisicion);
            
            PMLIApp.getInstance().getSistema().agregarEquipo(nuevoEquipo);
        }          
        return validaciones;
    }
    
    public String validarDatosAccesorio(List<String> accesorioEquipo) {
        return validacionAccesorioEquipo(accesorioEquipo);
    }
    
    public String validarDatosAsociado(List<String> equipoAsociado) {
        return validacionEquipoAsociado(equipoAsociado);
    }

    public Accesorio crearAccesorio(List<String> accesorioEquipo) {
        Accesorio nuevoAccesorio = new Accesorio(accesorioEquipo);
        return nuevoAccesorio;
    }
    
    public EquipoAsociado crearEquipoAsociado(List<String> equipoAsociado) {
        EquipoAsociado nuevoEquipoAsociado = new EquipoAsociado(equipoAsociado);
        return nuevoEquipoAsociado;
    }
    
    private boolean datosFueronValidados(List<String> strings) 
    {
        for ( String s : strings )
        {
            if ( !s.equals("") ) 
            {
                return false;
            }
        }
        return true;
    }

    public String validacionDatosEquipo(List<String> strings)
    {
        String resultadoValidacion;
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
        String resultadoValidacion;
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
    
    public String validacionAdquisicionEquipo(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionAdquisicionEquipo();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    public String validacionAccesorioEquipo(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionAccesorioEquipo();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    public String validacionEquipoAsociado(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionEquipoAsociado();
        
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
