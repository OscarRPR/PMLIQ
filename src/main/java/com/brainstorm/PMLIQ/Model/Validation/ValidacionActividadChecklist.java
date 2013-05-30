/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesActividadChecklist;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorDatosRepetidosStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudListaException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class ValidacionActividadChecklist extends Validacion{
    private ConstantesActividadChecklist vars = new ConstantesActividadChecklist();
    
    @Override
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.nombre, strings.get(vars.NOMBRE), vars.minNombre, vars.maxNombre);
            formatoAlfabeticoString(vars.nombre, strings.get(vars.NOMBRE));
            longitudLista(vars.partes, strings.get(vars.PARTES));
            longitudString(vars.proceso, strings.get(vars.PROCESO), vars.minProceso, vars.maxProceso);
            
        } catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (LongitudListaException ex) {
            resultado = crearErrorLongitudLista(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } 
        return resultado;
    }    
    
    @Override
    public String validarValorRepetidoString(final List<String> strings, final List<String> repetidos) throws ErrorValidacionException {
        String nombre = strings.get(vars.NOMBRE);
        String resultado = "";
        
        try {
            datoRepetido(vars.nombre, nombre, repetidos);
        } catch (ErrorDatosRepetidosStringException ex) {
            resultado = crearErrorDatoRepetidoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }

        return resultado;
    }
    
    
}
