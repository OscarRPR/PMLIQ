/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Actions;

import com.brainstorm.PMLIQ.Model.Enum.ItemAction;
import com.brainstorm.PMLIQ.Model.Inventario.Item;

/**
 *
 * @author Silex RPR
 */
public class ItemActionMessages {
    
    public String getMessage(Item item, int action) {
        switch(action) {
            case 0: {
                return createItemLog();
            }
                
            
        }
        
        return null;
        
    }
    
    private String createItemLog() {
        return "Ingreso del nuevo item al inventario";
    }
}
