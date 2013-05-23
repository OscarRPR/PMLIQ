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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silex RPR
 */
public class PDFEquipo {
    
    private Document document;
    
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font subNormalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
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
    
    public void addContent(Equipo equipo) throws DocumentException {
        agregarHeader();
        agregarDatosLaboratorio(equipo);
        agregarDescripcionBasica(equipo);
        agregarTareas(equipo.getTareasEquipo());
        agregarDatosTecnicos(equipo.getDatosTecnicosEquipo());
        agregarRequerimientos(equipo.getDatosTecnicosEquipo().getRequerimientosAdicionales());
        agregarEspecificacionMedicion(equipo.getDatosTecnicosEquipo().getEspecificacionMedicion());
        agregarAccesorios(equipo.getAccesorios());
        agregarEquiposAsociados(equipo.getEquiposAsociados());
        agregarPlanMantenimiento(equipo.getPlanes());
        agregarMetodoAdquisicion(equipo.getMetodoAdquisicion());
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
    
    private void agregarDatosLaboratorio(Equipo equipo) throws DocumentException {
        
        Paragraph preface = new Paragraph("DATOS DEL LABORATORIO", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1, 1, 1});
        Laboratorio laboratorio = equipo.getLaboratorio();
 
        table.setTotalWidth(220f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        float[] widths = new float[] { 55f, 75f, 10f, 15f, 30f, 35f };
        table.setWidths(widths);

        table.addCell(createCell("Facultad o Instituto", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getFacultad(), subNormalFont, BaseColor.WHITE, 5, 1));
        
        table.addCell(createCell("Departamento/Escuela", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getDepartamento(), subNormalFont, BaseColor.WHITE, 5, 1));
        
        table.addCell(createCell("Laboratorio", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getLaboratorio(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("No", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getNumeroLaboratorio(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Codigo", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getCodigo(), subNormalFont, BaseColor.WHITE));
       
        table.addCell(createCell("Edificio", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getEdificio(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("No", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getNumeroEdificio(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Ext-Telefono", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getExtensionTelefonica(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Email_Lab", subFont, BaseColor.GRAY));
        table.addCell(createCell(laboratorio.getEmail(), subNormalFont, BaseColor.WHITE, 5, 1));
        
        document.add(table);
    }
    
    private void agregarDescripcionBasica(Equipo equipo) throws DocumentException {
        
        Paragraph preface = new Paragraph("DESCRIPCION DEL EQUIPO", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1, 1, 1});
 
        table.setTotalWidth(300f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        float[] widths = new float[] { 50f, 50f, 50f, 50f, 50f, 50f };
        table.setWidths(widths);

        table.addCell(createCell("Nombre", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getNombre(), subNormalFont, BaseColor.WHITE, 5, 1));
        
        table.addCell(createCell("Placa de Inventario", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getPlacaInventario(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Clase de Equipo", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getClaseEquipo(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Tipo de Equipo", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getTipoEquipo().toString(), subNormalFont, BaseColor.WHITE, 5, 1));
        
        table.addCell(createCell("Marca", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getMarca(), subNormalFont, BaseColor.WHITE));
       
        table.addCell(createCell("Modelo", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getModelo(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Serie", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getSerieEquipo(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Manuales", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getTipoManual().toString(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Codigo Manuales", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getCodigoDocumento(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Ubicacion en el Lab", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getUbicacionEnLaboratorio(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Uso del Equipo", subFont, BaseColor.GRAY));
        table.addCell(createCell(equipo.getUsoEquipo().toString(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        document.add(table);
    }
    
    private void agregarTareas(String tareas) throws DocumentException {
        
        Paragraph preface = new Paragraph("TAREAS/DETERMINACIONES QUE SE REALIZAN CON EL EQUIPO", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1});
 
        table.setTotalWidth(220f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        table.addCell(createCell(tareas, subNormalFont, BaseColor.WHITE));
 
        
        document.add(table);
    }
    
    private void agregarDatosTecnicos(DatosTecnicosEquipo datos) throws DocumentException {
        Paragraph preface = new Paragraph("DATOS TECNICOS DEL EQUIPO", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1, 1, 1, 1, 1});
 
        table.setTotalWidth(400f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        DatosElectricosEquipo datosElectricos = datos.getDatosElectricos();
        
        float[] widths = new float[] { 50f, 50f, 60f, 50f, 60f, 50f, 40f, 40f };
        table.setWidths(widths);

        table.addCell(createCell("Datos Electricos", subFont, BaseColor.GRAY, 8, 1, Element.ALIGN_CENTER));
        
        table.addCell(createCell("Voltaje(V)", subFont, BaseColor.GRAY));
        table.addCell(createCell(datosElectricos.getVoltaje().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Potencia(W)", subFont, BaseColor.GRAY));
        table.addCell(createCell(datosElectricos.getPotencia().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Corriente(A)", subFont, BaseColor.GRAY));
        table.addCell(createCell(datosElectricos.getCorriente().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Fases", subFont, BaseColor.GRAY));
        table.addCell(createCell(datosElectricos.getFases().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Dimensiones", subFont, BaseColor.GRAY, 8, 1, Element.ALIGN_CENTER));
 
        DimensionesEquipo dimensiones = datos.getDimensiones();
        
        table.addCell(createCell("Alto(m)", subFont, BaseColor.GRAY));
        table.addCell(createCell(dimensiones.getAlto().toString(), subNormalFont, BaseColor.WHITE));
       
        table.addCell(createCell("Ancho(m)", subFont, BaseColor.GRAY));
        table.addCell(createCell(dimensiones.getAncho().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Profundo(m)", subFont, BaseColor.GRAY));
        table.addCell(createCell(dimensiones.getProfundo().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Peso(kg)", subFont, BaseColor.GRAY));
        table.addCell(createCell(dimensiones.getPeso().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Tipo de Equipo", subFont, BaseColor.GRAY));
        table.addCell(createCell(dimensiones.getPosicionUsoEquipo().toString(), subNormalFont, BaseColor.WHITE, 7, 1));
        
        table.addCell(createCell("Ambientales y de Funcionamiento", subFont, BaseColor.GRAY, 8, 1, Element.ALIGN_CENTER));

        table.addCell(createCell("T Ambiente (C)", subFont, BaseColor.GRAY));
        table.addCell(createCell(datos.getTemperaturaAmbiente().toString(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("HR(%)", subFont, BaseColor.GRAY));
        table.addCell(createCell(datos.getHR().toString(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Otro", subFont, BaseColor.GRAY));
        table.addCell(createCell(datos.getOtraOpcion(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        document.add(table);       
    }
    
    private void agregarRequerimientos(String requerimientos) throws DocumentException {
        
        document.newPage();
        agregarHeader();
        
        Paragraph preface = new Paragraph("REQUERIMIENTOS ADICIONALES", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1});
 
        table.setTotalWidth(220f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        table.addCell(createCell(requerimientos + "\n", subNormalFont, BaseColor.WHITE));
        
        document.add(table);
    }
    
    private void agregarEspecificacionMedicion(String especificacion) throws DocumentException {
        
        Paragraph preface = new Paragraph("ESPECIFICACION DE MEDICION", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1});
 
        table.setTotalWidth(220f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        table.addCell(createCell(especificacion + "\n", subNormalFont, BaseColor.WHITE));
        
        document.add(table);
    }
    
    private void agregarAccesorios(List<Accesorio> accesorios) throws DocumentException {
        
        Paragraph preface = new Paragraph("ACCESORIOS DEL EQUIPO", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1});
 
        table.setTotalWidth(400f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        float[] widths = new float[] { 40f, 120f, 150f, 90f };
        table.setWidths(widths);
        
        table.addCell(createCell("Cantidad", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Nombre", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Caracteristicas", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Marca", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        
        for (Accesorio a : accesorios) {
            table.addCell(createCell(a.getCantidad().toString(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(a.getNombre(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(a.getCaracteristicas(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(a.getMarca(), subNormalFont, BaseColor.WHITE));
        }
        
        document.add(table);
    }
    
    private void agregarEquiposAsociados(List<EquipoAsociado> equipos) throws DocumentException {
        
        Paragraph preface = new Paragraph("EQUIPOS ASOCIADOS", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1});
 
        table.setTotalWidth(200f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        float[] widths = new float[] { 120f, 80f };
        table.setWidths(widths);
        
        table.addCell(createCell("Nombre", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Placa de Inventario", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        
        for (EquipoAsociado e : equipos) {
            table.addCell(createCell(e.getNombre(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(e.getPlacaInventario(), subNormalFont, BaseColor.WHITE));
        }
        
        document.add(table);
    }
    
    private void agregarPlanMantenimiento(List<PlanMantenimiento> planes) throws DocumentException {
        
        Paragraph preface = new Paragraph("PLANES DE MANTENIMIENTO", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1});
 
        table.setTotalWidth(300f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);

        float[] widths = new float[] { 110f, 80f, 110f };
        table.setWidths(widths);
        
        table.addCell(createCell("Nombre", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Tipo de Plan", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        table.addCell(createCell("Responsable", subFont, BaseColor.GRAY, 1, 1, Element.ALIGN_CENTER));
        
        for (PlanMantenimiento p : planes) {
            table.addCell(createCell(p.getNombre(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(p.getTipoPlan().toString(), subNormalFont, BaseColor.WHITE));
            table.addCell(createCell(p.getResponsable(), subNormalFont, BaseColor.WHITE));
        }
        
        document.add(table);
        
        document.newPage();
        
        agregarHeader();
    }
    
    private void agregarMetodoAdquisicion(Proveedor proveedor) throws DocumentException {
        
        Paragraph preface = new Paragraph("METODO DE ADQUISICION", subTitleFont);
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        
        document.add(preface);
        
        PdfPTable table = new PdfPTable(new float[] {1, 1, 1, 1, 1, 1});
 
        table.setTotalWidth(300f);
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        
        float[] widths = new float[] { 50f, 50f, 50f, 50f, 50f, 50f };
        table.setWidths(widths);

        table.addCell(createCell("Fabricante", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getFabricante(), subNormalFont, BaseColor.WHITE, 5, 1));
        
        table.addCell(createCell("Proveedor", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getProveedor(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("NIT", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getNIT(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Contacto", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getContacto(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Telefono", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getTelefono(), subNormalFont, BaseColor.WHITE, 2, 1));
       
        table.addCell(createCell("Direccion", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getDireccion(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Email", subFont, BaseColor.GRAY));
        table.addCell(createCell(proveedor.getEmail(), subNormalFont, BaseColor.WHITE, 2, 1));
        
        table.addCell(createCell("Forma de Adquisicion", subFont, BaseColor.GRAY, 6, 1, Element.ALIGN_CENTER));

        FormaAdquisicion forma = proveedor.getFormaAdquisicion();
        
        if ( forma.isCompra() ) {
            table.addCell(createCell("Valor Compra", subFont, BaseColor.GRAY, 2, 1));
            table.addCell(createCell("$" + forma.getValorCompra() + " COP", subNormalFont, BaseColor.WHITE, 4, 1));
        } else {
            table.addCell(createCell("Donacion - Tiempo Uso", subFont, BaseColor.GRAY, 2, 1));
            table.addCell(createCell(forma.getTiempoUso().toString() + " años", subNormalFont, BaseColor.WHITE, 4, 1));
        }
        
        table.addCell(createCell("Fecha Adquisicion", subFont, BaseColor.GRAY));
        table.addCell(createCell(forma.getFechaAdquisicion().getFullDate(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Fecha Puesta en Servicio", subFont, BaseColor.GRAY));
        table.addCell(createCell(forma.getPuestaEnServicio().getFullDate(), subNormalFont, BaseColor.WHITE));
        
        table.addCell(createCell("Vida Util (años)", subFont, BaseColor.GRAY));
        table.addCell(createCell(forma.getValorCompra(), subNormalFont, BaseColor.WHITE));
        
        document.add(table);
    }
    
    public void closeDocument() {
        document.close();
    }
    
    private PdfPCell createCell(String data, Font font, BaseColor color, int colspan, int rowspan) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setBackgroundColor(color);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
  
        return cell;
    }

    private PdfPCell createCell(String data, Font font, BaseColor color, int colspan, int rowspan, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setHorizontalAlignment(alignment);
        cell.setBackgroundColor(color);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
  
        return cell;
    }
    
    private PdfPCell createCell(String data, Font font, BaseColor color) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setBackgroundColor(color);
        cell.setColspan(1);
        cell.setRowspan(1);
  
        return cell;
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
          paragraph.add(new Paragraph(" "));
        }
    }

}