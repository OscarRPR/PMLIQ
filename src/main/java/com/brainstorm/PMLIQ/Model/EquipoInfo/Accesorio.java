/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesAccesoriosEquipo;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Accesorio {
    
    private ConstantesAccesoriosEquipo vars = new ConstantesAccesoriosEquipo();

    public Accesorio(final List<String> accesorioEquipo) {
        this.cantidad = Integer.parseInt(accesorioEquipo.get(vars.CANTIDAD));
        this.nombre = accesorioEquipo.get(vars.NOMBRE);
        this.marca = accesorioEquipo.get(vars.MARCA);
        this.caracteristicas = accesorioEquipo.get(vars.CARACTERISTICAS);                                                                                                   
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
    private int cantidad;
    private String nombre, caracteristicas, marca;
}
