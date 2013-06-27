/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.Notifications;

import com.brainstorm.PMLIQ.Model.Enum.TimeStamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Silex RPR
 */
public class Alarm {

    private String id;
    private TimerTask timerTask;
    private Timer timer;
    private Long frecuencia = 0L;
    private Long tiempoTranscurrido = 0L;
    private Long tiempoInicial = 0L;
    
    public Alarm(TimerTask task, Long frecuencia, String id) {
        super();
        this.timerTask = task;
        this.frecuencia = frecuencia;
        this.id = id;
        timer = new Timer();
    }
    
    public void activarAlarma() {
        tiempoInicial = System.currentTimeMillis();
        timer.scheduleAtFixedRate(timerTask, 0, this.frecuencia);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Long frecuencia) {
        this.frecuencia = frecuencia;
    }

    public TimerTask getTimerTask() {
        return timerTask;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Long getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(Long tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    public Long getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoInicial(Long tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
    }
}
