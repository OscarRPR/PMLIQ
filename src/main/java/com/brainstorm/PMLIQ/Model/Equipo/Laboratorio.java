/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Equipo;

/**
 *
 * @author Silex RPR
 */
public class Laboratorio {

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

    public int getNumeroLaboratorio() {
        return numeroLaboratorio;
    }

    public void setNumeroLaboratorio(int numeroLaboratorio) {
        this.numeroLaboratorio = numeroLaboratorio;
    }

    public int getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(int numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    public int getExtensionTelefonica() {
        return extensionTelefonica;
    }

    public void setExtensionTelefonica(int extensionTelefonica) {
        this.extensionTelefonica = extensionTelefonica;
    }
    
    public void setDefaultValues() {
        this.facultad = "Ingenieria";
        this.departamento = "Quimica y Ambiental";
        this.laboratorio = "Planta Piloto";
        this.numeroLaboratorio = 117;
        this.edificio = "LABORATORIO DE INGENIERIA QUIMICA";
        this.numeroEdificio = 412;
        this.codigo = "B-ING-L037";
        this.extensionTelefonica = 14315;
        this.email = "labiq_fiqbog@unal.edu.co";
    }
    
    String facultad, departamento, laboratorio, edificio, email, codigo;
    int numeroLaboratorio, numeroEdificio, extensionTelefonica;
}
