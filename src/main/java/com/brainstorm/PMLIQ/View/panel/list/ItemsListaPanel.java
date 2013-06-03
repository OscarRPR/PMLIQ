/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.panel.list;

import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.actions.EliminarAction;
import com.brainstorm.PMLIQ.View.actions.ModificarItemAction;
import com.brainstorm.PMLIQ.View.adapters.ItemMouseAdapter;
import com.brainstorm.PMLIQ.View.panel.crearItemInventarioPanel;
import com.brainstorm.PMLIQ.View.panel.modificarItemInventarioPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class ItemsListaPanel extends javax.swing.JPanel implements ListaPanel{

    /**
     * Creates new form ItemsListaPanel
     */
    public ItemsListaPanel() {
        initComponents();
        
        listaTable.setModel(itemsModel);
        listaTable.setColumnSelectionAllowed(false);
        listaTable.setRowSelectionAllowed(true);

        itemsModel.addColumn("Nombre");
        itemsModel.addColumn("Placa de Inventario");
        itemsModel.addColumn("Cantidad Disponible");
        itemsModel.addColumn("Fabricante");
        
        listaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listaTable.addMouseListener(new ItemMouseAdapter(this, listaTable, itemsModel, "Modificar"));
        
        updateListModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventarioPanel = new javax.swing.JPanel();
        buscarInventarioPanel = new javax.swing.JPanel();
        buscarInternalPanel1 = new javax.swing.JPanel();
        filtroComboBox1 = new javax.swing.JComboBox();
        buscarTextField1 = new javax.swing.JTextField();
        separadorLabel1 = new javax.swing.JLabel();
        accionesPanel1 = new javax.swing.JPanel();
        nuevoItemButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTable = new javax.swing.JTable();

        buscarInternalPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

        filtroComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Placa", "Fabricante" }));

        buscarTextField1.setForeground(new java.awt.Color(255, 153, 0));
        buscarTextField1.setText("Buscar");
        buscarTextField1.setDisabledTextColor(new java.awt.Color(255, 204, 0));

        separadorLabel1.setText(" :");

        javax.swing.GroupLayout buscarInternalPanel1Layout = new javax.swing.GroupLayout(buscarInternalPanel1);
        buscarInternalPanel1.setLayout(buscarInternalPanel1Layout);
        buscarInternalPanel1Layout.setHorizontalGroup(
            buscarInternalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInternalPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        buscarInternalPanel1Layout.setVerticalGroup(
            buscarInternalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarInternalPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buscarInternalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorLabel1))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout buscarInventarioPanelLayout = new javax.swing.GroupLayout(buscarInventarioPanel);
        buscarInventarioPanel.setLayout(buscarInventarioPanelLayout);
        buscarInventarioPanelLayout.setHorizontalGroup(
            buscarInventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInventarioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarInternalPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buscarInventarioPanelLayout.setVerticalGroup(
            buscarInventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInventarioPanelLayout.createSequentialGroup()
                .addComponent(buscarInternalPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        nuevoItemButton.setText("Nuevo");
        nuevoItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoItemButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accionesPanel1Layout = new javax.swing.GroupLayout(accionesPanel1);
        accionesPanel1.setLayout(accionesPanel1Layout);
        accionesPanel1Layout.setHorizontalGroup(
            accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(nuevoItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        accionesPanel1Layout.setVerticalGroup(
            accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel1Layout.createSequentialGroup()
                .addGroup(accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevoItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaTable.setRowSelectionAllowed(false);
        listaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listaTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(listaTable);

        javax.swing.GroupLayout inventarioPanelLayout = new javax.swing.GroupLayout(inventarioPanel);
        inventarioPanel.setLayout(inventarioPanelLayout);
        inventarioPanelLayout.setHorizontalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventarioPanelLayout.createSequentialGroup()
                        .addComponent(buscarInventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accionesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        inventarioPanelLayout.setVerticalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarInventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inventarioPanelLayout.createSequentialGroup()
                        .addComponent(accionesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(inventarioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventarioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoItemButtonActionPerformed
        inventarioPanel.setVisible(false);
        inventarioPanel.removeAll();
        inventarioPanel = new crearItemInventarioPanel(PMLIApp.getInstance().getSistema().getInventario());
        
        PMLIApp.getInstance().getMainWindow().getAppTabPanel().setComponentAt(2, inventarioPanel);
    }//GEN-LAST:event_nuevoItemButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        EliminarAction eliminar = new EliminarAction("Eliminar", 1, "Item", this, 
                                                      listaTable, itemsModel);
        eliminar.actionPerformed(evt);
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void listaTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_listaTableMouseReleased

    public final void updateListModel() {
        
        if (itemsModel.getRowCount() > 0) {
            for (int i = itemsModel.getRowCount() - 1; i > -1; i--) {
                itemsModel.removeRow(i);
            }
        }
        
        List<Item> listaItems = PMLIApp.getInstance().getSistema().getInventario();

        for(Item i : listaItems) {
            itemsModel.addRow(new Object[] { i.getNombre(), i.getPlacaInventario(), i.getCantidadInicial(), i.getFabricante()} );
        }
        
        listaTable.setModel(itemsModel);
    }
    
    public JPopupMenu createJPopupMenu() {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem modificar = new JMenuItem(new ModificarItemAction("Modificar", 1, this,
                                                                listaTable, itemsModel));
        JMenuItem eliminar = new JMenuItem(new EliminarAction("Eliminar", 1, "Item", this, 
                                                               listaTable, itemsModel));
        
        JMenuItem verHistorial = new JMenuItem("Ver Historial");
        
        menu.add(modificar);
        menu.add(eliminar);
        menu.addSeparator();
        menu.add(verHistorial);
        return menu;
    }
    
    private DefaultTableModel itemsModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accionesPanel1;
    private javax.swing.JPanel buscarInternalPanel1;
    private javax.swing.JPanel buscarInventarioPanel;
    private javax.swing.JTextField buscarTextField1;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JComboBox filtroComboBox1;
    private javax.swing.JPanel inventarioPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaTable;
    private javax.swing.JButton nuevoItemButton;
    private javax.swing.JLabel separadorLabel1;
    // End of variables declaration//GEN-END:variables
}
