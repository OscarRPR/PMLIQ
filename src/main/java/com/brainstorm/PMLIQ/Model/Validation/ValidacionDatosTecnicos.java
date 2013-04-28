/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesDatosTecnicos;
import com.brainstorm.PMLIQ.Control.Constantes.ConstantesEquipos;
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
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.voltaje, strings.get(vars.VOLTAJE), vars.minVoltaje, vars.maxVoltaje);
            formatoNumericoDouble(vars.voltaje, strings.get(vars.VOLTAJE));
            longitudString(vars.potencia, strings.get(vars.POTENCIA), vars.minPotencia, vars.maxPotencia);
            formatoNumericoDouble(vars.potencia, strings.get(vars.POTENCIA));
            longitudString(vars.corriente, strings.get(vars.CORRIENTE), vars.minCorriente, vars.maxCorriente);
            formatoNumericoDouble(vars.corriente, strings.get(vars.CORRIENTE));
            longitudString(vars.fases, strings.get(vars.FASES), vars.minFases, vars.maxFases);
            formatoNumericoDouble(vars.fases, strings.get(vars.FASES));
            longitudString(vars.alto, strings.get(vars.ALTO), vars.minAlto, vars.maxAlto);
            formatoNumericoDouble(vars.alto, strings.get(vars.ALTO));
            longitudString(vars.ancho, strings.get(vars.ANCHO), vars.minAncho, vars.maxAncho);
            formatoNumericoDouble(vars.ancho, strings.get(vars.ANCHO));
            longitudString(vars.profundo, strings.get(vars.PROFUNDO), vars.minProfundo, vars.maxProfundo);
            formatoNumericoDouble(vars.profundo, strings.get(vars.PROFUNDO));
            longitudString(vars.peso, strings.get(vars.PESO), vars.minPeso, vars.maxPeso);
            formatoNumericoDouble(vars.peso, strings.get(vars.PESO));
            longitudString(vars.ambiente, strings.get(vars.AMBIENTE), vars.minAmbiente, vars.maxAmbiente);
            formatoNumericoDouble(vars.ambiente, strings.get(vars.AMBIENTE));
            longitudString(vars.hr, strings.get(vars.HR), vars.minHr, vars.maxHr);
            formatoNumericoDouble(vars.hr, strings.get(vars.HR));
        }
        catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoNumericoDoubleException ex) {
            resultado = crearErrorFormatoDouble(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }

        return resultado;
    }
}
