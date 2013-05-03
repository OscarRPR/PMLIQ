/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.panel.list;

import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.panel.crearFabricantePanel;
import com.brainstorm.PMLIQ.View.panel.crearItemInventarioPanel;

/**
 *
 * @author Silex RPR
 */
public class ItemsListaPanel extends javax.swing.JPanel {

    /**
     * Creates new form ItemsListaPanel
     */
    public ItemsListaPanel() {
        initComponents();
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
        verCVPDFButton1 = new javax.swing.JButton();
        listaScrollPanel1 = new javax.swing.JScrollPane();
        listaEquiposList1 = new javax.swing.JList();

        buscarInternalPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

        filtroComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        verCVPDFButton1.setText("Ver Historial");
        verCVPDFButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCVPDFButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accionesPanel1Layout = new javax.swing.GroupLayout(accionesPanel1);
        accionesPanel1.setLayout(accionesPanel1Layout);
        accionesPanel1Layout.setHorizontalGroup(
            accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nuevoItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verCVPDFButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        accionesPanel1Layout.setVerticalGroup(
            accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verCVPDFButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaScrollPanel1.setViewportView(listaEquiposList1);

        javax.swing.GroupLayout inventarioPanelLayout = new javax.swing.GroupLayout(inventarioPanel);
        inventarioPanel.setLayout(inventarioPanelLayout);
        inventarioPanelLayout.setHorizontalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inventarioPanelLayout.createSequentialGroup()
                        .addComponent(buscarInventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accionesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(listaScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        inventarioPanelLayout.setVerticalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioPanelLayout.createSequentialGroup()
                .addGroup(inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventarioPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buscarInventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(accionesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(inventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(inventarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoItemButtonActionPerformed
        inventarioPanel.setVisible(false);
        inventarioPanel.removeAll();
        inventarioPanel = new crearItemInventarioPanel(PMLIApp.getInstance().getSistema().getInventario());
        
        PMLIApp.getInstance().getMainWindow().getAppTabPanel().setComponentAt(2, inventarioPanel);
    }//GEN-LAST:event_nuevoItemButtonActionPerformed

    private void verCVPDFButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCVPDFButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verCVPDFButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accionesPanel1;
    private javax.swing.JPanel buscarInternalPanel1;
    private javax.swing.JPanel buscarInventarioPanel;
    private javax.swing.JTextField buscarTextField1;
    private javax.swing.JComboBox filtroComboBox1;
    private javax.swing.JPanel inventarioPanel;
    private javax.swing.JList listaEquiposList1;
    private javax.swing.JScrollPane listaScrollPanel1;
    private javax.swing.JButton nuevoItemButton;
    private javax.swing.JLabel separadorLabel1;
    private javax.swing.JButton verCVPDFButton1;
    // End of variables declaration//GEN-END:variables
}
