package org.fiuba.algoritmos3;

import java.util.HashMap;

public abstract class Tipo {

    private String nombre;
    protected HashMap<String,String> tablaEfectividad;
    private static HashMap<String,Tipo> tipos = new HashMap<>();

    //Metodos:

    public Tipo(String nombre){
        this.nombre = nombre;
    }

    static {  // OJO: Esto funciona como un inicializador, Investigarlo mas a detalle para saber si esta correcto o no.
        tipos.put("Fuego", new Fuego("Fuego"));
        tipos.put("Agua", new Agua("Agua"));
        tipos.put("Normal", new Agua("Normal"));
        tipos.put("Planta", new Agua("Planta"));
        // Aqui se pueden agregar mas instancias de otros tipos.
    }

    public static Tipo getTipo(String nombre){ //Posible cambio en el nombre del metodo para más claridad
        return tipos.get(nombre);
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
