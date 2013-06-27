/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.dialogs;

import com.brainstorm.PMLIQ.Model.EquipoInfo.Actividad;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author Silex RPR
 */
public class CrearPlanMantenimiento extends javax.swing.JDialog {

    /**
     * Creates new form CrearPlanMantenimiento
     */
    public CrearPlanMantenimiento(java.awt.Frame parent, boolean modal, List<PlanMantenimiento> planes) {
        super(parent, modal);
        
        initComponents();
        
        setTitle("Añadiendo un plan de mantenimiento");
        setResizable(false);
        
        this.planes = planes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        planPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        codigoTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        responsableTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maxRegistrosSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        usoSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        tiempoSpinner = new javax.swing.JSpinner();
        tiempoComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        prioridadComboBox = new javax.swing.JComboBox();
        guardarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        mantenimientoPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        añadirChecklistButton = new javax.swing.JButton();
        eliminarChecklistButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkList = new javax.swing.JList();
        errorLabel = new javax.swing.JLabel();

        jLabel4.setText("Frecuencia de la Tarea");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        planPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                planPanelComponentShown(evt);
            }
        });
        planPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                planPanelFocusGained(evt);
            }
        });
        planPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                planPanelPropertyChange(evt);
            }
        });

        jLabel1.setText("CREANDO PLAN DE MANTENIMIENTO");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción Básica"));

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo Plan");

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Preventivo", "Calibracion" }));

        jLabel6.setText("Código");

        jLabel7.setText("Responsable");

        jLabel8.setText("Máximo Registros de Mantenimiento");

        maxRegistrosSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel10.setText("Frecuencia Uso (Horas Semanales)");

        usoSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel5.setText("Frecuencia del Plan");

        tiempoSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        tiempoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horas", "Dias", "Semanas", "Meses", "Años" }));

        jLabel11.setText("Prioridad");

        prioridadComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(responsableTextField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maxRegistrosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tiempoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tiempoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prioridadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(usoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(responsableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(maxRegistrosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(usoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tiempoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(prioridadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        mantenimientoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Plan"));

        jLabel9.setText("Checklist");

        añadirChecklistButton.setText("+");
        añadirChecklistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirChecklistButtonActionPerformed(evt);
            }
        });

        eliminarChecklistButton.setText("-");
        eliminarChecklistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarChecklistButtonActionPerformed(evt);
            }
        });

        checkList.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                checkListComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(checkList);

        javax.swing.GroupLayout mantenimientoPanelLayout = new javax.swing.GroupLayout(mantenimientoPanel);
        mantenimientoPanel.setLayout(mantenimientoPanelLayout);
        mantenimientoPanelLayout.setHorizontalGroup(
            mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(añadirChecklistButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarChecklistButton)
                .addContainerGap())
        );
        mantenimientoPanelLayout.setVerticalGroup(
            mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mantenimientoPanelLayout.createSequentialGroup()
                        .addGroup(mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(añadirChecklistButton)
                            .addComponent(eliminarChecklistButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addContainerGap())
        );

        errorLabel.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout planPanelLayout = new javax.swing.GroupLayout(planPanel);
        planPanel.setLayout(planPanelLayout);
        planPanelLayout.setHorizontalGroup(
            planPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(planPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(planPanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(planPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(178, 178, 178))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planPanelLayout.createSequentialGroup()
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planPanelLayout.createSequentialGroup()
                                .addComponent(mantenimientoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planPanelLayout.createSequentialGroup()
                                .addComponent(guardarButton)
                                .addGap(11, 11, 11)
                                .addComponent(cancelarButton)
                                .addContainerGap())))))
        );
        planPanelLayout.setVerticalGroup(
            planPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mantenimientoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(planPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(cancelarButton))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void añadirChecklistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirChecklistButtonActionPerformed
        CrearElementoCheckList crearElementoCheckList = new CrearElementoCheckList(
                                                (JFrame)PMLIApp.getInstance().getMainWindow(), true, actividades);
        crearElementoCheckList.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                updateListModel();
            }
        });
        
        crearElementoCheckList.setLocationRelativeTo(null);
        crearElementoCheckList.setVisible(true);
    }//GEN-LAST:event_añadirChecklistButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        List<String> planEquipo = getDatosPlanMantenimiento();
 
        String resultados = PMLIApp.getInstance().getAdmEquipos().validarDatosPlanMantenimiento(planEquipo);
        errorLabel.setText(resultados);

        if ( resultados.equals("") )
        {
            planes.add(PMLIApp.getInstance().getAdmEquipos().crearPlanMantenimiento(planEquipo, actividades));
            this.dispose();
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void planPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_planPanelFocusGained

    }//GEN-LAST:event_planPanelFocusGained

    private void planPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_planPanelPropertyChange

    }//GEN-LAST:event_planPanelPropertyChange

    private void checkListComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_checkListComponentShown
        
    }//GEN-LAST:event_checkListComponentShown

    private void planPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_planPanelComponentShown
        
    }//GEN-LAST:event_planPanelComponentShown

    private void eliminarChecklistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarChecklistButtonActionPerformed
        int indiceSeleccion = checkList.getSelectedIndex();
        if ( indiceSeleccion != -1 ) {
            for (int i = 0; i < checkList.getSelectedValues().length; i++) {
                String nombre = (String)checkList.getSelectedValues()[i];
                eliminarActividad(nombre);
            }

            updateListModel();
        }
    }//GEN-LAST:event_eliminarChecklistButtonActionPerformed

    private void eliminarActividad(String nombre) {
        for (Actividad a : actividades) {
            if (a.getNombre().equals(nombre)) {
                actividades.remove(a);
                return;
            }
        }
    }
    
    private void updateListModel() {
        checklistModel.clear();
        for(Actividad a : actividades) {
            checklistModel.addElement(a.getNombre());
        }
        
        checkList.setModel(checklistModel);
    }
    
    private List<String> getDatosPlanMantenimiento() {
        List<String> strings = new ArrayList<String>();

        strings.add(nombreTextField.getText());
        strings.add(codigoTextField.getText());
        strings.add(tipoComboBox.getSelectedItem().toString());
        strings.add(responsableTextField.getText());
        strings.add(maxRegistrosSpinner.getValue().toString());
        strings.add(usoSpinner.getValue().toString());
        strings.add(tiempoSpinner.getValue().toString());
        strings.add(tiempoComboBox.getSelectedItem().toString());
        strings.add(prioridadComboBox.getSelectedItem().toString());
        
        String resultadoLista = "";
        if (  checkList.getModel().getSize() > 0 )
        {
            resultadoLista = "Tiene informacion";
        }
        
        strings.add(resultadoLista);
        
        return strings;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearPlanMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPlanMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPlanMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPlanMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearPlanMantenimiento dialog = new CrearPlanMantenimiento(new javax.swing.JFrame(), true, 
                                                new ArrayList<PlanMantenimiento>());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private List<PlanMantenimiento> planes = new ArrayList<PlanMantenimiento>();
    private List<Actividad> actividades = new ArrayList<Actividad>();
    private DefaultListModel checklistModel = new DefaultListModel();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirChecklistButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JList checkList;
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JButton eliminarChecklistButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mantenimientoPanel;
    private javax.swing.JSpinner maxRegistrosSpinner;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel planPanel;
    private javax.swing.JComboBox prioridadComboBox;
    private javax.swing.JTextField responsableTextField;
    private javax.swing.JComboBox tiempoComboBox;
    private javax.swing.JSpinner tiempoSpinner;
    private javax.swing.JComboBox tipoComboBox;
    private javax.swing.JSpinner usoSpinner;
    // End of variables declaration//GEN-END:variables
}
