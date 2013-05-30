/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.actions;

import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.panel.list.ListaPanel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class EliminarAction extends AbstractAction {

    private String tipo;
    private int id;
    private ListaPanel panel;
    private JTable listaTable;
    private DefaultTableModel model;
    
    public EliminarAction(String name, int id, String tipo, ListaPanel panel, JTable table, DefaultTableModel model) {
        super(name);
        this.tipo = tipo;
        this.id = id;
        this.panel = panel;
        this.listaTable = table;
        this.model = model;
    }
    
    public void actionPerformed(ActionEvent e) {
        int selectedRow = listaTable.getSelectedRow();
        if (selectedRow != -1) {
            String idKey = (String) model.getValueAt(listaTable.convertRowIndexToModel(selectedRow), id);
            PMLIApp.getInstance().getSistema().eliminar(idKey, tipo);
            panel.updateListModel();
            
        } else {
              JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "No esta seleccionado ningun fabricante para eliminar.", 
                                    "Error Al Eliminar Fabricante", JOptionPane.ERROR_MESSAGE);
        }
    }
}
