package org.fiuba.algoritmos3;

import java.util.HashMap;

public class Agua extends Tipo{ //extends de Tipo

    public Agua(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo ---> Deberia borrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }

//  public static void completarTablaEfectividad(){
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Agua","Debil");
        this.tablaEfectividad.put("Dragon","Debil");
        this.tablaEfectividad.put("Fuego","Fuerte");
        this.tablaEfectividad.put("Planta","Debil");
        this.tablaEfectividad.put("Roca","Fuerte");
        this.tablaEfectividad.put("Tierra","Fuerte");
    }
}