/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.actions;

import com.brainstorm.PMLIQ.Control.PDF.PDFPlanes;
import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.View.PMLIApp;
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
public class GenerarOrdenAction extends AbstractAction {

    private JTable listaTable;
    private DefaultTableModel equiposModel;
    
    public GenerarOrdenAction(String name, JTable table, DefaultTableModel model) {
        super(name);
        this.listaTable = table;
        this.equiposModel = model;
    }
    
    public void actionPerformed(ActionEvent e) {
       int selectedRow = listaTable.getSelectedRow();
        
        if (selectedRow != -1) {
            String nombre = (String) equiposModel.getValueAt(listaTable.convertRowIndexToModel(selectedRow), 0);
            String placa = (String) equiposModel.getValueAt(listaTable.convertRowIndexToModel(selectedRow), 1);
            Equipo equipoSeleccionado = PMLIApp.getInstance().getSistema().getEquipo(placa);

            String rutaArchivo = "Data/Ordenes/Orden - " + nombre + " - " + placa + ".pdf";
            
            PMLIApp.getInstance().getAdmEquipos().crearPDF(new PDFPlanes(), equipoSeleccionado, rutaArchivo);

            if (Desktop.isDesktopSupported()) {
               if ( JOptionPane.showConfirmDialog(PMLIApp.getInstance().getMainWindow(), "     El plan de mantenimiento del equipo se genero correctamente.\n"
                       + "¿Desea abrir el plan de mantenimiento generado en su lector de PDF?" , "Lectura Planes de Mantenimiento",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
               {
                    File archivoPDF = new File(rutaArchivo);
                   try {
                       Desktop.getDesktop().open(archivoPDF);
                   } catch (IOException ex) {
                       Logger.getLogger(EquiposListaPanel.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           } else
           {
              JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "El plan de mantenimiento se genero correctamente y se encuentra en PDF. \n"
                        + "en la carpeta del programa.", "Error Lector PDF", JOptionPane.INFORMATION_MESSAGE);
           }
        } else {
            JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "No esta seleccionado ningun equipo para generar el plan de mantenimiento.", 
                                        "Error Al No Generar Plan de Mantenimiento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
