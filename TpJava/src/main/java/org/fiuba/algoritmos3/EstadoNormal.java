package org.fiuba.algoritmos3;

public class EstadoNormal extends Estado{

    public EstadoNormal(String nombre, int duracion){
        super(nombre, duracion);
    }


    public void efectoActivo(Pokemon unPokemon){

        System.out.println("El Pokemon esta normal y no tiene efectos negativos.");
    }

    public void efectoPasivo(Pokemon unPokemon){
        duracionActual = 0;
        nombre = "Normal";
    }
}
