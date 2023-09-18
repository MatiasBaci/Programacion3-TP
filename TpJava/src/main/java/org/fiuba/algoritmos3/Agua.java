package org.fiuba.algoritmos3;

import java.util.HashMap;
import java.util.Map;

public class Agua{ //extends de Tipo
    private Map<String,Double> tablaEfectividad;
    public Agua(){
        this.tablaEfectividad = new HashMap<>();
        tablaEfectividad.put("Agua",1.5);
        tablaEfectividad.put("Dragon",2.0);
        tablaEfectividad.put("Fuego",2.0);
        tablaEfectividad.put("Planta",1.5);
        tablaEfectividad.put("Roca",2.0);
        tablaEfectividad.put("Tierra",2.0);

    }
    public double calcularEfectividad(Tipo unTipo){
        if(this.tablaEfectividad.get(unTipo.getNombre()) == null){
            return 1.0;
        }
        return this.tablaEfectividad.get(unTipo.getNombre());
    }
}
