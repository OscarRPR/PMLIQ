/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.actions;

import com.brainstorm.PMLIQ.Control.PDF.PDFPlanes;
import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.dialogs.SeleccionarPlan;
import com.brainstorm.PMLIQ.View.panel.list.EquiposListaPanel;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class SeleccionarPlanAction extends AbstractAction {

    private JTable listaTable;
    private DefaultTableModel equiposModel;
    
    public SeleccionarPlanAction(String name, JTable table, DefaultTableModel model) {
        super(name);
        this.listaTable = table;
        this.equiposModel = model;
    }
    
    public void actionPerformed(ActionEvent e) {
        
       int selectedRow = listaTable.getSelectedRow();
        
        if (selectedRow != -1) {
            String placa = (String) equiposModel.getValueAt(listaTable.convertRowIndexToModel(selectedRow), 1);
            Equipo equipoSeleccionado = PMLIApp.getInstance().getSistema().getEquipo(placa);

            SeleccionarPlan seleccionarPlan = new SeleccionarPlan(PMLIApp.getInstance().getMainWindow(),
                                                             true, equipoSeleccionado.getPlanes());
            seleccionarPlan.setLocationRelativeTo(null);
            seleccionarPlan.setVisible(true);
        }
    }
    
    
}
