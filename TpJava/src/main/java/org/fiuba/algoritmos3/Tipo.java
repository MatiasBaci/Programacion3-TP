package org.fiuba.algoritmos3;

import java.util.HashMap;

public abstract class Tipo {

    private String nombre;
    protected HashMap<String,String> tablaEfectividad;

    //Metodos:

    public Tipo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String compararseConTipo(Tipo unTipo){
        return this.tablaEfectividad.get(unTipo.getNombre());
    }

    public double calcularMultiplicadorDeDanio(Tipo unTipo){
    
        double multiplicador = 1;
        String efectividad = this.compararseConTipo(unTipo);
        switch (efectividad){
            case "Fuerte":
                multiplicador = 2;
                break;
            case "Debil":
                multiplicador = 0.5;
                break;
            case "Nula":
                multiplicador = 0;
                break;
        }
        return multiplicador;
    }

    public double calcularSTAB(Tipo unTipo){
        double STAB = 1;
        if(this.getNombre().equals(unTipo.getNombre())){
            STAB = 1.5;
        }
        return STAB;
    }

}
