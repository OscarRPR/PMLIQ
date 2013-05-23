/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.panel.list;

import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.panel.crearEquipoPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class EquiposListaPanel extends javax.swing.JPanel {

    /**
     * Creates new form EquiposListaPanel
     */
    public EquiposListaPanel() {
        initComponents();
        
        listaTable.setModel(equiposModel);
        listaTable.setColumnSelectionAllowed(false);
        listaTable.setRowSelectionAllowed(true);

        equiposModel.addColumn("Nombre");
        equiposModel.addColumn("Placa de Inventario");
        equiposModel.addColumn("Tipo de Equipo");
        equiposModel.addColumn("Uso de Equipo");
        equiposModel.addColumn("Ubicación");
        
        listaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
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

        hojasPanel = new javax.swing.JPanel();
        buscarPanel = new javax.swing.JPanel();
        buscarInternalPanel = new javax.swing.JPanel();
        filtroComboBox = new javax.swing.JComboBox();
        buscarTextField = new javax.swing.JTextField();
        separadorLabel = new javax.swing.JLabel();
        accionesPanel = new javax.swing.JPanel();
        nuevoEquipoButton = new javax.swing.JButton();
        verCVPDFButton = new javax.swing.JButton();
        verCVPDFButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTable = new javax.swing.JTable();

        hojasPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        buscarInternalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

        filtroComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buscarTextField.setForeground(new java.awt.Color(255, 153, 0));
        buscarTextField.setText("Buscar");
        buscarTextField.setDisabledTextColor(new java.awt.Color(255, 204, 0));

        separadorLabel.setText(" :");

        javax.swing.GroupLayout buscarInternalPanelLayout = new javax.swing.GroupLayout(buscarInternalPanel);
        buscarInternalPanel.setLayout(buscarInternalPanelLayout);
        buscarInternalPanelLayout.setHorizontalGroup(
            buscarInternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInternalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        buscarInternalPanelLayout.setVerticalGroup(
            buscarInternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarInternalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buscarInternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorLabel))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout buscarPanelLayout = new javax.swing.GroupLayout(buscarPanel);
        buscarPanel.setLayout(buscarPanelLayout);
        buscarPanelLayout.setHorizontalGroup(
            buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarInternalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buscarPanelLayout.setVerticalGroup(
            buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscarInternalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        nuevoEquipoButton.setText("Nuevo");
        nuevoEquipoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEquipoButtonActionPerformed(evt);
            }
        });

        verCVPDFButton.setText("Ver En PDF");
        verCVPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCVPDFButtonActionPerformed(evt);
            }
        });

        verCVPDFButton2.setText("Ver Historial Mantenimiento");

        javax.swing.GroupLayout accionesPanelLayout = new javax.swing.GroupLayout(accionesPanel);
        accionesPanel.setLayout(accionesPanelLayout);
        accionesPanelLayout.setHorizontalGroup(
            accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoEquipoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verCVPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verCVPDFButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accionesPanelLayout.setVerticalGroup(
            accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verCVPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevoEquipoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verCVPDFButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaTable.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(listaTable);

        javax.swing.GroupLayout hojasPanelLayout = new javax.swing.GroupLayout(hojasPanel);
        hojasPanel.setLayout(hojasPanelLayout);
        hojasPanelLayout.setHorizontalGroup(
            hojasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hojasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hojasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hojasPanelLayout.createSequentialGroup()
                        .addComponent(buscarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        hojasPanelLayout.setVerticalGroup(
            hojasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hojasPanelLayout.createSequentialGroup()
                .addGroup(hojasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(hojasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(hojasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoEquipoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEquipoButtonActionPerformed
        hojasPanel.setVisible(false);
        hojasPanel.removeAll();
        hojasPanel = new crearEquipoPanel();

        PMLIApp.getInstance().getMainWindow().getAppTabPanel().setComponentAt(1, hojasPanel);
    }//GEN-LAST:event_nuevoEquipoButtonActionPerformed

    private void verCVPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCVPDFButtonActionPerformed
        int selectedRow = listaTable.getSelectedRow();
        String nombre = (String) equiposModel.getValueAt(listaTable.convertRowIndexToModel(selectedRow), 0);
        Equipo equipoSeleccionado = PMLIApp.getInstance().getSistema().getEquipo(nombre);
        
        PMLIApp.getInstance().getAdmEquipos().crearCVPDF(equipoSeleccionado, "D:/test.pdf");
        
        if (Desktop.isDesktopSupported()) {
           if ( JOptionPane.showConfirmDialog(PMLIApp.getInstance().getMainWindow(), "     La hoja de vida del equipo se genero correctamente.\n"
                   + "¿Desea abrir la hoja de vida generada en su lector de PDF?" , "Lectura Hoja de Vida",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
           {
                File archivoPDF = new File("D:/test.pdf");
               try {
                   Desktop.getDesktop().open(archivoPDF);
               } catch (IOException ex) {
                   Logger.getLogger(EquiposListaPanel.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       } else
       {
          JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "La hoja de vida se genero correctamente y se encuentra en PDF. \n"
                    + "en la carpeta del programa.", "Error Lector PDF", JOptionPane.INFORMATION_MESSAGE);
       }

    }//GEN-LAST:event_verCVPDFButtonActionPerformed

    private void updateListModel() {
        
        if (equiposModel.getRowCount() > 0) {
            for (int i = equiposModel.getRowCount() - 1; i > -1; i--) {
                equiposModel.removeRow(i);
            }
        }
        
        List<Equipo> listaEquipos = PMLIApp.getInstance().getSistema().getEquipos();

        for(Equipo e : listaEquipos) {
            equiposModel.addRow(new Object[] {e.getNombre(), e.getPlacaInventario(), e.getTipoEquipo().toString(),
                                              e.getUsoEquipo().toString(), e.getUbicacionEnLaboratorio()});
        }

        listaTable.setModel(equiposModel);
    }
    
    private DefaultTableModel equiposModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accionesPanel;
    private javax.swing.JPanel buscarInternalPanel;
    private javax.swing.JPanel buscarPanel;
    private javax.swing.JTextField buscarTextField;
    private javax.swing.JComboBox filtroComboBox;
    private javax.swing.JPanel hojasPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaTable;
    private javax.swing.JButton nuevoEquipoButton;
    private javax.swing.JLabel separadorLabel;
    private javax.swing.JButton verCVPDFButton;
    private javax.swing.JButton verCVPDFButton2;
    // End of variables declaration//GEN-END:variables
}
