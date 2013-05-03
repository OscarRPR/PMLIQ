/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control;

import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Validacion;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionFabricante;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionItem;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class AdministrarItems {
   
    private Validacion validacion = new ValidacionItem();    
    
    public List<String> crearItem(final List<String> item, final List<String> existentes)
    {
        List<String> validaciones = new ArrayList<String>();
        validaciones.add(validacionDatos(new ValidacionItem(), item, existentes));
  
        if ( datosFueronValidados(validaciones) ) 
        {
            Item nuevoItem = new Item(item);       

            PMLIApp.getInstance().getSistema().agregarItem(nuevoItem);
        }   
        
        return validaciones;
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
    
    private String validacionDatos(Validacion tipoValidacion, List<String> strings, List<String> repetidos) {
        String resultadoValidacion;
        validacion = tipoValidacion;
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
            resultadoValidacion = validacion.validarValorRepetidoString(strings, repetidos);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;        
    }    
}
