/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.panel;

import com.brainstorm.PMLIQ.View.panel.list.fabricantesListaPanel;
import com.brainstorm.PMLIQ.Model.Fabricante.Fabricante;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.dialogs.ObtenerInformacionFabricante;
import com.brainstorm.PMLIQ.View.panel.list.ItemsListaPanel;
import static com.brainstorm.PMLIQ.View.ventana.MainWindow.ITEMSTAB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class crearItemInventarioPanel extends javax.swing.JPanel {

    private final int DESCRIPCIONBASICA = 0;
    
    /**
     * Creates new form crearItemInventarioPanel
     */
    public crearItemInventarioPanel(List<Item> items) {
        initComponents();
        
        this.items = items;
        
        fillManufacturersComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creacionItemTabPanel = new javax.swing.JTabbedPane();
        descripcionBasicaScrollPane1 = new javax.swing.JScrollPane();
        descripcionBasicaPanel1 = new javax.swing.JPanel();
        tituloPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        descripcionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        placaTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        informacionFabricanteButton = new javax.swing.JButton();
        fabricantesComboBox = new javax.swing.JComboBox();
        inicialSpinner = new javax.swing.JSpinner();
        guardarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        notificacionesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        minimaSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tiempoMaximoTipoComboBox = new javax.swing.JComboBox();
        tiempoMaximoSpinner = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        frecuenciaMinimaSpinner = new javax.swing.JSpinner();
        frecuenciaMaximaSpinner = new javax.swing.JSpinner();
        frecuenciaMinimaTipoComboBox = new javax.swing.JComboBox();
        frecuenciaMaximaTipoComboBox = new javax.swing.JComboBox();
        errorLabel = new javax.swing.JLabel();

        jLabel4.setText("CREANDO UN NUEVO ITEM PARA INVENTARIO");

        javax.swing.GroupLayout tituloPanel3Layout = new javax.swing.GroupLayout(tituloPanel3);
        tituloPanel3.setLayout(tituloPanel3Layout);
        tituloPanel3Layout.setHorizontalGroup(
            tituloPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel3Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel4)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        tituloPanel3Layout.setVerticalGroup(
            tituloPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        descripcionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción Básica"));

        jLabel5.setText("Nombre");

        nombreTextField.setText("wwwwwwwww");
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Placa De Inventario");

        placaTextField.setText("aaaaaaaaa");

        jLabel6.setText("Fabricante");

        jLabel7.setText("Cantidad Inicial");

        informacionFabricanteButton.setText("jButton1");
        informacionFabricanteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionFabricanteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fabricantesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(informacionFabricanteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicialSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(placaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(informacionFabricanteButton)
                    .addComponent(fabricantesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(inicialSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout descripcionPanelLayout = new javax.swing.GroupLayout(descripcionPanel);
        descripcionPanel.setLayout(descripcionPanelLayout);
        descripcionPanelLayout.setHorizontalGroup(
            descripcionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        descripcionPanelLayout.setVerticalGroup(
            descripcionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        guardarBoton.setText("Guardar");
        guardarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotonActionPerformed(evt);
            }
        });

        cancelarBoton.setText("Cancelar");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        notificacionesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Notificaciones/Alarmas"));

        jLabel1.setText("Cantidad Minima Permitida por Item");

        jLabel2.setText("Frecuencia de la Alarma");

        jLabel8.setText("Tiempo Maximo de Item en Inventario");

        tiempoMaximoTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horas", "Dias", "Semanas", "Meses", "Años" }));

        jLabel9.setText("Frecuencia de la Alarma");

        frecuenciaMinimaTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horas", "Dias", "Semanas", "Meses", "Años" }));

        frecuenciaMaximaTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horas", "Dias", "Semanas", "Meses", "Años" }));

        javax.swing.GroupLayout notificacionesPanelLayout = new javax.swing.GroupLayout(notificacionesPanel);
        notificacionesPanel.setLayout(notificacionesPanelLayout);
        notificacionesPanelLayout.setHorizontalGroup(
            notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tiempoMaximoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificacionesPanelLayout.createSequentialGroup()
                        .addComponent(tiempoMaximoTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notificacionesPanelLayout.createSequentialGroup()
                        .addComponent(frecuenciaMaximaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frecuenciaMaximaTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(notificacionesPanelLayout.createSequentialGroup()
                        .addComponent(frecuenciaMinimaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frecuenciaMinimaTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        notificacionesPanelLayout.setVerticalGroup(
            notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(minimaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(frecuenciaMinimaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frecuenciaMinimaTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(notificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tiempoMaximoTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoMaximoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(frecuenciaMaximaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frecuenciaMaximaTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        errorLabel.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout descripcionBasicaPanel1Layout = new javax.swing.GroupLayout(descripcionBasicaPanel1);
        descripcionBasicaPanel1.setLayout(descripcionBasicaPanel1Layout);
        descripcionBasicaPanel1Layout.setHorizontalGroup(
            descripcionBasicaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionBasicaPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(descripcionBasicaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(descripcionBasicaPanel1Layout.createSequentialGroup()
                        .addComponent(guardarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tituloPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notificacionesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descripcionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        descripcionBasicaPanel1Layout.setVerticalGroup(
            descripcionBasicaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionBasicaPanel1Layout.createSequentialGroup()
                .addComponent(tituloPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notificacionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(descripcionBasicaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        descripcionBasicaScrollPane1.setViewportView(descripcionBasicaPanel1);

        creacionItemTabPanel.addTab("Descripción Básica", descripcionBasicaScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creacionItemTabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creacionItemTabPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void informacionFabricanteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionFabricanteButtonActionPerformed
        ObtenerInformacionFabricante infoFabricante = new ObtenerInformacionFabricante(PMLIApp.getInstance().getMainWindow(), true,
                                                                                       fabricantesComboBox.getSelectedItem().toString());
        
        infoFabricante.setLocationRelativeTo(null);
        infoFabricante.setVisible(true);
    }//GEN-LAST:event_informacionFabricanteButtonActionPerformed

    private void guardarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotonActionPerformed
        List<String> infoItem = getDatosItem();
        List<String> nombresItems = getNombresItems();
 
        List<String> resultados = PMLIApp.getInstance().getAdmItems().crearItem(infoItem, nombresItems);
        errorLabel.setText(resultados.get(DESCRIPCIONBASICA));

        for (String s : resultados) {
            if (s.equals("")) {
                disposePanel();
                break;
            }
        }
    }//GEN-LAST:event_guardarBotonActionPerformed

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarBotonActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void disposePanel() {
        setVisible(false);
        removeAll();
        PMLIApp.getInstance().getMainWindow().getAppTabPanel().setComponentAt(ITEMSTAB, new ItemsListaPanel());
    }
    
    private void fillManufacturersComboBox() {
        List<Fabricante> fabricantes = PMLIApp.getInstance().getSistema().getFabricantes();

        for (Fabricante f : fabricantes) {
            fabricantesComboBox.addItem(f.getNombre());
        }

    }
    
    private  List<String> getNombresItems() {
        List<String> nombres = new ArrayList<String>();
        
        for(Item item : items) {
            nombres.add(item.getNombre());
        }
        
        return nombres;
    }
    
    private List<String> getDatosItem() {
        List<String> strings = new ArrayList<String>();

        strings.add(nombreTextField.getText());
        strings.add(placaTextField.getText());
        strings.add(fabricantesComboBox.getSelectedItem().toString());
        strings.add(inicialSpinner.getValue().toString());
        strings.add(minimaSpinner.getValue().toString());
        strings.add(frecuenciaMinimaSpinner.getValue().toString());
        strings.add(frecuenciaMinimaTipoComboBox.getSelectedItem().toString().toUpperCase());
        strings.add(tiempoMaximoSpinner.getValue().toString());
        strings.add(tiempoMaximoTipoComboBox.getSelectedItem().toString().toUpperCase());
        strings.add(frecuenciaMaximaSpinner.getValue().toString());
        strings.add(frecuenciaMaximaTipoComboBox.getSelectedItem().toString().toUpperCase());
        
        return strings;
    }
    
    private List<Item> items = new ArrayList<Item>();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JTabbedPane creacionItemTabPanel;
    private javax.swing.JPanel descripcionBasicaPanel1;
    private javax.swing.JScrollPane descripcionBasicaScrollPane1;
    private javax.swing.JPanel descripcionPanel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JComboBox fabricantesComboBox;
    private javax.swing.JSpinner frecuenciaMaximaSpinner;
    private javax.swing.JComboBox frecuenciaMaximaTipoComboBox;
    private javax.swing.JSpinner frecuenciaMinimaSpinner;
    private javax.swing.JComboBox frecuenciaMinimaTipoComboBox;
    private javax.swing.JButton guardarBoton;
    private javax.swing.JButton informacionFabricanteButton;
    private javax.swing.JSpinner inicialSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner minimaSpinner;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel notificacionesPanel;
    private javax.swing.JTextField placaTextField;
    private javax.swing.JSpinner tiempoMaximoSpinner;
    private javax.swing.JComboBox tiempoMaximoTipoComboBox;
    private javax.swing.JPanel tituloPanel3;
    // End of variables declaration//GEN-END:variables
}
