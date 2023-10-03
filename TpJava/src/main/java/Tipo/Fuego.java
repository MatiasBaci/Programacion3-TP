package Tipo;

import Tipo.Tipo;

public class Fuego extends Tipo { //extends de Tipo

    public Fuego(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo -- deberiaBorrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }
    @Override
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
