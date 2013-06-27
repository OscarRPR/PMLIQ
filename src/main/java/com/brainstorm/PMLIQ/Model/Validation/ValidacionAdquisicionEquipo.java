/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesAdquisicionEquipo;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoNumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class ValidacionAdquisicionEquipo extends Validacion{
    private ConstantesAdquisicionEquipo vars = new ConstantesAdquisicionEquipo();
    
    @Override
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.fabricante, strings.get(vars.FABRICANTE), vars.minFabricante, vars.maxFabricante);
            formatoAlfabeticoString(vars.fabricante, strings.get(vars.FABRICANTE));
            longitudString(vars.proveedor, strings.get(vars.PROVEEDOR), vars.minProveedor, vars.maxProveedor);
            formatoAlfabeticoString(vars.proveedor, strings.get(vars.PROVEEDOR));
            longitudString(vars.nit, strings.get(vars.NIT), vars.minNit, vars.maxNit);
            formatoNumericoString(vars.nit, strings.get(vars.NIT));
            longitudString(vars.contacto, strings.get(vars.CONTACTO), vars.minContacto, vars.maxContacto);
            formatoAlfabeticoString(vars.contacto, strings.get(vars.CONTACTO));
            longitudString(vars.telefono, strings.get(vars.TELEFONO), vars.minTelefono, vars.maxTelefono);
            formatoNumericoString(vars.telefono, strings.get(vars.TELEFONO));
            longitudString(vars.direccion, strings.get(vars.DIRECCION), vars.minDireccion, vars.maxDireccion);
            longitudString(vars.email, strings.get(vars.EMAIL), vars.minEmail, vars.maxEmail);
            longitudString(vars.precio, strings.get(vars.PRECIO), vars.minPrecio, vars.maxPrecio);
            formatoNumericoString(vars.precio, strings.get(vars.PRECIO));
        } catch(LongitudStringException ex) {
            resultado = crearErrorLongitudString(ex.getTipo(), ex.getMinimo(), ex.getMaximo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoAlfabeticoStringException ex) {
            resultado = crearErrorFormatoAlfabeticoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        } catch (FormatoNumericoStringException ex) {
            resultado = crearErrorFormatoNumericoString(ex.getTipo());
            throw new ErrorValidacionException(resultado, ex.getCause());
        }

        return resultado;
    }    
}
