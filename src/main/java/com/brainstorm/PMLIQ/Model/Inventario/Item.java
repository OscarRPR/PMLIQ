/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Inventario;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesItems;
import com.brainstorm.PMLIQ.Model.Enum.TimeStamp;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.util.List;

/**
 *
 * @author Silex RPR
 */

@Entity
public class Item {
    
    @Id
    private String placaInventario;
    
    private String nombre, fabricante;
    private int cantidadInicial;    
    private int cantidadMinima, tiempoMaximo;
    private TimeStamp tiempoMaximoTipo, frecuenciaMinimaTipo, frecuenciaMaximaTipo;
    private int frecuenciaMinima, frecuenciaMaxima;
    
    private ConstantesItems vars = new ConstantesItems();
   
    public Item() {
    }
    
    public Item(List<String> datos) {
        this.nombre = datos.get(vars.NOMBRE);
        this.placaInventario = datos.get(vars.PLACA);
        this.fabricante = datos.get(vars.FABRICANTE);
        this.cantidadInicial = Integer.parseInt(datos.get(vars.CANTIDADINICIAL));
        this.cantidadMinima = Integer.parseInt(datos.get(vars.CANTIDADMINIMA));
        this.frecuenciaMinima = Integer.parseInt(datos.get(vars.FRECUENCIAMINIMA));
        this.frecuenciaMinimaTipo = TimeStamp.valueOf(datos.get(vars.FRECUENCIAMINIMATIPO));
        this.tiempoMaximo = Integer.parseInt(datos.get(vars.CANTIDADMAXIMA));
        this.tiempoMaximoTipo = TimeStamp.valueOf(datos.get(vars.CANTIDADMAXIMATIPO));
        this.frecuenciaMaxima = Integer.parseInt(datos.get(vars.FRECUENCIAMAXIMA));
        this.frecuenciaMaximaTipo = TimeStamp.valueOf(datos.get(vars.FRECUENCIAMAXIMATIPO));
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlacaInventario() {
        return placaInventario;
    }

    public void setPlacaInventario(String placaInventario) {
        this.placaInventario = placaInventario;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public TimeStamp getTiempoMaximoTipo() {
        return tiempoMaximoTipo;
    }

    public void setTiempoMaximoTipo(TimeStamp tiempoMaximoTipo) {
        this.tiempoMaximoTipo = tiempoMaximoTipo;
    }

    public TimeStamp getFrecuenciaMinimaTipo() {
        return frecuenciaMinimaTipo;
    }

    public void setFrecuenciaMinimaTipo(TimeStamp frecuenciaMinimaTipo) {
        this.frecuenciaMinimaTipo = frecuenciaMinimaTipo;
    }

    public TimeStamp getFrecuenciaMaximaTipo() {
        return frecuenciaMaximaTipo;
    }

    public void setFrecuenciaMaximaTipo(TimeStamp frecuenciaMaximaTipo) {
        this.frecuenciaMaximaTipo = frecuenciaMaximaTipo;
    }

    public int getFrecuenciaMinima() {
        return frecuenciaMinima;
    }

    public void setFrecuenciaMinima(int frecuenciaMinima) {
        this.frecuenciaMinima = frecuenciaMinima;
    }

    public int getFrecuenciaMaxima() {
        return frecuenciaMaxima;
    }

    public void setFrecuenciaMaxima(int frecuenciaMaxima) {
        this.frecuenciaMaxima = frecuenciaMaxima;
    }
}
