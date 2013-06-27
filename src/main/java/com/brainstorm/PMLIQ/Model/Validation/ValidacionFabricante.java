/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesFabricantes;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorDatosRepetidosStringException;
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
public class ValidacionFabricante extends Validacion{
    private ConstantesFabricantes vars = new ConstantesFabricantes();
    
    @Override
    public String validarString(final List<String> strings) throws ErrorValidacionException
    {
        String resultado = "";
        try
        {
            longitudString(vars.nombre, strings.get(vars.NOMBRE), vars.minNombre, vars.maxNombre);
            formatoAlfabeticoString(vars.nombre, strings.get(vars.NOMBRE));
            longitudString(vars.informacion, strings.get(vars.INFORMACION), vars.minInformacion, vars.maxInformacion);
            longitudString(vars.contacto, strings.get(vars.CONTACTO), vars.minContacto, vars.maxContacto);
            formatoAlfabeticoString(vars.contacto, strings.get(vars.CONTACTO));
            longitudString(vars.direccion, strings.get(vars.DIRECCION), vars.minDireccion, vars.maxDireccion);
            longitudString(vars.telefono1, strings.get(vars.TELEFONOUNO), vars.minTelefono1, vars.maxTelefono1);
            formatoNumericoString(vars.telefono1, strings.get(vars.TELEFONOUNO));
            longitudString(vars.telefono2, strings.get(vars.TELEFONODOS), vars.minTelefono2, vars.maxTelefono2);
            formatoNumericoString(vars.telefono2, strings.get(vars.TELEFONODOS));
            longitudString(vars.correo, strings.get(vars.CORREO), vars.minCorreo, vars.maxCorreo);
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
