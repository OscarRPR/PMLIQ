/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesEquipoAsociado;
import com.brainstorm.PMLIQ.Control.Constantes.ConstantesPlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoNumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudListaException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silex RPR
 */
public class ValidacionPlanMantenimiento extends Validacion{
    private ConstantesPlanMantenimiento vars = new ConstantesPlanMantenimiento();
    
    @Override
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.nombre, strings.get(vars.NOMBRE), vars.minNombre, vars.maxNombre);
            formatoAlfabeticoString(vars.nombre, strings.get(vars.NOMBRE));
            longitudString(vars.codigo, strings.get(vars.CODIGO), vars.minCodigo, vars.maxCodigo);
            formatoNumericoString(vars.codigo, strings.get(vars.CODIGO));
            longitudString(vars.responsable, strings.get(vars.RESPONSABLE), vars.minResponsable, vars.maxResponsable);
            formatoAlfabeticoString(vars.responsable, strings.get(vars.RESPONSABLE));
            longitudLista(vars.checklist, strings.get(vars.CHECKLIST));
        } catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoNumericoStringException ex) {
            resultado = crearErrorFormatoNumericoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (LongitudListaException ex) {
            resultado = crearErrorLongitudLista(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }

        return resultado;
    }    
    
    
}
