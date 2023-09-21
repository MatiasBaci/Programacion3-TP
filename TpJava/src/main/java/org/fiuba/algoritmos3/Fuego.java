package org.fiuba.algoritmos3;

import java.util.HashMap;

public class Fuego extends Tipo{ //extends de Tipo

    public Fuego(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo
        this.tablaEfectividad = new HashMap<>();
    }

//  public static void completarTablaEfectividad(){
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Agua","Debil");
        this.tablaEfectividad.put("Bicho","Fuerte");
        this.tablaEfectividad.put("Dragon","Debil");
        this.tablaEfectividad.put("Fuego","Debil");
        this.tablaEfectividad.put("Hielo","Fuerte");
        this.tablaEfectividad.put("Planta","Fuerte");
        this.tablaEfectividad.put("Roca","Debil");
    }
}
