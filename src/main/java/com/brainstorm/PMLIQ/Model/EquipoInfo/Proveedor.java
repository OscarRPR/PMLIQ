/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesAdquisicionEquipo;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Proveedor {
    
    private ConstantesAdquisicionEquipo vars = new ConstantesAdquisicionEquipo();
    
    public Proveedor(List<String> datos) {
        this.fabricante = datos.get(vars.FABRICANTE);
        this.proveedor = datos.get(vars.PROVEEDOR);
        this.NIT = datos.get(vars.NIT);
        this.contacto = datos.get(vars.CONTACTO);
        this.telefono = datos.get(vars.TELEFONO);
        this.direccion = datos.get(vars.DIRECCION);
        this.email = datos.get(vars.EMAIL);
        
        formaAdquisicion = new FormaAdquisicion(datos.get(vars.TIPO), 
                                                datos.get(vars.PRECIO), 
                                                datos.get(vars.USO), 
                                                datos.get(vars.ADQUISICION), 
                                                datos.get(vars.SERVICIO),
                                                datos.get(vars.VIDAESTIMADA) );
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FormaAdquisicion getFormaAdquisicion() {
        return formaAdquisicion;
    }

    public void setFormaAdquisicion(FormaAdquisicion formaAdquisicion) {
        this.formaAdquisicion = formaAdquisicion;
    }
    
    String fabricante, proveedor, contacto, direccion, NIT, telefono, email;
    FormaAdquisicion formaAdquisicion;
}
