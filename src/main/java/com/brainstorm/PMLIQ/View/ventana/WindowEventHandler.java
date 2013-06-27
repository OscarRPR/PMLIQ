/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.ventana;

import com.brainstorm.PMLIQ.Control.AdministrarNotificaciones;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Silex RPR
 */
public class WindowEventHandler extends WindowAdapter {
    
    @Override
    public void windowClosing(WindowEvent evt) {
       PMLIApp.getInstance().getAdmNotificaciones().detenerAlarmaItems();
    }

}
