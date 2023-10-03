package org.fiuba.algoritmos3;

public abstract class Estado {


    protected String nombre;


    public Estado(String nombre){
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }


    public abstract boolean puedeAtacar(Pokemon unPokemon);

    public abstract void aplicarEfectoPasivoDeEstado(Pokemon unPokemon);
}
