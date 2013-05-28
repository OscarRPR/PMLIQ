/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.dao;

import com.brainstorm.PMLIQ.Model.Equipo;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class EquipoDAO extends BasicDAO<Equipo, Integer> {

    public EquipoDAO(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }
    
    public List findAll()
    {
        return ds.find(Equipo.class).asList();
    }
    
    public void findAndDelete(String id) {
        ds.findAndDelete(createQuery().field("_id") .equal(id)); 
    }
    
}
