package org.fiuba.algoritmos3;

import java.util.HashMap;

public abstract class Tipo {

    private static HashMap<String,Tipo> tipos = new HashMap<>();
    private String nombre;
    protected HashMap<String,String> tablaEfectividad;

    public Tipo(String nombre){
        this.nombre = nombre;
        this.tablaEfectividad = new HashMap<>();
    }

    // METODOS ESTATICOS------------------------------------------------------------:

    static {  // OJO: Esto funciona como un inicializador, Investigarlo mas a detalle para saber si esta correcto o no.
        tipos.put("Fuego", new Fuego("Fuego"));
        tipos.put("Agua", new Agua("Agua"));
        tipos.put("Normal", new Normal("Normal"));
        tipos.put("Planta", new Planta("Planta"));
        // Aqui se pueden agregar mas instancias de otros tipos.
    }

    public static Tipo getTipo(String nombre){ //Posible cambio en el nombre del metodo para más claridad
        return tipos.get(nombre);
    }
    // METODOS DE INSTANCIA------------------------------------------------------------:

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
        double STAB = 1.0;
        if(this.getNombre().equals(unTipo.getNombre())){
            STAB = 1.5;
        }
        return STAB;
    }

}
