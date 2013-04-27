/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.ConstantesDatosTecnicos;
import com.brainstorm.PMLIQ.Control.ConstantesEquipos;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoNumericoDoubleException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silex RPR
 */
public class ValidacionDatosTecnicos extends Validacion{

    private ConstantesDatosTecnicos vars = new ConstantesDatosTecnicos();
    
    @Override
    public String validarString(List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.voltaje, strings.get(vars.VOLTAJE), vars.minVoltaje, vars.maxVoltaje);
            formatoNumericoLong(vars.voltaje, strings.get(vars.VOLTAJE));
        }
        catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoNumericoDoubleException ex) {
            resultado = crearErrorFormatoDouble(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }
        /*catch(FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }*/
        /*catch(FormatoAlfanumericoStringException ex) {
             resultado = crearErrorFormatoAlfanumericoString(ex.getTipo());
             throw new ErrorValidacionException(resultado, ex.getCause());
        }*/
        
        return resultado;
    }
}
