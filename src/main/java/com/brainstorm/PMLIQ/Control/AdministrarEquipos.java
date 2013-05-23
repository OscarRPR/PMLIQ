/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control;

import com.brainstorm.PMLIQ.Control.PDF.PDFEquipo;
import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Accesorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Actividad;
import com.brainstorm.PMLIQ.Model.EquipoInfo.EquipoAsociado;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.ErrorValidacionException;
import com.brainstorm.PMLIQ.Model.Validation.Validacion;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionAccesorioEquipo;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionActividadChecklist;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionAdquisicionEquipo;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionDatosTecnicos;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionEquipo;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionEquipoAsociado;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionPlanMantenimiento;
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
public class AdministrarEquipos {
    
    private final String validacionAccesorio = "";
    private final String validacionEquipoAsociado = "";
    private final String validacionPlanMantenimiento = "";
        
    private Validacion validacion = new ValidacionEquipo();
    
    private PDFEquipo pdfGenerator = new PDFEquipo();

    public PDFEquipo getPdfGenerator() {
        return pdfGenerator;
    }

    public void setPdfGenerator(PDFEquipo pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public List<String> crearEquipo(List<String> infoEquipo, List<String> datosTecnicos,
                                    List<Accesorio> accesorios, List<EquipoAsociado> equipos,
                                    List<PlanMantenimiento> planes, List<String> adquisicion)
    {
        List<String> validaciones = new ArrayList<String>();
        validaciones.add(validacionDatosEquipo(infoEquipo));
        validaciones.add(validacionDatosTecnicos(datosTecnicos));
        validaciones.add(validacionAccesorio);
        validaciones.add(validacionEquipoAsociado);
        validaciones.add(validacionPlanMantenimiento);
        validaciones.add(validacionAdquisicionEquipo(adquisicion));
        
        if ( datosFueronValidados(validaciones) ) 
        {
            Equipo nuevoEquipo = new Equipo(infoEquipo);       
            nuevoEquipo.agregarDatosTecnicos(datosTecnicos);
            nuevoEquipo.agregarAccesorios(accesorios);
            nuevoEquipo.agregarEquiposAsociados(equipos);
            nuevoEquipo.agregarPlanesDeMantenimiento(planes);
            nuevoEquipo.agregarDatosAdquisicion(adquisicion);

            PMLIApp.getInstance().getSistema().agregarEquipo(nuevoEquipo);
        }   
        
        return validaciones;
    }
    
    public String validarDatosAccesorio(List<String> accesorioEquipo) {
        return validacionAccesorioEquipo(accesorioEquipo);
    }
    
    public String validarDatosAsociado(List<String> equipoAsociado) {
        return validacionEquipoAsociado(equipoAsociado);
    }
    
    public String validarDatosPlanMantenimiento(List<String> plan) {
        return validacionPlanMantenimiento(plan);
    }
    
    public String validarDatosActividadChecklist(List<String> actividad, List<String> strings) {
        return validacionDatos(new ValidacionActividadChecklist(), actividad, strings);
    }

    public Accesorio crearAccesorio(List<String> accesorioEquipo) {
        Accesorio nuevoAccesorio = new Accesorio(accesorioEquipo);
        return nuevoAccesorio;
    }
    
    public EquipoAsociado crearEquipoAsociado(List<String> equipoAsociado) {
        EquipoAsociado nuevoEquipoAsociado = new EquipoAsociado(equipoAsociado);
        return nuevoEquipoAsociado;
    }
    
    public PlanMantenimiento crearPlanMantenimiento(List<String> plan, List<Actividad> actividades) {
        PlanMantenimiento nuevoPlan = new PlanMantenimiento(plan, actividades);
        return nuevoPlan;
    }
    
    public Actividad crearActividadChecklist(List<String> plan, List<Item> partes) {
        Actividad nuevaActividad = new Actividad(plan, partes);
        return nuevaActividad;
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

    private String validacionDatosEquipo(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionEquipo();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    private String validacionDatosTecnicos(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionDatosTecnicos();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    private String validacionAdquisicionEquipo(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionAdquisicionEquipo();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    private String validacionAccesorioEquipo(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionAccesorioEquipo();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    private String validacionEquipoAsociado(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionEquipoAsociado();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    private String validacionPlanMantenimiento(List<String> strings)
    {
        String resultadoValidacion;
        validacion = new ValidacionPlanMantenimiento();
        
        try 
        {
            resultadoValidacion = validacion.validarString(strings);
        }
        catch(ErrorValidacionException ex) {
            resultadoValidacion = ex.getMessage();
        }

        return resultadoValidacion;
    }
    
    public void crearCVPDF(Equipo equipo, String filename) {
        pdfGenerator.crearArchivoPDF(filename);
        pdfGenerator.addMetaData();
        try {
            pdfGenerator.addContent(equipo);
        } catch (DocumentException ex) {
            Logger.getLogger(AdministrarEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pdfGenerator.closeDocument();
    }
}
