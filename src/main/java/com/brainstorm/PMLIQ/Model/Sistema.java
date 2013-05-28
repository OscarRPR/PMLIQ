/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model;

import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.dao.SingleDAO;
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
        cargarEquipos();
    }
    
    public void inicializaFabricantes() {
        fabricantes = new ArrayList<Fabricante>();
        cargarFabricantes();
    }
    
    public void inicializaInventario() {
        inventario = new ArrayList<Item>();
        cargarItems();
    }   
    
    public void agregarEquipo(Equipo equipo) {
        SingleDAO.getInstance().getEquipoDAO().save(equipo);
        cargarEquipos();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public void agregarItem(Item item) {
        SingleDAO.getInstance().getItemDAO().save(item);
        cargarItems();
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }
  
    public void agregarFabricante(Fabricante nuevoFabricante) {
        SingleDAO.getInstance().getFabricanteDAO().save(nuevoFabricante);
        cargarFabricantes();
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
    
    public Equipo getEquipo(String id) {
        for (Equipo equipo : equipos) {
            if (equipo.getPlacaInventario().equals(id)) {
                return equipo;
            }
        }
        
        return null;
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
    
    public void eliminarEquipo(String placa) {
        SingleDAO.getInstance().getEquipoDAO().findAndDelete(placa);
        cargarEquipos();
    }
    
    public void eliminarFabricante(String nombre) {
        SingleDAO.getInstance().getFabricanteDAO().findAndDelete(nombre);
        cargarFabricantes();
    }
    
    public void eliminarItem(String placa) {
        SingleDAO.getInstance().getItemDAO().findAndDelete(placa);
        cargarItems();
    }
    
    private void cargarEquipos() {
        equipos = SingleDAO.getInstance().getEquipoDAO().findAll();
    }
    
    private void cargarFabricantes() {
        fabricantes = SingleDAO.getInstance().getFabricanteDAO().findAll();
    }
    
    private void cargarItems() {
        inventario = SingleDAO.getInstance().getItemDAO().findAll();
    }
}
