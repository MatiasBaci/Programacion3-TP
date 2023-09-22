package org.fiuba.algoritmos3;

import java.util.HashMap;

public class Normal extends Tipo{

    public Normal(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }

    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Fantasma","Nula");
        this.tablaEfectividad.put("Roca","Debil");
    }
}


