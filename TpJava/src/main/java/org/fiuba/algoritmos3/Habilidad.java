package org.fiuba.algoritmos3;

import java.util.HashMap;

public abstract class Habilidad {
    private static HashMap<String,Habilidad> tiposDeHabilidades = new HashMap<>();
    protected String nombre;
    protected int cantidadDeUsos;
    

    public Habilidad(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidadDeUsos = cantidad;
    }

    static {/* 
        tiposDeHabilidades.put("ataque",new HabilidadAtaque(this.nombre,this.tipo,this.poder,this.cantidadDeUsos));
        tiposDeHabilidades.put("estadistica",new HabilidadEstadistica());
        tiposDeHabilidades.put("estado",new HabilidadEstado());
 */
        // EL PROBLEMA AQUI SON LOS PARAMETROS DE CADA CONSTRUCTOR
    }

    public abstract void usarHabilidad(Pokemon unPokemonEnemigo,Pokemon unPokemonPropio);
}
