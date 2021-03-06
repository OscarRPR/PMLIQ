/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesEquipoAsociado;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class ValidacionEquipoAsociado extends Validacion{
    private ConstantesEquipoAsociado vars = new ConstantesEquipoAsociado();
    
    @Override
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.nombre, strings.get(vars.NOMBRE), vars.minNombre, vars.maxNombre);
            formatoAlfabeticoString(vars.nombre, strings.get(vars.NOMBRE));
            longitudString(vars.placa, strings.get(vars.PLACA), vars.minPlaca, vars.maxPlaca);
            formatoAlfanumericoString(vars.placa, strings.get(vars.PLACA));
        } catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfanumericoStringException ex) {
            resultado = crearErrorFormatoAlfanumericoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }

        return resultado;
    }    
    
}
