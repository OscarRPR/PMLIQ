/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

/**
 *
 * @author Silex RPR
 */
public class Laboratorio {

    private String facultad, departamento, laboratorio, edificio, email, codigo;
    private String numeroLaboratorio, numeroEdificio, extensionTelefonica;
    
    public Laboratorio() {
        setDefaultValues();
    }
    
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroLaboratorio() {
        return numeroLaboratorio;
    }

    public void setNumeroLaboratorio(String numeroLaboratorio) {
        this.numeroLaboratorio = numeroLaboratorio;
    }

    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    public String getExtensionTelefonica() {
        return extensionTelefonica;
    }

    public void setExtensionTelefonica(String extensionTelefonica) {
        this.extensionTelefonica = extensionTelefonica;
    }
    
    private final void setDefaultValues() {
        this.facultad = "Ingenieria";
        this.departamento = "Quimica y Ambiental";
        this.laboratorio = "Planta Piloto";
        this.numeroLaboratorio = "117";
        this.edificio = "LABORATORIO DE INGENIERIA QUIMICA";
        this.numeroEdificio = "412";
        this.codigo = "B-ING-L037";
        this.extensionTelefonica = "14315";
        this.email = "labiq_fiqbog@unal.edu.co";
    }
}
