/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Record;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.util.Date;

/**
 *
 * @author Silex RPR
 */

@Entity
public class ItemRecord extends ObjectRecord {
    
    @Id
    protected String id;

    public ItemRecord() {
        
    }
    
    public ItemRecord(String id, String action, String responsable) {
        this.id = id;
        this.action = action;
        this.responsable = responsable;
        this.date = new Date();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     
    
}
