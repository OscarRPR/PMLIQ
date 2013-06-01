/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.adapters;

import com.brainstorm.PMLIQ.View.actions.ModificarFabricanteAction;
import com.brainstorm.PMLIQ.View.panel.list.fabricantesListaPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class FabricanteMouseAdapter extends MouseAdapter{
    
    private fabricantesListaPanel panel;
    private JTable listaTable;
    private DefaultTableModel fabricantesModel;
    private String tipo, accion;
    
    public FabricanteMouseAdapter(fabricantesListaPanel panel, JTable listaTable, DefaultTableModel fabricantesModel,
                                  String accion) {
        this.panel = panel;
        this.listaTable = listaTable;
        this.fabricantesModel = fabricantesModel;
        this.accion = accion;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
                    
            ModificarFabricanteAction modificar = new ModificarFabricanteAction(accion, 0, panel,
                                                                listaTable, fabricantesModel);
            modificar.actionPerformed(null);
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        int r = listaTable.rowAtPoint(e.getPoint());
        if (r >= 0 && r < listaTable.getRowCount()) {
            listaTable.setRowSelectionInterval(r, r);
        } else {
            listaTable.clearSelection();
        }

        int rowindex = listaTable.getSelectedRow();
        if (rowindex < 0)
            return;
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
            JPopupMenu popup = panel.createJPopupMenu();
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
