package org.fiuba.algoritmos3;

import java.util.HashMap;

public abstract class Habilidad {
    private static HashMap<String,Habilidad> tiposDeHabilidades = new HashMap<>();
    private String nombre;
    private int cantidad;

    public Habilidad(String nombre,int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    static {
        /*tiposDeHabilidades.put("ataque",new HabilidadAtaque());
        tiposDeHabilidades.put("estadistica",new HabilidadEstadistica());
        tiposDeHabilidades.put("estado"new HabilidadEstado());*/

        // EL PROBLEMA AQUI SON LOS PARAMETROS DE CADA CONSTRUCTOR
    }

    public abstract void efectuarHabilidad(Pokemon unPokemon);
}
