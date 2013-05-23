/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesEquipos;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorDatosRepetidosStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class ValidacionEquipo extends Validacion{

    private ConstantesEquipos vars = new ConstantesEquipos();
    
    @Override
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.nombre, strings.get(vars.NOMBRE), vars.minNombre, vars.maxNombre);
            formatoAlfabeticoString(vars.nombre, strings.get(vars.NOMBRE));
            longitudString(vars.placaInventario, strings.get(vars.PLACAINVENTARIO), vars.minPlaca, vars.maxPlaca);
            formatoAlfanumericoString(vars.placaInventario, strings.get(vars.PLACAINVENTARIO));
            longitudString(vars.claseEquipo, strings.get(vars.CLASEEQUIPO), vars.minClase, vars.maxClase);
            formatoAlfabeticoString(vars.claseEquipo, strings.get(vars.CLASEEQUIPO));
            longitudString(vars.marca, strings.get(vars.MARCA), vars.minMarca, vars.maxMarca);
            formatoAlfabeticoString(vars.marca, strings.get(vars.MARCA));
            longitudString(vars.modelo, strings.get(vars.MODELO), vars.minModelo, vars.maxModelo);
            formatoAlfabeticoString(vars.modelo, strings.get(vars.MODELO));
            longitudString(vars.serie, strings.get(vars.SERIE), vars.minSerie, vars.maxSerie);
            formatoAlfanumericoString(vars.serie, strings.get(vars.SERIE));
            longitudString(vars.codigo, strings.get(vars.CODIGO), vars.minCodigo, vars.maxCodigo);
            formatoAlfanumericoString(vars.codigo, strings.get(vars.CODIGO));
            longitudString(vars.ubicacion, strings.get(vars.UBICACION), vars.minUbicacion, vars.maxUbicacion);
            formatoAlfanumericoString(vars.ubicacion, strings.get(vars.UBICACION));
        }
        catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }
        catch(FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }
        catch(FormatoAlfanumericoStringException ex) {
             resultado = crearErrorFormatoAlfanumericoString(ex.getTipo());
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
