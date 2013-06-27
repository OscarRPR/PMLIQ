/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Control;

import com.brainstorm.PMLIQ.Model.Enum.TimeStamp;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.Model.Notifications.Alarm;
import com.brainstorm.PMLIQ.Model.Notifications.AlarmInfo;
import com.brainstorm.PMLIQ.Model.Notifications.ItemMinimumTask;
import com.brainstorm.PMLIQ.View.PMLIApp;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Silex RPR
 */
public class AdministrarNotificaciones {
    
    private List<Alarm> alarmasItems = new ArrayList<Alarm>();
    
    public void activarAlarmasItems() {
         List<Item> inventario = PMLIApp.getInstance().getAdmItems().getInventario();
         
         for(Item i : inventario) {
             activarAlarmaItem(i);
         }
    }
    
    public void activarAlarmaItem(Item item) {
    //    if (item.getCantidadMinimaAlarma() == null) {
            Long time = getTime(item.getFrecuenciaMinima(), item.getFrecuenciaMinimaTipo());
            item.setCantidadMinimaAlarma(new AlarmInfo(0L, time));
      //  }
        
        PMLIApp.getInstance().getSistema().agregarItem(item);
        
        TimerTask task = new ItemMinimumTask(item.getNombre(), item.getPlacaInventario(), 
                                             item.getCantidadMinima());
        Alarm alarm = new Alarm(task, item.getCantidadMinimaAlarma().getTiempoMaximo(), item.getPlacaInventario());
        System.out.println(alarm.getFrecuencia());
        alarm.activarAlarma();  
        alarmasItems.add(alarm);
    }
    
    public void detenerAlarmaItems() {
         List<Item> inventario = PMLIApp.getInstance().getAdmItems().getInventario();
         
         for(Item i : inventario) {
             detenerAlarmaItem(i);
         }
    }
    
    public void detenerAlarmaItem(Item item) {
        int indice = -1;
        for(int i = 0; i < alarmasItems.size(); i++) {
            if(alarmasItems.get(i).getId().equals(item.getPlacaInventario())) {
                indice = i;
                break;
            }
        }
        
        if(indice == -1) {
            return;
        }
        
        Alarm alarma = alarmasItems.get(indice);
        alarma.setTiempoTranscurrido(System.currentTimeMillis());
        Long tiempoTranscurrido = alarma.getTiempoTranscurrido() - alarma.getTiempoInicial();
        item.setCantidadTranscurridoAlarma(tiempoTranscurrido);
        alarma.getTimerTask().cancel();
        alarma.getTimer().cancel();
        
        alarmasItems.remove(indice);
        PMLIApp.getInstance().getSistema().agregarItem(item);
    }

    public void detenerAlarmaItemFull(Item item) {
        int indice = -1;
        for(int i = 0; i < alarmasItems.size(); i++) {
            if(alarmasItems.get(i).getId().equals(item.getPlacaInventario())) {
                indice = i;
                break;
            }
        }
        
        if(indice == -1) {
            return;
        }
        
        Alarm alarma = alarmasItems.get(indice);
        alarma.setTiempoTranscurrido(System.currentTimeMillis());
        item.setCantidadTranscurridoAlarma(0L);
        alarma.getTimerTask().cancel();
        alarma.getTimer().cancel();
        
        alarmasItems.remove(indice);
        PMLIApp.getInstance().getSistema().agregarItem(item);
    }
    
    public Long getTime(int frecuencia, TimeStamp tipo) {
        
        int milisegundos = 1000;
        int horas = 5;
        
        switch(tipo.ordinal()) {
            case 0: {
                return new Long(horas*milisegundos*frecuencia);
            }
        }
        return null;
        
    }
}
