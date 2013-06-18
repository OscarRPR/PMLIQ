/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model;

import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.brainstorm.PMLIQ.Model.Record.ObjectRecord;
import com.brainstorm.PMLIQ.View.dao.SingleDAO;
import java.io.File;
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
    
    private List<ObjectRecord> recordItems = new ArrayList<ObjectRecord>();
    
    public Sistema()
    {
        new File("Data/CV/").mkdirs();
        new File("Data/Planes/").mkdirs();
        new File("Data/Historiales Items/").mkdirs();
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
    
    public void actualizarHistorialItem(String id, String action, String responsable) {
        SingleDAO.getInstance().getItemRecordDAO().save(new ItemRecord(id, action, responsable));
    }
    
    public List<ItemRecord> getItemsRecordsById(String id) {
       return SingleDAO.getInstance().getItemRecordDAO().findById(id);
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
    
    public Item getItemByPlaca(String placa) {
        for (Item item : inventario) {
            if (item.getPlacaInventario().equals(placa)) {
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
    
    public void actualizarItem(Item item, Integer cantidadConsumida) {
        item.setCantidadInicial(cantidadConsumida);
        SingleDAO.getInstance().getItemDAO().save(item);
    }
    
    public void eliminar(String id, String tipo) {
        if (tipo.equals("Equipo")) {
            eliminarEquipo(id);
        }
        else if (tipo.equals("Item")) {
            eliminarItem(id);
        }
        else if (tipo.equals("Fabricante")) {
            eliminarFabricante(id);
        }
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

    public List<ObjectRecord> getRecordItems() {
        return recordItems;
    }

    public void setRecordItems(List<ObjectRecord> recordItems) {
        this.recordItems = recordItems;
    }
}
