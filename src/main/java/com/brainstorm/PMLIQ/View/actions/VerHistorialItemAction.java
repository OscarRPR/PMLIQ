/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.actions;

import com.brainstorm.PMLIQ.Control.PDF.PDFEquipo;
import com.brainstorm.PMLIQ.Control.PDF.PDFHistorialItem;
import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.panel.list.EquiposListaPanel;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
public class VerHistorialItemAction extends AbstractAction {

    private JTable listaTable;
    private DefaultTableModel equiposModel;
    
    public VerHistorialItemAction(String name, JTable table, DefaultTableModel model) {
        super(name);
        this.listaTable = table;
        this.equiposModel = model;
    }
    
    public void actionPerformed(ActionEvent e) {
        int selectedRow = listaTable.getSelectedRow();
        
        if (selectedRow != -1) {
            String placa = (String) equiposModel.getValueAt(listaTable.convertRowIndexToModel(selectedRow), 1);
            List<ItemRecord> list = PMLIApp.getInstance().getSistema().getItemsRecordsById(placa);

            String rutaArchivo = "Data/Historiales Items/" + placa + " - Historial.pdf";
            
            PMLIApp.getInstance().getAdmItems().crearPDF(new PDFHistorialItem(), list, rutaArchivo);

            if (Desktop.isDesktopSupported()) {
               if ( JOptionPane.showConfirmDialog(PMLIApp.getInstance().getMainWindow(), "     El historial del item se genero correctamente.\n"
                       + "¿Desea abrir el historial del item en su lector de PDF?" , "Lectura Historial del Item",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
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
              JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "El historial del item se genero correctamente y se encuentra en PDF. \n"
                        + "en la carpeta del programa.", "Error Lector PDF", JOptionPane.INFORMATION_MESSAGE);
           }
        } else {
            JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "No esta seleccionado ningun item para mostrar el historial.", 
                                        "Error Al No Generar Historial de un Item", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
