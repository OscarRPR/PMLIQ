/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.Model.EquipoInfo;

import com.brainstorm.PMLIQ.Control.Constantes.ConstantesEquipoAsociado;
import java.util.List;

/**
 *
 * @author Silex RPR
 */
public class EquipoAsociado {
    
    private String nombre, placaInventario;
    
    private ConstantesEquipoAsociado vars = new ConstantesEquipoAsociado();
    
    public EquipoAsociado() {
    }
    
    public EquipoAsociado(final List<String> equipoAsociado) {
       this.nombre = equipoAsociado.get(vars.NOMBRE);
       this.placaInventario = equipoAsociado.get(vars.PLACA);
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
}
