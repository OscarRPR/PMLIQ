/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control.PDF;

import static com.brainstorm.PMLIQ.Control.PDF.PDF.catFont;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.brainstorm.PMLIQ.Model.Record.PlanesRecord;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class PDFHistorialPlanes extends PDF {

    @Override
    public void addContent(ArrayList<PlanesRecord> list) throws DocumentException {
        agregarHeader();
        agregarDescripcionBasica(list);
       // agregarHistorial(list);
    }
    
    private void agregarHeader() throws DocumentException {
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1});

        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        PdfPCell cell = new PdfPCell(new Phrase("IMAGEN", catFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        cell.setRowspan(3);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("MACROPROCESO DE GESTION DE LABORATORIOS", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("CODIGO", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("FORMATO HOJA DE VIDA DE EQUIPO", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Version 0.1", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Pagina x de x", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        document.add(table);
    }
    
    private void agregarDescripcionBasica(List<PlanesRecord> list) throws DocumentException {
       /* Paragraph preface = new Paragraph("DESCRIPCION BASICA", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PlanMantenimiento plan = PMLIApp.getInstance().getSistema().getPlanByCodigo(list.get(0).getId());
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1});

        table.setTotalWidth(220f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        float[] widths = new float[] { 50f, 50f, 50f, 50f };
        table.setWidths(widths);

        table.addCell(createCell("Nombre", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getNombre(), subNormalFont, BaseColor.WHITE, 3, 1));
        
        table.addCell(createCell("Placa de Inventario", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getCodigo(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Fabricante", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getResponsable(), subNormalFont, BaseColor.WHITE));
        
        document.add(table);
    }
    
    private void agregarHistorial(List<PlanesRecord> list) throws DocumentException {
        
        Paragraph preface = new Paragraph("HISTORIAL", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1});

        table.setTotalWidth(220f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        float[] widths = new float[] { 50f, 50f, 50f, 50f };
        table.setWidths(widths);

        table.addCell(createCell("Codigo", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Descripcion", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Fecha", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Responsable", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        
        for (PlanesRecord p : list) {
            table.addCell(createCell(p.getId(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(p.getAction(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(p.getDate().toString(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(p.getResponsable(), subNormalFont, BaseColor.WHITE));
        }
        
        document.add(table);*/
    }
    
}
