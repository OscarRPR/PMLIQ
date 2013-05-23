/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Datatypes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class Fecha {

    private final int DIA = 0;
    private final int MES = 1;
    private final int AÑO = 2;
    
    public Fecha(String date) {
        this.fullDate = date;

        List<String> valuesDate = Arrays.asList(fullDate.split("-"));

        this.dia = Integer.parseInt(valuesDate.get(DIA));
        this.mes = Integer.parseInt(valuesDate.get(MES));
        this.año = Integer.parseInt(valuesDate.get(AÑO));
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    private Integer dia, mes, año;
    private String fullDate;
}
