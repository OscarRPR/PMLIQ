/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.dao;

import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.net.UnknownHostException;

/**
 *
 * @author Silex RPR
 */
public class SingleDAO {
    private Mongo mongo = null;
    private Morphia morphia = null;
    private String dbName = "PMLIQ";
    
    private FabricanteDAO fabricanteDAO;
    private ItemDAO itemDAO;
    private EquipoDAO equipoDAO;

    public SingleDAO() {
        
        mongo = null;
        try {
            mongo = new Mongo("localhost", 27017);
        } catch(UnknownHostException e){
            e.getMessage();
        }
        
        morphia = new Morphia();
        morphia.map(Fabricante.class);
        
        fabricanteDAO = new FabricanteDAO(mongo, morphia, dbName);
        itemDAO = new ItemDAO(mongo, morphia, dbName);
        equipoDAO = new EquipoDAO(mongo, morphia, dbName);
    }

    public FabricanteDAO getFabricanteDAO() {
        return fabricanteDAO;
    }

    public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
        this.fabricanteDAO = fabricanteDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public EquipoDAO getEquipoDAO() {
        return equipoDAO;
    }

    public void setEquipoDAO(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }
    
    public synchronized static SingleDAO getInstance() {
		while (m_this == null) {
			m_this = new SingleDAO();
		}
		return m_this;
    }
    
    private static SingleDAO m_this;  
}
