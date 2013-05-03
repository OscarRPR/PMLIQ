/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Fabricante;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesFabricantes;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Fabricante {

    private ConstantesFabricantes vars = new ConstantesFabricantes();
    
    public Fabricante(List<String> datos) {
        this.nombre = datos.get(vars.NOMBRE);
        this.informacion = datos.get(vars.INFORMACION);
        this.contacto = datos.get(vars.CONTACTO);
        this.direccion = datos.get(vars.DIRECCION);
        this.telefonoUno = datos.get(vars.TELEFONOUNO);
        this.telefonoDos = datos.get(vars.TELEFONODOS);
        this.correo = datos.get(vars.CORREO);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
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

    public String getTelefonoUno() {
        return telefonoUno;
    }

    public void setTelefonoUno(String telefonoUno) {
        this.telefonoUno = telefonoUno;
    }

    public String getTelefonoDos() {
        return telefonoDos;
    }

    public void setTelefonoDos(String telefonoDos) {
        this.telefonoDos = telefonoDos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    private String nombre, informacion, contacto, direccion;
    private String telefonoUno, telefonoDos, correo;       
}
