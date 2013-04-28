/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control.Constantes;

/**
 *
 * @author Silex RPR
 */
public class ConstantesAdquisicionEquipo {
    public final String fabricante = "Fabricante";
    public final int minFabricante = 3, maxFabricante = 45;
    public final int FABRICANTE = 0;
    
    public final String proveedor = "Proveedor";
    public final int minProveedor = 3, maxProveedor = 30;
    public final int PROVEEDOR = 1;
      
    public final String nit = "NIT";
    public final int minNit = 3, maxNit = 20;
    public final int NIT = 2;
    
    public final String contacto = "Contacto";
    public final int minContacto = 10, maxContacto = 35;
    public final int CONTACTO = 3;
    
    public final String telefono = "Telefono";
    public final int minTelefono = 7, maxTelefono = 12;
    public final int TELEFONO = 4;
    
    public final String direccion = "Direccion";
    public final int minDireccion = 10, maxDireccion = 30;
    public final int DIRECCION = 5;   

    public final String email = "Email";
    public final int minEmail = 10, maxEmail = 30;
    public final int EMAIL = 6; 

    public final int TIPO = 7; 
  
    public final String precio = "Precio";
    public final int minPrecio = 1, maxPrecio = 20;
    public final int PRECIO = 8; 
    
    public final int USO = 9;

    public final int ADQUISICION = 10;
    
    public final int SERVICIO = 11;
    
    public final int VIDAESTIMADA = 12;

    public ConstantesAdquisicionEquipo()
    {
    }        
}
