/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.actions;

import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.panel.modificarFabricantePanel;
import com.brainstorm.PMLIQ.View.panel.modificarItemInventarioPanel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class ModificarItemAction extends AbstractAction {

    private int id;
    private JPanel panel;
    private JTable listaTable;
    private DefaultTableModel model;
    
    public ModificarItemAction(String name, int id, JPanel panel, JTable table, DefaultTableModel model) {
        super(name);
        this.id = id;
        this.panel = panel;
        this.listaTable = table;
        this.model = model;
    }
    
    public void actionPerformed(ActionEvent e) {
        int selectedRow = listaTable.getSelectedRow();
        String idKey = (String) model.getValueAt(listaTable.convertRowIndexToModel(selectedRow), id);
        Item item = PMLIApp.getInstance().getSistema().getItemByPlaca(idKey);
        panel.setVisible(false);
        panel.removeAll();
        panel = new modificarItemInventarioPanel(item);

        PMLIApp.getInstance().getMainWindow().getAppTabPanel().setComponentAt(2, panel);
    } 
}
