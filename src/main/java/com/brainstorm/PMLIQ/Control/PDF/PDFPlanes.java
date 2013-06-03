/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control.PDF;

import static com.brainstorm.PMLIQ.Control.PDF.PDF.catFont;
import static com.brainstorm.PMLIQ.Control.PDF.PDF.subFont;
import static com.brainstorm.PMLIQ.Control.PDF.PDF.subTitleFont;
import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Accesorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Actividad;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Laboratorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

/**
 *
 * @author Silex RPR
 */
public class PDFPlanes extends PDF {

    @Override
    public void addContent(Equipo equipo) throws DocumentException {
        for(PlanMantenimiento p : equipo.getPlanes()) {
            agregarHeader(equipo);
            agregarDescripcionBasica(p);
            agregarElementoChecklist(p);
            document.newPage();
        }
    }

    private void agregarHeader(Equipo equipo) throws DocumentException {
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
        
        cell = new PdfPCell(new Phrase("PLACA DEL EQUIPO: " + equipo.getPlacaInventario(), subTitleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(1);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("PLANES DE MANTENIMIENTO", subTitleFont));
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
    
    private void agregarDescripcionBasica(PlanMantenimiento plan) throws DocumentException {
        
        Paragraph preface = new Paragraph("DESCRIPCION BASICA", subTitleFont);
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
        
        document.add(table);
    }
    
    private void agregarElementoChecklist(PlanMantenimiento plan) throws DocumentException {
        
        Integer numeroActividad = new Integer(1);
        for (Actividad a : plan.getCheckList()) {
            
            Paragraph preface = new Paragraph("ACTIVIDAD CHECKLIST #0" + numeroActividad.toString(), subTitleFont);
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
            table.addCell(createCell(a.getNombre(), subNormalFont, BaseColor.WHITE, 3, 1));

            table.addCell(createCell("Tipo", subFont, BaseColor.LIGHT_GRAY));
            table.addCell(createCell(a.getTipoActividad().toString(), subNormalFont, BaseColor.WHITE, 3, 1));

            table.addCell(createCell("Proceso", subFont, BaseColor.LIGHT_GRAY));
            table.addCell(createCell(a.getProceso(), subNormalFont, BaseColor.WHITE, 3, 1));

            document.add(table);
            
            agregarItemsActividad(a);
            
            numeroActividad += 1;
        }
    }
    
    private void agregarItemsActividad(Actividad actividad) throws DocumentException {
        
        Paragraph preface = new Paragraph("ITEMS ASOCIADOS", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1});
 
        table.setTotalWidth(400f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        float[] widths = new float[] { 40f, 120f, 150f };
        table.setWidths(widths);
        
        table.addCell(createCell("Cantidad Requerida", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Nombre", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Placa de Inventario", subFont, BaseColor.LIGHT_GRAY, 1, 1, Element.ALIGN_CENTER));
        
        int index = 0;
        for (Item i : actividad.getPartesAsociadas()) {
            table.addCell(createCell(actividad.getCantidades().get(index).toString(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(i.getNombre(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(i.getPlacaInventario(), subNormalFont, BaseColor.WHITE));
            index += 1;
        }
        
        document.add(table);
    }
    
}
