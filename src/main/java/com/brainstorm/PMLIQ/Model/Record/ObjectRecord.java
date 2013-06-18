/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Record;

import java.util.Date;

/**
 *
 * @author Silex RPR
 */
public abstract class ObjectRecord {
    
    protected String action;
    protected String responsable;
    protected Date date;

    public ObjectRecord() {
        
    }
    
    public ObjectRecord(String action, String responsable) {
        this.action = action;
        this.responsable = responsable;
        this.date = new Date();
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
