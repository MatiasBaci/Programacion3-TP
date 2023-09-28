package org.fiuba.algoritmos3;

public abstract class Estado {

    protected int duracionMaxima;

    protected int duracionActual;

    protected String nombre;

    public Estado(String nombre, int duracionMaima){
        this.nombre = nombre;
        this.duracionMaxima = duracionMaima;
        this.duracionActual = 0;
    }

    public abstract void efectoActivo(Pokemon unPokemon);

    public abstract void efectoPasivo(Pokemon unPokemon);


    public String getNombre() {
        return nombre;
    }

}
