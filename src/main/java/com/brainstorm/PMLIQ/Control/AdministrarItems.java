/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control;

import com.brainstorm.PMLIQ.Control.PDF.PDF;
import com.brainstorm.PMLIQ.Control.PDF.PDFEquipo;
import com.brainstorm.PMLIQ.Control.PDF.PDFHistorialItem;
import com.brainstorm.PMLIQ.Model.Actions.ItemActionMessages;
import com.brainstorm.PMLIQ.Model.Enum.ItemAction;
import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Validacion;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionItem;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.itextpdf.text.DocumentException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silex RPR
 */
public class AdministrarItems {
   
    private Validacion validacion = new ValidacionItem(); 
    
    private PDF pdfGenerator = new PDFHistorialItem();
    
    public List<String> crearItem(final List<String> item, final List<String> existentes)
    {
        List<String> validaciones = new ArrayList<String>();
        validaciones.add(validacionDatos(new ValidacionItem(), item, existentes));
  
        if ( datosFueronValidados(validaciones) ) 
        {
            Item nuevoItem = new Item(item);       

            PMLIApp.getInstance().getSistema().agregarItem(nuevoItem);  
            actualizarHistorial(nuevoItem, ItemAction.CREATE);
        }   
        
        return validaciones;
    }    
    
    public void actualizarHistorial(Item item, int action) {
        String message = new ItemActionMessages().getMessage(item, action);
        PMLIApp.getInstance().getSistema().actualizarHistorialItem(item.getPlacaInventario(), message,
                                                                   "Administrador");  
    }
        
    private boolean datosFueronValidados(List<String> strings) 
    {
        for ( String s : strings )
        {
            if ( !s.equals("") ) 
            {
                return false;
            }
        }
        return true;
    }
    
    private String validacionDatos(Validacion tipoValidacion, List<String> strings, List<String> repetidos) {
        String resultadoValidacion;
        validacion = tipoValidacion;
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
            resultadoValidacion = validacion.validarValorRepetidoString(strings, repetidos);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;        
    }  
    
    public void crearPDF(PDF pdfGenerator, List<ItemRecord> listRecords, String filename) {
        this.pdfGenerator = pdfGenerator;
        pdfGenerator.crearArchivoPDF(filename);
        pdfGenerator.addMetaData();
        try {
            pdfGenerator.addContent(listRecords);
        } catch (DocumentException ex) {
            Logger.getLogger(AdministrarEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pdfGenerator.closeDocument();      
    }
}
