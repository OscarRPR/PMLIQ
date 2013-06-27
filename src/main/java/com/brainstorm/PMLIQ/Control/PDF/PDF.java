/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control.PDF;

import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Accesorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.DatosElectricosEquipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.DatosTecnicosEquipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.DimensionesEquipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.EquipoAsociado;
import com.brainstorm.PMLIQ.Model.EquipoInfo.FormaAdquisicion;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Laboratorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Proveedor;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.brainstorm.PMLIQ.Model.Record.PlanesRecord;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silex RPR
 */
public abstract class PDF {
    
    protected Document document;
    
    protected static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    protected static Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
    protected static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    protected static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    protected static Font subNormalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    protected static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
    public void crearArchivoPDF(String filename) {
     document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFEquipo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PDFEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMetaData() {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Universidad Nacional de Colombia");
        document.addCreator("Brainstorm Interactive");
    }
    
    public void closeDocument() {
        document.close();
    }
    
    public void addContent(Equipo equipo) throws DocumentException {};
    
    public void addContent(PlanMantenimiento plan) throws DocumentException {};
    
    public void addContent(List<ItemRecord> list) throws DocumentException {};
    
    public void addContent(ArrayList<PlanesRecord> list) throws DocumentException {};
    
    protected PdfPCell createCell(String data, Font font, BaseColor color, int colspan, int rowspan) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setBackgroundColor(color);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
  
        return cell;
    }

    protected PdfPCell createCell(String data, Font font, BaseColor color, int colspan, int rowspan, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setHorizontalAlignment(alignment);
        cell.setBackgroundColor(color);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
  
        return cell;
    }
    
    protected PdfPCell createCell(String data, Font font, BaseColor color) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setBackgroundColor(color);
        cell.setColspan(1);
        cell.setRowspan(1);
  
        return cell;
    }

    protected void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
          paragraph.add(new Paragraph(" "));
        }
    }
}
