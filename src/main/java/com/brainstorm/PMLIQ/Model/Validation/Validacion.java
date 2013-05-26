/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Validation;

import com.brainstorm.PMLIQ.Model.Validation.Exceptions.CampoVacioException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorDatosRepetidosStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfabeticoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoAlfanumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoNumericoDoubleException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.FormatoNumericoStringException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudListaException;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Silex RPR
 */
public abstract class Validacion {
    
    public String validarString(final List<String> strings) throws ErrorValidacionException {
        return null;
    }
    
    public String validarValorRepetidoString(final List<String> strings, final List<String> repetidos) throws ErrorValidacionException {
        return null;
    }

    public void longitudString(String tipo, String aValidar, int minimo, int maximo) throws LongitudStringException
    {
        boolean result = aValidar.length() >= minimo && aValidar.length() <= maximo;
        if ( !result ) {
            throw new LongitudStringException(tipo, minimo, maximo);
        }
    }
    
    public void formatoAlfabeticoString(String tipo, String aValidar) throws FormatoAlfabeticoStringException 
    {
        Pattern patternNombre = Pattern.compile("[^A-Za-zñáéíóú ]");
        Matcher matcherNombre = patternNombre.matcher(aValidar);

	boolean esCadena = false;
	while (matcherNombre.find()) {
            esCadena = true;
	}
        
        if ( esCadena ) {
            throw new FormatoAlfabeticoStringException(tipo);
        }
    }
    
    public void formatoAlfanumericoString(String tipo, String aValidar) throws FormatoAlfanumericoStringException 
    {
        Pattern patternNombre = Pattern.compile("[^A-Za-zñáéíóú0123456789\n ]");
        Matcher matcherNombre = patternNombre.matcher(aValidar);

	boolean esCadena = false;
	while (matcherNombre.find()) {
            esCadena = true;
	}
        
	if ( esCadena ) {
            throw new FormatoAlfanumericoStringException(tipo);
        }
    }
    
    public void formatoNumericoDouble(String tipo, String aValidar) throws FormatoNumericoDoubleException {
	try {
            Double.parseDouble(aValidar);
	} catch (NumberFormatException NFE) {
            throw new FormatoNumericoDoubleException(tipo);
        }
    }
    
    public void formatoNumericoString(String tipo, String aValidar) throws FormatoNumericoStringException {
        Pattern patternNombre = Pattern.compile("[^0123456789 ]");
        Matcher matcherNombre = patternNombre.matcher(aValidar);

	boolean esCadena = false;
	while (matcherNombre.find()) {
            esCadena = true;
	}
        
	if ( esCadena ) {
            throw new FormatoNumericoStringException(tipo);
        }
    }    
    
    public void longitudLista(String tipo, String aValidar) throws LongitudListaException {
        if ( aValidar.equals("") )
        {
            throw new LongitudListaException(tipo);
        }
    }
    
    public void datoRepetido(String tipo, String nombre, List<String> repetidos) throws ErrorDatosRepetidosStringException {
        for(String s : repetidos) {
                if (s.equals(nombre))
                {
                    throw new ErrorDatosRepetidosStringException(tipo);
                }
            }
    }
    
    public void campoVacio(String tipo, String campo) throws CampoVacioException {
        if ( campo == null ) {
            throw new CampoVacioException(tipo);
        }
    }
    
    protected String crearErrorLongitudString(String tipo, int minimo, int maximo) 
    {
        return tipo + " debe tener una longitud mínima de " + minimo + " caracteres y "
                    + "máxima de " + maximo + ".";
    }
    
    protected String crearErrorFormatoAlfabeticoString(String tipo) 
    {
        return tipo + " debe contener únicamente valores alfabéticos.";
    }
    
    protected String crearErrorFormatoAlfanumericoString(String tipo) 
    {
        return tipo + " debe contener únicamente valores alfanúmericos.";
    }
    
    protected String crearErrorFormatoNumericoString(String tipo) 
    {
        return tipo + " debe contener únicamente valores numericos.";
    }
    
    protected String crearErrorFormatoDouble(String tipo) 
    {
        return tipo + " debe ser un valor numerico de tipo entero o decimal.";
    }
    
    protected String crearErrorLongitudLista(String tipo) 
    {
        return tipo + " debe poseer como minimo un registro en su lista.";
    }
    
    protected String crearErrorDatoRepetidoString(String tipo) 
    {
        return tipo + " ya existe en la lista. No se admiten valores repetidos.";
    }
    
    protected String crearCampoVacio(String tipo) 
    {
        return tipo + " no puede estar vacio.";
    }
}
