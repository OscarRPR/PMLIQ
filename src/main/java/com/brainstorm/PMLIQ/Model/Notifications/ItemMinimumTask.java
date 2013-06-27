/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Notifications;

import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Silex RPR
 */
public class ItemMinimumTask extends TimerTask {
    
    private String nombre, placa;
    private int minimo;

    public ItemMinimumTask(String nombre, String placa, int minimo) {
        super();
        this.nombre = nombre;
        this.placa = placa;
        this.minimo = minimo;
    }

    @Override
    public void run() {
        
        Item item = PMLIApp.getInstance().getSistema().getItemByPlaca(placa);
        
        if(item.getCantidadInicial() > minimo) {
            PMLIApp.getInstance().getAdmNotificaciones().detenerAlarmaItemFull(item);
        }
        
        /*JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "El item " + nombre + " con placa " + placa + " tiene menos \n de " + minimo + " en el "
        + "inventario.", "Alerta Nivel de Inventario Bajo", JOptionPane.WARNING_MESSAGE);*/

    }   
}
