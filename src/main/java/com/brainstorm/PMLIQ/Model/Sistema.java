/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model;

import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Sistema {
    private List<Equipo> equipos;
    private List<Item> inventario;
    private List<Fabricante> fabricantes;
    
    public Sistema()
    {
    }
    
    public void inicializaEquipos() {
        equipos = new ArrayList<Equipo>();
    }
    
    public void inicializaFabricantes() {
        fabricantes = new ArrayList<Fabricante>();
    }
    
    public void inicializaInventario() {
        inventario = new ArrayList<Item>();
    }   
    
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public void agregarItem(Item item) {
        this.inventario.add(item);
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }
  
    public void agregarFabricante(Fabricante nuevoFabricante) {
        this.fabricantes.add(nuevoFabricante);
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
    
    public Item getItem(String nombre) {
        for (Item item : inventario) {
            if (item.getNombre().equals(nombre)) {
                return item;
            }
        }
        
        return null;
    }
    
    public Fabricante getFabricante(String nombre) {
        for (Fabricante f : fabricantes) {
            if (f.getNombre().equals(nombre)) {
                return f;
            }
        }
        
        return null;
    }
}
