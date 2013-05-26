/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesFabricantes;
import com.brainstorm.PMLIQ.Control.Constantes.ConstantesItems;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.CampoVacioException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorDatosRepetidosStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoNumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silex RPR
 */
public class ValidacionItem extends Validacion{
    private ConstantesItems vars = new ConstantesItems();
    
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
            campoVacio(vars.fabricante, strings.get(vars.FABRICANTE));
        } catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfanumericoStringException ex) {
            resultado = crearErrorFormatoAlfanumericoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (CampoVacioException ex) {
            resultado = crearCampoVacio(ex.getTipo());
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
