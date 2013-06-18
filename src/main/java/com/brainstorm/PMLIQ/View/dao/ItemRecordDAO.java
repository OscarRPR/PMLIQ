/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.dao;

import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.brainstorm.PMLIQ.Model.Record.ObjectRecord;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class ItemRecordDAO extends BasicDAO<ItemRecord, Integer> {

    public ItemRecordDAO(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }
    
    public List findAll()
    {
        return ds.find(ItemRecord.class).asList();
    }
    
    public List<ItemRecord> findById(String id) {
        List<ItemRecord> list = ds.find(ItemRecord.class).asList();
        List<ItemRecord> itemList = new ArrayList<ItemRecord>();

        for(ItemRecord i : list) {
            if(i.getId().equals(id)) {
                itemList.add(i);
            }
        }
        
        return itemList;
    }
    
    public void findAndDelete(String id) {
        ds.findAndDelete(createQuery().field("_id") .equal(id)); 
    }
    
    
}
