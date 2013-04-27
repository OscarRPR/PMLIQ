/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model;

import com.brainstorm.PMLIQ.Control.ConstantesEquipos;
import com.brainstorm.PMLIQ.Model.Enum.TipoEquipo;
import com.brainstorm.PMLIQ.Model.Enum.TipoManual;
import com.brainstorm.PMLIQ.Model.Enum.UsoEquipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Accesorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.DatosTecnicosEquipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.EquipoAsociado;
import com.brainstorm.PMLIQ.Model.Validation.Exceptions.LongitudStringException;
import com.brainstorm.PMLIQ.Model.Validation.Validacion;
import com.brainstorm.PMLIQ.Model.Validation.ValidacionEquipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silex RPR
 */

public class Equipo {

    private ConstantesEquipos varsBas = new ConstantesEquipos();
    
    public Equipo(String nombre, String placaInventario, String claseEquipo, String tipoEquipo, 
                  String marca, String modelo, String serieEquipo, String tipoManual,
                  String codigoDocumento, String ubicacionEnLaboratorio, String usoEquipo, 
                  String tareasEquipo) {
        this.nombre = nombre;
        this.placaInventario = placaInventario;
        this.claseEquipo = claseEquipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoEquipo = TipoEquipo.valueOf(tipoEquipo.toUpperCase());
        this.serieEquipo = serieEquipo;
        this.codigoDocumento = codigoDocumento;
        this.tipoManual = TipoManual.valueOf(tipoManual.toUpperCase());
        this.ubicacionEnLaboratorio = ubicacionEnLaboratorio;
        this.usoEquipo = UsoEquipo.valueOf(usoEquipo.toUpperCase());
        this.tareasEquipo = tareasEquipo;
    }
    
    public Equipo(List<String> infoEquipo) {
        this.nombre = infoEquipo.get(varsBas.NOMBRE);
        this.placaInventario = infoEquipo.get(varsBas.PLACAINVENTARIO);
        this.claseEquipo = infoEquipo.get(varsBas.CLASEEQUIPO);
        this.marca = infoEquipo.get(varsBas.MARCA);
        this.modelo = infoEquipo.get(varsBas.MODELO);
        this.tipoEquipo = TipoEquipo.valueOf(infoEquipo.get(varsBas.TIPO).toUpperCase());
        this.serieEquipo = infoEquipo.get(varsBas.SERIE);
        this.codigoDocumento = infoEquipo.get(varsBas.CODIGO);
        this.tipoManual = TipoManual.valueOf(infoEquipo.get(varsBas.MANUALES).toUpperCase());
        this.ubicacionEnLaboratorio = infoEquipo.get(varsBas.UBICACION);
        this.usoEquipo = UsoEquipo.valueOf(infoEquipo.get(varsBas.USO).toUpperCase());
        this.tareasEquipo = infoEquipo.get(varsBas.TAREAS);
    }
    
    public void agregarDatosTecnicos(List<String> datos) {
        
        datosTecnicosEquipo = new DatosTecnicosEquipo(datos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlacaInventario() {
        return placaInventario;
    }

    public void setPlacaInventario(String placaInventario) {
        this.placaInventario = placaInventario;
    }

    public String getClaseEquipo() {
        return claseEquipo;
    }

    public void setClaseEquipo(String claseEquipo) {
        this.claseEquipo = claseEquipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getSerieEquipo() {
        return serieEquipo;
    }

    public void setSerieEquipo(String serieEquipo) {
        this.serieEquipo = serieEquipo;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public TipoManual getTipoManual() {
        return tipoManual;
    }

    public void setTipoManual(TipoManual tipoManual) {
        this.tipoManual = tipoManual;
    }

    public String getUbicacionEnLaboratorio() {
        return ubicacionEnLaboratorio;
    }

    public void setUbicacionEnLaboratorio(String ubicacionEnLaboratorio) {
        this.ubicacionEnLaboratorio = ubicacionEnLaboratorio;
    }

    public UsoEquipo getUsoEquipo() {
        return usoEquipo;
    }

    public void setUsoEquipo(UsoEquipo usoEquipo) {
        this.usoEquipo = usoEquipo;
    }

    public String getTareasEquipo() {
        return tareasEquipo;
    }

    public void setTareasEquipo(String tareasEquipo) {
        this.tareasEquipo = tareasEquipo;
    }

    private String nombre, placaInventario, claseEquipo, marca, modelo;
    private TipoEquipo tipoEquipo;
    private String serieEquipo, codigoDocumento;
    private TipoManual tipoManual;
    private String ubicacionEnLaboratorio;
    private UsoEquipo usoEquipo;
    private String tareasEquipo;
    
    private DatosTecnicosEquipo datosTecnicosEquipo;
    private List<Accesorio> accesorios = new ArrayList<Accesorio>();
    private List<EquipoAsociado> equiposAsociados = new ArrayList<EquipoAsociado>();
      
}
