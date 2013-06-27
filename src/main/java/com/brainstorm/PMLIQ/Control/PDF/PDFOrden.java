/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control.PDF;

import static com.brainstorm.PMLIQ.Control.PDF.PDF.catFont;
import static com.brainstorm.PMLIQ.Control.PDF.PDF.subFont;
import static com.brainstorm.PMLIQ.Control.PDF.PDF.subNormalFont;
import static com.brainstorm.PMLIQ.Control.PDF.PDF.subTitleFont;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Actividad;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Record.ItemRecord;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class PDFOrden extends PDF {
    
    @Override
    public void addContent(PlanMantenimiento plan) throws DocumentException {
        agregarHeader(plan);
        agregarOrden(plan);
        agregarChecklist(plan);
    }

    private void agregarHeader(PlanMantenimiento plan) throws DocumentException {
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
        
        cell = new PdfPCell(new Phrase("CODIGO: " + plan.getCodigo(), subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("ORDENES DE MANTENIMIENTO", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Version 0.1", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Fecha Actual", subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        document.add(table);        
    }
    
    private void agregarOrden(PlanMantenimiento plan) throws DocumentException {
        Paragraph preface = new Paragraph("ORDEN DE MANTENIMIENTO", subTitleFont);
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

        table.addCell(createCell("Nombre", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getNombre(), subNormalFont, BaseColor.WHITE, 3, 1));
        
        table.addCell(createCell("Codigo", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getCodigo(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Tipo", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getTipoPlan().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Responsable", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getResponsable(), subNormalFont, BaseColor.WHITE, 3, 1));
        
        table.addCell(createCell("Maximo Registros", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getMaximoRegistros().toString(), subNormalFont, BaseColor.WHITE));
       
        table.addCell(createCell("Frecuencia Uso de Horas Semanales", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getFrecuenciaUso().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Prioridad", subFont, BaseColor.LIGHT_GRAY));
        table.addCell(createCell(plan.getPrioridad().toString().toUpperCase(), subNormalFont, BaseColor.WHITE, 3, 1));
        
        document.add(table);        
    }

    private void agregarChecklist(PlanMantenimiento plan) throws DocumentException {
        Paragraph preface = new Paragraph("CHECKLIST", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1});

        table.setTotalWidth(150f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        float[] widths = new float[] { 50f, 50f, 50f };
        table.setWidths(widths);

        table.addCell(createCell("Nombre", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Tipo de Actividad", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Tiempo", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        
        for (Actividad a : plan.getCheckList()) {
            table.addCell(createCell(a.getNombre(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(a.getTipoActividad().toString(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(a.getTiempoTarea() + " " + a.getTiempo().toString().toLowerCase(), subNormalFont, BaseColor.WHITE));
        }

        document.add(table);        
    }
}
